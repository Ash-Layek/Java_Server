import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class character1ServerService implements Runnable {

	
	final int CLIENT_PORT = 4780;
	
	private Socket s;
	private Scanner in;
	
	private character1 Protagonist;
	
	
	
	
	
	
	public character1ServerService(Socket s) {
		
		this.s = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	System.out.println("character1 Thread is running");
		
		try {
			in = new Scanner(s.getInputStream());
			processRequest();
						
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			
			try {
				s.close();
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
	}



	
	public void processRequest() throws IOException{
		
		
		System.out.println("Process function works");
		
		while(true) {
			
			
			if(!in.hasNext()) {
				
				
				return;
				
			} 
			
			
			String command = in.next();
			
			
			if (command.equals("QUIT")) {
				
				
				return;
				
				
			} else {
				
				executeCommand(command);
				
				
			}
			
			
		}
		
	}

	
	
	
	public void executeCommand(String command) throws IOException{
		
		
	Socket s2 = new Socket("localhost", CLIENT_PORT);
		
		
		OutputStream outStream = s2.getOutputStream();
		
		PrintWriter out = new PrintWriter(outStream);
		
		
		
		
		
		if (command.equals("Y")) {
			
			int numberY = in.nextInt();
			
			System.out.println("COMMAND RECEIVED FROM SERVER / Y : " + numberY);
			
			
			
			
			String InfoY = "PLAYER Y " + numberY;
			
		    out.println(InfoY);
			
			
			
		} else if (command.equals("X")) {
			
			
			
			
			int numberX = in.nextInt();
			
			System.out.println("COMMAND RECEIVED FROM SERVER / X : " + numberX);
			
			String InfoX = "PLAYER X " + numberX;
			
			out.println(InfoX);
			
			
		}
	
		
	
		
		System.out.println("Sending info from server to client");
		

	
		
		out.flush();
		
		s2.close();
		
      
		
		
		
		
	}
	
	
}
