import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x, y, velX, velY;
	protected ID id;

	public GameObject(int x, int y, int velX, int velY, ID id) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);
	
	public abstract Rectangle getBounds();

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setvelX(int velX) {
		this.velX = velX;
	}

	public void setvelY(int velY) {
		this.velY = velY;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getvelX() {
		return velX;
	}

	public int getvelY() {
		return velY;
	}

	public ID getId() {
		return id;
	}
}
