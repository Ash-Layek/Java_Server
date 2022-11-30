import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class log extends sprite  implements Runnable {

	private Boolean visible, isMoving;
	
	private JLabel logLabel, character1Label;
	
	private character1 Character1;
	
	private JButton startButton;
	
	private Thread thread;
	


	
	
	public log(){
		
		super(0,0,147,52,"Log.png");
		
		this.visible = true;
		
		this.isMoving = false;
	}
	
	
	
public void setLogLabel(JLabel temp) {
		
		this.logLabel = temp;
	}


public boolean getVisible() {
	
	
	return visible;
}

public void setVisible(Boolean temp) {
	
	this.visible = temp;
	
}

public void setCharacter1Label(JLabel temp) {
	
	this.character1Label = temp;
}


public void setCharacter1(character1 temp) {
	
	this.Character1 = temp;
}

public boolean getIsMoving() {
	
	return isMoving;
	
}




public void setIsMoving(Boolean temp) {
	
	
	this.isMoving = temp;
}


public void setStartButton(JButton temp) {
	
	
	this.startButton = temp;
}


public void detectLog() {
	
	

		
	
	
	

	if (r.intersects(Character1.getRectangle())) {
		
		
	
		
		System.out.println("ON LOG");
		
		
	  int currentX = this.x;
	
	   int currentY = this.y;
	
	

	if(currentY == gameProperties.Log1_Y) {
		
		
		Character1.setX(Character1.getX() - gameProperties.character_step);
		
	
	} else if (currentX == gameProperties.Log2_Y) {
		
		
		Character1.setX(Character1.getX() + gameProperties.ghost2_step);
		
		
	} else if (currentX == gameProperties.Log3_Y) {
		
		
		Character1.setX(Character1.getX() - gameProperties.ghost3_step);
		
		
		
		
	}
	
	this.character1Label.setLocation(this.getX(), this.getY());
	
			
	
		
	}
		
}
	


public void startMoving() {
	
	
	if (!this.isMoving) {
		
		thread = new Thread(this, "Log Thread ");
		
		thread.start();
		
		System.out.println("Log Thread starting");
		
		
	}
}

@Override
public void run() {
	// TODO Auto-generated method stub
	
	System.out.println("Thread started succesfully");
	
	this.isMoving = true;
	
	this.startButton.setText("STOP");
	
	this.character1Label.setIcon(new ImageIcon(getClass().getResource(Character1.getImage())));
	
	this.logLabel.setIcon(new ImageIcon(getClass().getResource(this.getImage())));
	

	

	while(this.isMoving) {
		
		
		int currentX = this.x;
		
		int currentY = this.y;
		
		
		if (currentY == gameProperties.Log1_Y) {
			
			
			currentX -= gameProperties.character_step;
			
			if (currentX <= - this.getWidth()) {
				
				currentX = 1 * gameProperties.screen_width;
			}
		}
		
		else if (currentY == gameProperties.Log2_Y) {
			
			
			currentX += gameProperties.ghost2_step;
			
			if (currentX >= gameProperties.screen_width) {
				
				
				currentX = -1 * gameProperties.screen_width;
			}
			
			
		} else if ( currentY == gameProperties.Log3_Y) {
			
			currentX -= gameProperties.ghost3_step;
			
                if (currentX <= -  this.getWidth()) {
				
				currentX = 1  * gameProperties.screen_width;
			}
		}
		
		
		this.setX(currentX);
	
		this.setY(currentY);
		
		this.updateRectanglePosition();
		
		
		
		
		if (this.visible) detectLog();
		
		this.logLabel.setLocation(currentX, this.y);
		
		
		
		try {
			
			Thread.sleep(75);
			
			// sleep;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		System.out.println("Log Thread Ended");
		
		System.out.print(Character1.getY());
		
		
		
	}
	
	
}


	
}
