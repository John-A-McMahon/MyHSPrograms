import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class GameObject {
protected int x,y;
protected ID id;
protected int[] instructions;


public GameObject(int x, int y, ID id) {
	this.x = x;
	this.y = y;
	this.id = id;
			
}

public GameObject(int x, int y, ID id,int[] instructions) {
	
	this.x = x;
	this.y = y;
	this.id = id;
	this.instructions = instructions;
			
}

public abstract void tick();
public abstract void render(Graphics g);

public void setX(int x) {
	this.x = x;
}
public void setY(int y) {
	this.y = y;
}
public void setId(ID id) {
	this.id = id;
}

public int getX() {
	return this.x;
}
public int getY() {
	return this.y;
}
public ID getId() {
	return this.id;
}
}
