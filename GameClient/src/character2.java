import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class character2 extends sprite implements Runnable {
     
   private boolean visible, isMoving;
   
   private Thread thread;
   
   private JLabel character2Label, character1Label;
   
   private character1 Character1;
   
   private JButton startButton;
   
   private lava Lava;
   
   private Boolean inter = false;
   
   
   private JButton button;
	
	public  character2(){
    	  super(0,0,65,65,"Ghost.gif");
    	  
    	  this.visible = true;
    	  
    	  this.isMoving = false;
    	  
      }
	
	
	public void setCharacter2Label(JLabel temp) {
		
		this.character2Label = temp;
	}
	
	
	
	public void setCharacter1Label(JLabel temp) {
		
		this.character1Label = temp;
	}
	
	
	public void setRestartButton(JButton temp) {
		
		
		this.button = temp;
	}
	
	
	
	public void setCharacter1(character1 temp) {
		
		this.Character1  = temp;
	}
	
	public void setStartButton(JButton temp) {
		
		this.startButton = temp;
	}
	
	
	public Boolean getVisible() {
		
		return visible;
	}
	
	
	public void setVisible(Boolean temp) {
		
		this.visible = temp;
	}
	
	
	
	public Boolean getIsMoving() {
		
		return isMoving;
	}
	
	public void setIsMoving(Boolean temp) {
		
		
		this.isMoving = temp;
	}
	
	
	public void show() {
		
		
		this.visible = true;
	}
	
	public void hide() {
		
		this.visible = false;
	}
	
	
	public Boolean getInter() {
		
		return inter;
	}
	
	public void setInter(Boolean temp) {
		
		this.inter = temp;
	}
	
	public void startMoving()
	{
		
		System.out.println("move");
		
		if (!this.isMoving) {
			
			
			thread = new Thread(this, "Character 2 Thread");
			
			thread.start();
			
		}
		
	}
	
  
	public void displayLocation() {
		
		System.out.println("x,y: " + this.x + "," + this.y);
		System.out.println(  Character1.getY());
		System.out.println("width,height: " + this.width + "," + height);
		System.out.println("image: " + this.image);
		//super.Display();
		System.out.println("visible: " + this.visible);
		System.out.println("moving: " + this.isMoving);
		
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Thread Started");
		
		this.isMoving = true;
		
		this.startButton.setText("STOP");
		
		this.character1Label.setIcon(new ImageIcon(getClass().getResource(Character1.getImage())));
		
		this.character2Label.setIcon(new ImageIcon(getClass().getResource(this.getImage())));
		
		
		
		while (this.isMoving) {
			
			int currentX = this.x;
			
			int rowX = this.x;
			
			
			
			int currentY = this.y;
			
			
			
			
			// move character 2 while isMoving = true;
			
			
			if (currentY > 400) {
				
				currentX += gameProperties.character_step ;
				 
				 if (currentX >= gameProperties.screen_width) {
						currentX = -1 * this.width;
					}
				 
				 
				 
				 
				 this.setX(currentX);
				 
			
			}
			
			 
			 
			 if (this.getY() == gameProperties.ghost2_Y) {
				 
				 rowX += gameProperties.ghost2_step;
				 
				 
				 if (rowX >= gameProperties.screen_width) {
						rowX = -1 * this.width;
					}
				 
				 
				 
				 
				 
				 
				 this.setX(rowX);
				 
			 }
			 
           if (this.getY() == gameProperties.ghost3_Y) {
				 
				 rowX += gameProperties.ghost2_step;
				 
				 
				 if (rowX >= gameProperties.screen_width) {
						rowX = -1 * this.width;
					}
				 
				 
				 
				 this.setX(rowX);
				 
			 }
			 
			 
			 
			 
			 
			 
			
			 
			 this.updateRectanglePosition();
			 
			
		    
			
			 
			// displayLocation();
			 
			 // check collision
			 
			if (this.visible) {
				
				this.detectCollision();
				
				
			}
			 
		
				
		this.character2Label.setLocation(this.x, this.y);
				
				
	
				try {
					
					Thread.sleep(100);
					
					
					
					 
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
		}
		
		System.out.println("End Thread");
		this.startButton.setText("Start");
		
		
	}
	
	
	private void detectCollision() {
		
		
		if (r.intersects(Character1.getRectangle())) {
			
	
			
			button.setVisible(true);
			

			
			System.out.println("BOOM");
			
			
			
		//	System.out.print(Character1.getRectangle());
			
			//System.out.print(this.getRectangle());
			
			
			
		}
		
		
		
		

	
		
		
	}
	
	
	
	
	
	
 
	
	
}
