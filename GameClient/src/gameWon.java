import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameWon  {
	
	
	
	private JButton buttonn;
	
	
	public void setWin(JButton temp) {
		
		temp = new JButton("YOU LOST");
		
		temp.setSize(150,150);
		
		temp.setLocation(gameProperties.screen_width - 550 , gameProperties.screen_height - 650);
		
		
		temp.setFocusable(false);
		
		temp.setVisible(false);
		
		
		this.buttonn = temp;
		
		
	}
	
	public JButton getWin() {
		
		
		return buttonn;
	}
	

	
	
	
	
	
	
	
	
	
	

	
	
	

}
