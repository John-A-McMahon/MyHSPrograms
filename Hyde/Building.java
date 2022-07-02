package Hyde;

import java.awt.Color;
import java.awt.Graphics;

public class Building extends Collision{
	private String name;
	private Color color;
	public Building(int x, int y, int width, int height) {
		super(x, y, width, height);
		color=Color.gray;
		
		// TODO Auto-generated constructor stub
	}
	public Building(String name, Color color, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.color=color;
		this.name=name;
		
		// TODO Auto-generated constructor stub
	}
	public void render(Graphics g) {
		g.setColor(color);
		super.render(g);
		g.drawString(name, super.getX(), super.getY());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

}
