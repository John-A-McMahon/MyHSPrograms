package Hyde;

import java.awt.Graphics;

public class Collision {
private int x;
private int y;
private int width;
private int height;

public Collision(int x, int y, int width, int height) {
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
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




public void render(Graphics g) {
	g.fillRect(x, y, width, height);
}


public boolean touches(Collision c) {
	int left=x;
	int right= x+width;
	int top=y;
	int bottom=y+height;
	
	int cLeft=c.getX();
	int cRight= c.getX()+c.getWidth();
	int cTop=c.getY();
	int cBottom=c.getY()+c.getHeight();
	
	
	
	if(right>=cLeft&&right<=cRight&&bottom>=cTop&&bottom<=cBottom) {
		
		return true;
		
	}
	if(right>=cLeft&&right<=cRight&&top>=cTop&&top<=cBottom) {
		//System.out.println("left");
		return true;
	}
	
	if(left>=cLeft&&left<=cRight&&bottom>=cTop&&bottom<=cBottom) {
		//System.out.println("bottom");
		return true;
	}
	
	
	
	if(left>=cLeft&&left<=cRight&&top>=cTop&&top<=cBottom) {
		//System.out.println("right");
		return true;
	}
	return false;
	
	
}

public boolean touchesBottom(Collision c) {
	
	int left=x;
	int right= x+width;
	int top=y;
	int bottom=y+height;
	
	int cLeft=c.getX();
	int cRight= c.getX()+c.getWidth();
	int cTop=c.getY();
	int cBottom=c.getY()+c.getHeight();
	
	if(this.touches(c)&&(right>=cLeft&&left<=cRight)&&bottom>=cTop&&top<=cTop) {
		//System.out.println("Ontop");
		//System.out.println("hi");

		return true;
	}
	return false;
}


public boolean touchesSides(Collision c) {
	
	int left=x;
	int right= x+width;
	int top=y;
	int bottom=y+height;
	
	int cLeft=c.getX();
	int cRight= c.getX()+c.getWidth();
	int cTop=c.getY();
	int cBottom=c.getY()+c.getHeight();
	if(left>=cLeft&&left<=cRight&&top>=cTop&&top<=cBottom) {
		
		return true;
	}
	
	if(right>=cLeft&&right<=cRight&&top>=cTop&&top<=cBottom) {
		return true;
	}
	
	return false;
}


public boolean inside(Collision c) {
	int left=x;
	int right= x+width;
	int top=y;
	int bottom=y+height;
	
	int cLeft=c.getX();
	int cRight= c.getX()+c.getWidth();
	int cTop=c.getY();
	int cBottom=c.getY()+c.getHeight();
	
	
	if(cLeft>left&&cRight<right&&cTop>top&&cBottom<bottom) {
		return true;
		
	}
	return false;
	
}




}
