import java.awt.Rectangle;

public class sprite {
      
	protected int x, y;
	
	protected int height, width;
	
	protected String image;
	
	protected Rectangle r;
	
	
	
	public int getX() {
		
		return x;
	}
	
	
	public void setX(int x) {
		
		this.x = x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public void setY(int y) {
		
		this.y = y;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public void setHeight(int h) {
		
		this.height = h;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public void setWidth(int w) {
		
		this.width = w;
	}
	
	public String getImage() {
		
		return image;
	}
	
	public void setImage(String Img) {
		
		
		this.image = Img;
	}
	
	
	
	public sprite() {
		super();
		
		this.x = -1;
		
		this.y = -1;
		
		this.height = -1;
		
		this.width = -1;
		
		this.image = "";
		
		this.r = new Rectangle(0,0,0,0);
	}
	
	
	public sprite(int x, int y, int width, int height, String img) {
		
		
		this.x = x;
		
		this.y = y;
		
		this.width = width;
		
		this.height = height;
		
		this.image = img;
		
		this.r = new Rectangle(x, y , width , height);
		
	
	}
	
	public void display() {
		
		System.out.println("x : " + this.x + "y : " + this.y);
		
		System.out.println("width : " + this.width + "height : " + this.height);
		
	    System.out.println("img : " + this.image);
		
	}
	
	
	public void updateRectanglePosition() {
		
		
		this.r.x = x;
		
		this.r.y = y;
		
	}
	
	public void updateRectangleSize() {
		
		
		this.r.width = width;
		
		this.r.height = height;
		
		
	}
   
	
	public Rectangle getRectangle() {
		
		return this.r;
	}
	
	

}
