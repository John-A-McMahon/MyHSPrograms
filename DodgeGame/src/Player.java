import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{

	public Player(int x, int y, ID id,int[] instructions) {
		super(x, y, id,instructions);
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle getBounds = new Rectangle(x,y,20,20);
	
	public void tick() {}
	
	public void render(Graphics g) {
		g.fillRect(x, y, 20, 20);
		
	}

}
