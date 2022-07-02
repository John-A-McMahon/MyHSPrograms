import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class BasicEnemy extends GameObject{

	public BasicEnemy(int x, int y, int velX, int velY, ID id) {
		super(x, y, velX, velY, id);
		
		
	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,20,20);
	}
	public void tick() {
		
		if (x>480||x<0) {
			velX=velX*-1;
		}
		if (y>480||y<0) {
			velY=velY*-1;
		}
		
		
		x+=velX;
		y+=velY;
		
		
	};
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 20, 20);
	}
	
	

}
