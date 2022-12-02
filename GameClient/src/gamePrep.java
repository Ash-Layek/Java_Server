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
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class gamePrep extends JFrame implements KeyListener, ActionListener {

	
	
	private character1 Character1;
	
	int count = 0;
	
	private character1ClientService character1_C_Service;
	
	private character2[] Character2 = new character2[4];
	
	private Thread thread;
	
	private character2[] Character2_secondRow = new character2[4], Character2_thirdRow = new character2[4];
	
	private backgroundImage backgroundImage;
	
	private lava Lava;
	
	private log[] Log  = new log[4], secondRowLog = new log[4], thirdRowLog = new log[4];
	
	private Boolean wonCondition = false;
	
	final int CLIENT_PORT = 4780;
	
	private int intScore;
	
	private Db db;
	
	private Socket socket;
	
	private Scanner in;
	
	private PrintWriter out;
	
	private String name, score;
	final int SOCKET_PORT = 5300;
	
	
	private int x = 10;
	
	
	

	
	private JTextField user_name, user_score;


	
	

	

	
	
	
	
	

	
	
	// graphic elements
	
	private Container content;
	
	private JLabel character1Label, backgroundLabel, lavaLabel, scoreLabel, score_label, name_label;
	
	private JLabel[] character2Label = new JLabel[4], character2_secondRowLabel = new JLabel[4], logLabel = new JLabel[4], secondRowLabel = new JLabel[4];
	
	private JLabel[] thirdRowLabel = new JLabel[4], character2_thirdRowLabel = new JLabel[4];
	
	
	
	private ImageIcon character1Image, character2Image, backgroundImg, lavaImg, logImg;
	private JButton startButton;
	
	private JButton wonGameButton, submitButton;
	
	gameWon gamewon;
	
	private JButton visibilityButton;
	
	
	
	
	public gamePrep() {
		
	
		// set character 1
		
		Character1 = new character1();
		
		Character1.setX(350);
		
		Character1.setY(700);
		
		Character1.setHeight(80);
		
		Character1.setWidth(80);
		
		Character1.setImage("girlRun.gif");
		
		Character1.updateRectangleSize();
		
		Character1.updateRectanglePosition();
		
		// character 2
		
		
		Character2[0] = new character2();
		
		Character2[0].setY(gameProperties.ghost1_Y);
		
		Character2[0].setX(0);
		
		Character2[0].setHeight(65);
		
		Character2[0].setWidth(65);
		
		Character2[0].setImage("Ghost.gif");
		
		Character2[0].setCharacter1(Character1);
		
		Character2[0].updateRectangleSize();
		
		Character2[0].updateRectanglePosition();
		
		// 2 / 1
		
        Character2[1] = new character2();
		
		Character2[1].setY(Character2[0].getY());
		
		Character2[1].setX(Character2[0].getX() - 200);
		
		Character2[1].setHeight(65);
		
		Character2[1].setWidth(65);
		
		Character2[1].setImage("Ghost.gif");
		
		Character2[1].setCharacter1(Character1);
		
		Character2[1].updateRectangleSize();
		
		Character2[1].updateRectanglePosition();
		
		
		
		// 2 / 2
		
		    Character2[2] = new character2();
			
			Character2[2].setY(Character2[0].getY());
			
			Character2[2].setX(Character2[1].getX() - 200);
			
			Character2[2].setHeight(65);
			
			Character2[2].setWidth(65);
			
			Character2[2].setImage("Ghost.gif");
			
			Character2[2].setCharacter1(Character1);
			
			Character2[2].updateRectangleSize();
			
			Character2[2].updateRectanglePosition();
			// 
			
			 Character2[3] = new character2();
				
				Character2[3].setY(Character2[0].getY());
				
				Character2[3].setX(Character2[2].getX() - 200);
				
				Character2[3].setHeight(65);
				
				Character2[3].setWidth(65);
				
				Character2[3].setImage("Ghost.gif");
				
				Character2[3].setCharacter1(Character1);
				
				Character2[3].updateRectangleSize();
				
				Character2[3].updateRectanglePosition();
			
				
				// ----------------------- Score label
				
				
				scoreLabel  = new JLabel();
				
				scoreLabel.setSize(100, 100);
				
				scoreLabel.setLocation(0, 10);
				
				scoreLabel.setFont(new Font("Calibri", Font.BOLD, 20));
				
				scoreLabel.setForeground(Color.GREEN);
				
				scoreLabel.setText("Score : " + intScore);
				
				
				// ---------------------------------------
				
			
				
				
				
				
				user_name = new JTextField();
				
				user_name.setBounds(0, 30, 200, 200);
				
				user_name.setVisible(false);
				
				
			
				user_score = new JTextField();
				
				user_score.setBounds(500,30,200,200);
				
				user_score.setVisible(false);
				
				// -----------------------------
				
				score_label = new JLabel();
				
				score_label.setSize(100,100);
				
				score_label.setLocation(1,30);
				
				score_label.setText("Enter Name");
				
				score_label.setFont(new Font("Calibri", Font.BOLD, 20));
				
				scoreLabel.setForeground(Color.BLUE);
				
				score_label.setVisible(false);
				
				
				
				// ----------------------- 
				
				
                name_label = new JLabel();
				
				name_label.setSize(100,100);
				
				name_label.setLocation(520,30);
				
				name_label.setText("Enter score");
				
				name_label.setFont(new Font("Calibri", Font.BOLD, 20));
				
				name_label.setForeground(Color.BLUE);
				
				name_label.setVisible(false);
				
				
				
				
			
			
		// log test
			
			
			for (int i = 0; i < 4 ; i++) {
				
			
				Log[i] = new log();
				
				secondRowLog[i] = new log();
				
				thirdRowLog[i] = new log();
				
				
				if (i == 0) {
					
					Log[i].setY(gameProperties.Log1_Y);
					
					Log[i].setX(gameProperties.Log1_X);
					
					
					secondRowLog[i].setY(gameProperties.Log2_Y);
					
					secondRowLog[i].setX(gameProperties.Log2_X);
					
					thirdRowLog[i].setY(gameProperties.Log3_Y);
					
					thirdRowLog[i].setX(gameProperties.Log3_X);
					
					
					
				} else if (i == 1) {
					
					
                     Log[i].setY(gameProperties.Log1_Y);
					
					Log[i].setX(Log[0].getX() - 150);
					
                    secondRowLog[i].setY(gameProperties.Log2_Y);
					
					secondRowLog[i].setX(secondRowLog[0].getX() - 185);
					
					thirdRowLog[i].setY(gameProperties.Log3_Y);
					
					thirdRowLog[i].setX(thirdRowLog[0].getX() - 185);
					
				} else if ( i == 2) {
					
					
					 Log[i].setY(gameProperties.Log1_Y);
					 
					 Log[i].setX(Log[0].getX() + 185);
					 
					  secondRowLog[i].setY(gameProperties.Log2_Y);
						
						secondRowLog[i].setX(secondRowLog[0].getX() + 185);
						
						thirdRowLog[i].setY(gameProperties.Log3_Y);
						
						thirdRowLog[i].setX(thirdRowLog[0].getX() + 150);
					
					
				} else if (i == 3) {
					
					
					Log[i].setY(gameProperties.Log1_Y);
					
					Log[i].setX(Log[2].getX() + 185 );
					
					 secondRowLog[i].setY(gameProperties.Log2_Y);
						
						secondRowLog[i].setX(secondRowLog[2].getX() + 185);
						
	
						thirdRowLog[i].setY(gameProperties.Log3_Y);
						
						thirdRowLog[i].setX(thirdRowLog[2].getX() + 185 );
						
				}
				
				
				
				
				
				Log[i].setHeight(52);
				
				
				Log[i].setWidth(147);
				
				Log[i].setImage("Log.png");
				
				Log[i].setCharacter1(Character1);
				
				Log[i].updateRectanglePosition();
				
				Log[i].updateRectangleSize();
				
				//------------------------------
				
				secondRowLog[i].setHeight(52);
				
				secondRowLog[i].setWidth(147);
				
				secondRowLog[i].setCharacter1(Character1);
				
				secondRowLog[i].setImage(Log[0].getImage());
				
				secondRowLog[i].updateRectanglePosition();
				
				secondRowLog[i].updateRectangleSize();
				
				//------------------------
				
				
				thirdRowLog[i].setHeight(52);
				
				thirdRowLog[i].setWidth(147);
				
				thirdRowLog[i].setCharacter1(Character1);
				
				thirdRowLog[i].setImage(Log[0].getImage());
				
				thirdRowLog[i].updateRectanglePosition();
				
				thirdRowLog[i].updateRectangleSize();
				
			}
			
			
		
			
			
			// ------------------------
			
			
			// Second row of ghosts 
			
			
			for (int i = 0; i < 4; i++) {
				
				Character2_thirdRow[i] = new character2();
				Character2_secondRow[i] = new character2();
				
				if (i == 0) {
					
					Character2_secondRow[i].setY(gameProperties.ghost2_Y);
					
					Character2_secondRow[i].setX(0);
					
					Character2_thirdRow[i].setY(gameProperties.ghost3_Y);
					
					Character2_thirdRow[i].setX(0);
					
					
				} else if (i == 1){
					
					Character2_secondRow[i].setY(Character2_secondRow[0].getY());
					
					Character2_secondRow[i].setX(Character2_secondRow[0].getX() - 200);
					
					Character2_thirdRow[i].setY(Character2_thirdRow[0].getY());
					
					
					Character2_thirdRow[i].setX(Character2_thirdRow[0].getX() - 200);
					
				} else if (i == 2) {
					
                    Character2_secondRow[i].setY(Character2_secondRow[0].getY());
					
					Character2_secondRow[i].setX(Character2_secondRow[1].getX() - 200);
					
                  Character2_thirdRow[i].setY(Character2_thirdRow[0].getY());
					
					
					Character2_thirdRow[i].setX(Character2_thirdRow[0].getX() - 200);
					
					
				} else if (i == 3) {
					
                     Character2_secondRow[i].setY(Character2_secondRow[0].getY());
					
					Character2_secondRow[i].setX(Character2_secondRow[2].getX() - 200);
					
                        Character2_thirdRow[i].setY(Character2_thirdRow[0].getY());
					
					
					Character2_thirdRow[i].setX(Character2_thirdRow[0].getX() - 200);
					
				}
				
				
				
				Character2_secondRow[i].setHeight(Character2[0].getHeight());
				
				Character2_secondRow[i].setWidth(Character2[0].getWidth());
				
				Character2_secondRow[i].setImage(Character2[0].getImage());
				
				Character2_secondRow[i].setCharacter1(Character1);
				
				Character2_secondRow[i].updateRectangleSize();
				
				Character2_secondRow[i].updateRectanglePosition();
				
				
				// _____________________
				
             Character2_thirdRow[i].setHeight(Character2[0].getHeight());
				
				Character2_thirdRow[i].setWidth(Character2[0].getWidth());
				
				Character2_thirdRow[i].setImage(Character2[0].getImage());
				
				Character2_thirdRow[i].setCharacter1(Character1);
				
				Character2_thirdRow[i].updateRectangleSize();
				
				Character2_thirdRow[i].updateRectanglePosition();
		
				
				
			}
		
		
		//
		
		backgroundImage = new backgroundImage();
		
		backgroundImage.setHeight(800);
		
		backgroundImage.setWidth(900);
		
		backgroundImage.setImage("Darkterrain.jpg");
		
		
		// set up second background image : Water / Lava
		
		Lava = new lava();
		
		Lava.setHeight(300);
		
		Lava.setWidth(900);
		
		Lava.setY(0);
		
		Lava.setImage("Lava.gif");
		
		
		
		// ----------------------
		
		
		submitButton = new JButton("Submit");
		
		submitButton.setSize(100,100);
		
		submitButton.setLocation(190, 450);
		
		submitButton.setFocusable(true);
		
		submitButton.setVisible(false);
		
	
	// set up the screen
		
		setSize(gameProperties.screen_width, gameProperties.screen_height);
		
		content = getContentPane();
		
		content.setBackground(Color.GRAY);
		
		
		setLayout(null);
		
		
		// graphic elements added to the screen
		
		character1Label  = new JLabel();
		
		character1Image = new ImageIcon(getClass().getResource(Character1.getImage()));
		
		character1Label.setIcon(character1Image);
		
		character1Label.setSize(Character1.getWidth(), Character1.getHeight());
		
		character1Label.setLocation(Character1.getX(), Character1.getY());
		
		// second row 
		
		for (int i = 0 ; i < 4; i ++) {
			
			
			Character2[i].setCharacter1Label(character1Label);
			
			
			Character2_secondRow[i].setCharacter1Label(character1Label);
			
			Character2_thirdRow[i].setCharacter1Label(character1Label);
			
			Log[i].setCharacter1Label(character1Label);
			
			secondRowLog[i].setCharacter1Label(character1Label);
			
			thirdRowLog[i].setCharacter1Label(character1Label);
			
		}
		
		
		
		// graphic elements label for log
		
		
	   for (int  i = 0; i < 4; i++) {
		   
		   
		   logLabel[i] = new JLabel();
			
			logImg = new ImageIcon(getClass().getResource(Log[i].getImage()));
			
			logLabel[i].setIcon(logImg);
			
			logLabel[i].setSize(Log[i].getWidth(), Log[i].getHeight());
			
			logLabel[i].setLocation(Log[i].getX(), Log[i].getY());
			
			Log[i].setLogLabel(logLabel[i]);
			
			//------------------
			
			secondRowLabel[i] = new JLabel();
			
			secondRowLabel[i].setIcon(logImg);
			
			secondRowLabel[i].setSize(secondRowLog[i].getWidth(), secondRowLog[i].getHeight());
			
			secondRowLabel[i].setLocation(secondRowLog[i].getX(), secondRowLog[i].getY());
			
			secondRowLog[i].setLogLabel(secondRowLabel[i]);
			
			// ---------------------------------
			
			
			thirdRowLabel[i] = new JLabel();
			
			thirdRowLabel[i].setIcon(logImg);
			
			thirdRowLabel[i].setSize(thirdRowLog[i].getWidth(), thirdRowLog[i].getHeight());
			
			thirdRowLabel[i].setLocation(thirdRowLog[i].getX(), thirdRowLog[i].getY());
			
			thirdRowLog[i].setLogLabel(thirdRowLabel[i]);
			
			

		   
	   }
		
		
		
	
	
		
	
		
		
		
		
		
		// graphic elements for character2
				
		character2Label[0] = new JLabel();
		
		
		character2Image = new ImageIcon(getClass().getResource(Character2[0].getImage()));
		
		character2Label[0].setIcon(character2Image);
		
		character2Label[0].setSize(Character2[0].getWidth(), Character2[0].getHeight());
		
		character2Label[0].setLocation(Character2[0].getX(), Character2[0].getY());
		
		Character2[0].setCharacter2Label(character2Label[0]);
		
		// ----------------------
		
		character2Label[1] = new JLabel();
		
		character2Label[1].setIcon(character2Image);
		
		character2Label[1].setSize(Character2[1].getWidth(), Character2[1].getHeight());
		
		character2Label[1].setLocation(Character2[1].getX(), Character2[1].getY());
		
		Character2[1].setCharacter2Label(character2Label[1]);
		
		// -------------
		
        character2Label[2] = new JLabel();
		
		character2Label[2].setIcon(character2Image);
		
		character2Label[2].setSize(Character2[1].getWidth(), Character2[1].getHeight());
		
		character2Label[2].setLocation(Character2[2].getX(), Character2[2].getY());
		
		Character2[2].setCharacter2Label(character2Label[2]);
		
		//-------------
		
        character2Label[3] = new JLabel();
		
		character2Label[3].setIcon(character2Image);
		
		character2Label[3].setSize(Character2[1].getWidth(), Character2[1].getHeight());
		
		character2Label[3].setLocation(Character2[3].getX(), Character2[3].getY());
		
		Character2[3].setCharacter2Label(character2Label[3]);
		
		
		// Label for second row of ghosts
		
		
		for (int i = 0; i < 4; i++) {
			
			
			character2_secondRowLabel[i] = new JLabel();
			
			character2_secondRowLabel[i].setIcon(character2Image);
			
			character2_secondRowLabel[i].setSize(Character2[0].getWidth(), Character2[0].getHeight());
			
			character2_secondRowLabel[i].setLocation(Character2_secondRow[0].getX(), Character2_secondRow[0].getY());
			
			Character2_secondRow[i].setCharacter2Label(character2_secondRowLabel[i]);
			
			
			// ------------------------------------ 
			
			
			
			character2_thirdRowLabel[i] = new JLabel();
			
			character2_thirdRowLabel[i].setIcon(character2Image);
			
			character2_thirdRowLabel[i].setSize(Character2[0].getWidth(), Character2[0].getHeight());
			
			character2_thirdRowLabel[i].setLocation(Character2_thirdRow[0].getX(), Character2_thirdRow[0].getY());
			
			Character2_thirdRow[i].setCharacter2Label(character2_thirdRowLabel[i]);
			
			
		}
		
		
		//background label
		
		backgroundLabel = new JLabel();
		
		backgroundImg = new ImageIcon(getClass().getResource(backgroundImage.getImage()));
		
		backgroundLabel.setIcon(backgroundImg);
		
		backgroundLabel.setSize(backgroundImage.getWidth(), backgroundImage.getHeight());
		
		
		
		
		//second background label
		
		lavaLabel  = new JLabel();
		
		lavaImg = new ImageIcon(getClass().getResource(Lava.getImage()));
		
		lavaLabel.setIcon(lavaImg);
		
		lavaLabel.setSize(Lava.getWidth(), Lava.getHeight());
		
		
		
		// add a start button
		
		
		startButton = new JButton("start");
		
		startButton.setSize(100, 100);
		
		startButton.setLocation(gameProperties.screen_width - 120, gameProperties.screen_height - 180);
		
		startButton.setFocusable(false);
		
		for (int i = 0 ; i < 4;  i++) {
			
			Character2[i].setStartButton(startButton);
			
			Character2_secondRow[i].setStartButton(startButton);
			
			Character2_thirdRow[i].setStartButton(startButton);
			
			Log[i].setStartButton(startButton);
			
			secondRowLog[i].setStartButton(startButton);
			
			thirdRowLog[i].setStartButton(startButton);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		// add hide button
		
		visibilityButton = new JButton("hide");
		
		visibilityButton.setSize(100,100);
		
		visibilityButton.setLocation(gameProperties.screen_width - 220, gameProperties.screen_height - 180);
		
		visibilityButton.setFocusable(false);
		
		
		// populate screen
		
		
		gamewon = new gameWon();
		
		gamewon.setWin(wonGameButton);
		
		gamewon.getWin();
		
		
		wonGameButton = gamewon.getWin();
		
		
		
		for (int i = 0 ; i < 4; i++) {
			
			Character2[i].setRestartButton(wonGameButton);
			
			Character2_secondRow[i].setStartButton(wonGameButton);
			
			Character2_thirdRow[i].setStartButton(wonGameButton);
		}
		
		
		
		
		
	
	
	
		add(wonGameButton);
		
		add(submitButton);
		
		add(scoreLabel);
		
		add(startButton);
		
        add(name_label);
		
		add(score_label);
		
		add(user_name);
		
		add(user_score);
		
		
		
		startButton.addActionListener(this);
		
		submitButton.addActionListener(this);
		
		add(visibilityButton);
		
		visibilityButton.addActionListener(this);
		
		wonGameButton.addActionListener(this);
		
	
		
		add(character1Label);
		
		
		for (int i = 0 ; i < 4 ; i++) {
			
			
			
			
			
			add(character2Label[i]);
			
			add(character2_secondRowLabel[i]);
			
			add(character2_thirdRowLabel[i]);
			
			
			 add(logLabel[i]);
			
			add(secondRowLabel[i]);
			
			add(thirdRowLabel[i]);
			
			
		
		}
		
	
	
		// add(wonGameButton)
		
		 add(lavaLabel);
		
	
		add(backgroundLabel);
		
	
		
		
		
	
		content.addKeyListener(this);
		
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	



	public static void main(String args []){
		
		gamePrep myGame = new gamePrep();
		
		myGame.setVisible(true);
		
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	
	
	public void keyPressed(KeyEvent e )   {
		
		
		
		
		Thread t1 = new Thread ( new Runnable () {
			public void run () {
				synchronized(this) {
					

				   
					
					System.out.println("Waiting for server responses...");
						
						try {
						
							 int x = Character1.getX();
							    
								int y = Character1.getY();
							
							Socket s2 = new Socket("localhost", SOCKET_PORT);
							
							
							
							OutputStream outStream = s2.getOutputStream();
							
								PrintWriter out  = new PrintWriter(outStream);
								
								
								
								
								if (e.getKeyCode() == KeyEvent.VK_UP) {
									
									y -= gameProperties.MC_step;
									
									if (y + Character1.getHeight() <= 0) {
										
										y = gameProperties.screen_height;
									}
									
									out.println("Y " + y);
									
								
									System.out.println("Y is sent");
									
								} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
									
									x -= gameProperties.MC_step;
									
									if (x + Character1.getWidth() <= 0) {
										
										x = gameProperties.screen_width;
									}
									
									out.println("X " + x);
									
								} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
									
									
									y+=  gameProperties.MC_step;
									
									
									if (y  >= gameProperties.screen_height) {
										
										
										y = -1 * Character1.getHeight();
										
									}
									
									out.println("Y " + y);
									
									
								} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
									
									
									x += gameProperties.MC_step;
									
									
									if (x >= gameProperties.screen_width) {
										
										
										x = -1 * Character1.getWidth();
										
									}
									
									out.println("X " + x);
								}
								
								
							//	out.println("Y " + y);
								
								
								out.flush();
								
								
								
							
					
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						try {
							
							System.out.println("Trying to receive data from server");
						
		
							ServerSocket server = new ServerSocket(CLIENT_PORT);
							
							System.out.println("CLIENT SERVER UP");
							
							
									Socket socketClient = server.accept();
									
									System.out.println("ClIENT SERVER CONNECTED");
									
									character1ClientService character1_C_Service = new character1ClientService(socketClient);
									
									character1_C_Service.setCharacter1(Character1);
									
									character1_C_Service.setCharacter1Label(character1Label);
									
									Thread t2 = new Thread(character1_C_Service);
									
									t2.start();
									
									
									
								/*	
									Scanner scan = new Scanner(socketClient.getInputStream());
									
						
									
									String command = scan.next();
									
									
									
									if (!scan.hasNext()) {
										
										
										System.out.println("NO DATA");
										
										
									} else {
										
										
										if (command.equals("number")) {
											
											int number = scan.nextInt();							
											
											System.out.println("CLIENT RECEIVED NUMBER FROM SERVER  " + number);
										}
										

										
										
									}
									*/
									server.close();
									
									
									
								} catch (Exception d) {
									
								
								}
								
						
						System.out.println("client connected");
						
					}

					
				}
			
		});
		t1.start();
		
	
		
	
	
		
		
	
		System.out.println("TEST1");
		
		
				
				

			
		

	
		
		
		
		
		/*
		 * 
		 * 
		 * 
		 * 
		
	
		
			
			
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			x -= gameProperties.MC_step;
			
			if (x + Character1.getWidth() <= 0) {
				
				x = gameProperties.screen_width;
			}
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			
			y+=  gameProperties.MC_step;
			
			
			if (y  >= gameProperties.screen_height) {
				
				
				y = -1 * Character1.getHeight();
				
			}
			
			
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			
			x += gameProperties.MC_step;
			
			
			if (x >= gameProperties.screen_width) {
				
				
				x = -1 * Character1.getWidth();
				
			}
			
			
		} else {
			
			
			
			System.out.println("Invalid");
			
			
		}
		
		*/
		
	
	
	
	
	//Character1.setX(x);
	
	//Character1.setY(y);
	/*
	
	Character1.updateRectanglePosition();
	
	character1Label.setLocation(Character1.getX(), Character1.getY());
	
	 gameWon();
	
	*/

		}
	
	
	
	
	

		
	
	


	@Override
	public void actionPerformed(ActionEvent e)  {
		// 
		
		for ( int i  = 0 ; i < 4 ; i++) {
			
			
		if (e.getSource() == startButton) {
			
			if (Character2[i].getIsMoving()) {
				
				Character2[i].setIsMoving(false);
				
				Character2_secondRow[i].setIsMoving(false);
				
				Character2_thirdRow[i].setIsMoving(false);
				
				Log[i].setIsMoving(false);
				
				secondRowLog[i].setIsMoving(false);
				
				thirdRowLog[i].setIsMoving(false);
				
			
			
			} else {
				
				Character2[i].startMoving();
				
				Character2_secondRow[i].startMoving();
				
				Character2_thirdRow[i].startMoving();
				
				Log[i].startMoving();
				
				secondRowLog[i].startMoving();
				
				thirdRowLog[i].startMoving();
				
			
			}
			
		} else if (e.getSource() == visibilityButton) {
			
			
			
			if (Character2[i].getVisible()) {
				
				
				Character2[i].setVisible(false);
				
			
				
				Character2_secondRow[i].setVisible(false);
				
				Character2_thirdRow[i].setVisible(false);
				
				Log[i].setVisible(false);
				
				secondRowLog[i].setVisible(false);
				
				thirdRowLog[i].setVisible(false);
				
				
				character2Label[i].setVisible(Character2[i].getVisible());
				
				character2_secondRowLabel[i].setVisible(Character2_secondRow[i].getVisible());
				
				character2_thirdRowLabel[i].setVisible(Character2_secondRow[i].getVisible());
				
				logLabel[i].setVisible(Log[i].getVisible());
				
				secondRowLabel[i].setVisible(secondRowLog[i].getVisible());
				
				thirdRowLabel[i].setVisible(thirdRowLog[i].getVisible());
				
				visibilityButton.setText("show");
				
				
			} else {
				
				Character2[i].setVisible(true);
				
				Character2_secondRow[i].setVisible(true);

				Character2_thirdRow[i].setVisible(true);
				
				Log[i].setVisible(true);
				
				secondRowLog[i].setVisible(true);
				
				thirdRowLog[i].setVisible(true);
				
				
				character2Label[i].setVisible(Character2[i].getVisible());
				
				character2_secondRowLabel[i].setVisible(Character2_secondRow[i].getVisible());
				
				character2_thirdRowLabel[i].setVisible(Character2_thirdRow[i].getVisible());
				
				logLabel[i].setVisible(Log[i].getVisible());
				
				secondRowLabel[i].setVisible(secondRowLog[i].getVisible());
				
				thirdRowLabel[i].setVisible(thirdRowLog[i].getVisible());
				
				
				visibilityButton.setText("hide");
			}
		}
		
		}
		
		
		
		
		if (e.getSource() == wonGameButton) {
			
			
			
			
         						lostGame();
         						
         						for (int i = 0; i < 4; i++) {
         							
         						
         						
         						Character2[i].setIsMoving(false);
         						
         						Character2_secondRow[i].setIsMoving(false);
         						
         						Character2_thirdRow[i].setIsMoving(false);
         						
         						Log[i].setIsMoving(false);
         						
         						secondRowLog[i].setIsMoving(false);
         						
         						thirdRowLog[i].setIsMoving(false);
         						
         						wonGameButton.setVisible(false);
         						
         						}
       
			
			
		}
		
		
		if (e.getSource() == submitButton) {
			
			
	        // TODO Auto-generated method stub
	       
	            name = user_name.getText();
	            score = user_score.getText();

	            Db db = new Db();
	            
	            db.setName(name);

	            int Scory= Integer.parseInt(score);
	            
	            db.setScore(Scory);
	            

	            db.Insert();
	            
	            submitButton.setVisible(false);
	            
	                  

	    }
	}
		
		
		
	

	
	


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void lostGame() {
		
		
		
		Character1.setX(350);
		
		Character1.setY(700);
		
		character1Label.setLocation(Character1.getX(), Character1.getY());
		
		
	}
	
	
	public void gameWon() {
		
      
		if (Character1.getY() <= 20) {
			
			
		
			wonGameButton.setVisible(true);
			
			
			
			   intScore = 50;
				
				
				scoreLabel.setText("Score :" + intScore);
				
				
				user_score.setVisible(true);
				
				user_name.setVisible(true);
				
				score_label.setVisible(true);
				
				name_label.setVisible(true);
				
				submitButton.setVisible(true);
			
			
		}
	}
		
		
		
		public void DB_function() {
		
		
			
		       
		
	}





	
		
		
	






	
}
