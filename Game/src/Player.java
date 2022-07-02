import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Player extends GameObject{

	private Handler handler;
	public Player(int x, int y, int velX, int velY, ID id,Handler handler) {
		super(x, y, velX, velY, id);
		this.handler = handler;
		
		
	}
	boolean gameStarted = false;
	boolean alive = true;
	long score = 0;
	public Rectangle getBounds() {
		return new Rectangle(x,y,20,20);
	}
	private void collision() {
		for (int i = 0; i<handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId()==ID.basicEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					alive = false;
					
					
				}
			}
			
		}
	}
	
	public void tick() {
		if (alive) {
			collision();
			score ++;
			x+=velX;
			y+=velY;
		}
		
		
		
	};
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 20, 20);
		
		if (!alive) {
				g.setColor(Color.red);
				g.fillRect(0,0,500,500);
				g.setColor(Color.black);
				g.drawString("GAME OVER",250,250);
				g.drawString("Score: "+score,250,270);
				
			}
		
	}
	
	
	
	

}
