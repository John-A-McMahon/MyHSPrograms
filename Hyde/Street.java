package Hyde;

import java.awt.Color;
import java.awt.Graphics;

public class Street {
	private String name;
	private int x;
	private int y;
	private int width;
	private int height;
	private Collision c;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Collision getC() {
		return c;
	}

	public void setC(Collision c) {
		this.c = c;
	}

	public Street(String name,int x, int y, int width, int height) {
			this.name=name;
			this.x=x;
			this.y=y;
			this.width=width;
			this.height=height;
			c=new Collision(x,y,width,height);
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.setColor(Color.yellow);
		if(width>=height) {
			g.fillRect(x, y+height/2, width, 10);
		}
		else {
			g.fillRect(x+width/2, y, 10, height);
		}
		
	}
	
	
	public void tick() {
		c.setX(x);
		c.setY(y);
	}
	
	
}
