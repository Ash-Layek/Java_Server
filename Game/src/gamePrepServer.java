

import java.awt.Color;
	import java.awt.Container;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

public class gamePrepServer  {

	


		
		
		private character1 Character1;
		
		private character2[] Character2 = new character2[4];
		
		private character2[] Character2_secondRow = new character2[4], Character2_thirdRow = new character2[4];
		
		private backgroundImage backgroundImage;
		
		private lava Lava;
		
		private log[] Log  = new log[4], secondRowLog = new log[4], thirdRowLog = new log[4];
		
		private Boolean wonCondition = false;
		
		private int intScore;
		
		private Db db;
		
		private String name, score;
		
		
		
		

		
		
		


		public static void main(String args []) throws IOException{
			
			final int CLIENT_PORT = 4870;
			
			final int SOCKET_PORT = 5300;
			
			
			
			ServerSocket server = new ServerSocket(SOCKET_PORT);
			
		
					
			
			System.out.println("Server Game Is Running");
		
			Thread t = new Thread( new Runnable() {
				public void run() {
					synchronized(this) {
					
						while (true) {
							
							
							
							try {
								
								Socket socket = server.accept();
								
								System.out.println("SERVER CONNECTED TO CLIENT");
								
								Scanner scan = new Scanner(socket.getInputStream());
								
								Socket clientSocket = new Socket("localhost", CLIENT_PORT);
								
								
								if (!scan.hasNext()) {
									
									
									return;
									
									
									
								} else {
									
								
										String command = scan.next();
										
									
										if (command.equals("hello")) {
											
											
											System.out.println("LQLAWI");
										} 
										
										else if (command.equals("UP")) {
											
											
											int number = scan.nextInt();
											
											System.out.println("LQHAB F DAR " + number);
											
											OutputStream outStream = clientSocket.getOutputStream();
											
											PrintWriter out  = new PrintWriter(outStream);
											
											out.println("zbi " + number);
											
											System.out.println("ZBI MSHA MN SERVER");
											
											
											
											 out.flush();
											
											
											
											
											
										}
										
										
										
									}
									
									
							} catch(Exception e) {
								
								
								
								System.out.println(e);
							}
							
						
						
						
					}
					
				}
				
				
				}});
			
			t.start();
			

	
	
	
				
		
		
	
	}
	
	
			
		
		
		
		
			public void DB_function() {
			
			
				
			       
			
		}
		
	}


