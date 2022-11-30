
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Db {
	
	Connection conn = null;
	Statement stmt = null;
	private String Name;
	private int Score;
		

		public void setScore(int scory) {
		    this.Score = scory;
		}
		
		public int getScore() {
			return Score;
		}
		
		public void setName(String User) {
		    this.Name = User;
		}
		
		public String getName() {
			return Name;
		}
		
		public void Insert() {
			try {
			Connection conn = null;
			Statement stmt = null;
			
			//load the SQL driver
			
			//create a connection string and connect to DB
			String DB_URL = "jdbc:sqlite:DATA_DB.db";
			
			conn = DriverManager.getConnection(DB_URL);
			
			if(conn != null)
			{
				System.out.println("Connected to database");
				conn.setAutoCommit(false);
			
			
				//create statement to execute
				stmt = conn.createStatement();
				String sql = "INSERT INTO TBL_USER (USER_NAME, SCORE) VALUES " +
				"('"+this.getName()+ "'," +this.getScore()+")";
				
			
				//Execute the statement
				stmt.executeUpdate(sql);
				conn.commit();
			
							
				sql = "SELECT * FROM  TBL_USER";
				ResultSet rs = stmt.executeQuery(sql);
				DisplayRecords(rs);
				rs.close();
							
				
				conn.close();
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}		
		
		public void DB_METHOD() {
			try {
						
				//load the SQL driver
				Class.forName("org.sqlite.JDBC");

				
				//create a connection string and connect to DB
				String DB_URL = "jdbc:sqlite:DATA_DB.db";
				conn = DriverManager.getConnection(DB_URL);
				
				if(conn != null)
				{
					System.out.println("Connected to database");
					conn.setAutoCommit(false);
					
					
					//create statement to execute
					stmt = conn.createStatement();
					String sql = "CREATE TABLE IF NOT EXISTS TBL_USER " +
							 "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
							 " USERNAME TEXT NOT NULL, " + 						
							 " SCORE INT NOT NULL)";
				
					//Execute the statement
					stmt.executeUpdate(sql);
					conn.commit();
				
					conn.close();
					
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		}	
		
		
	public static void DisplayRecords(ResultSet rs) throws SQLException {
		 while ( rs.next() ) 
		 {
			
			 String name = rs.getString("USER_NAME");
			 int score = rs.getInt("SCORE");

			 System.out.println("Player name = " + name);
			 System.out.println("Player Score = " + score);
			 System.out.println();
		 }
	}

		}


