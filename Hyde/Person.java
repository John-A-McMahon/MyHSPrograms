package Hyde;

import java.awt.Color;
import java.awt.Graphics;

public class Person {
	private int x;
	private int y;
	private int width;
	private int height;
	private double velX;
	private double velY;
	private int id;
	private double r=1;
	private boolean alive;
	private String text;
	private String gender;
	private boolean wanted;
	private int goalX;
	private int goalY;
	private boolean isDrunk;
	
	
	
	
	
	
	
	

	

	private String[] boyNames= {"John","Jack","Harry","Oliver","George","Michael","Benjamin"};
	private String[] girlNames= {"Lily","Sophia","Ava","Ella","Isabella","Harper", "Isla"};
	private int randNameNum=(int)(Math.random()*7);
	
	public boolean isDrunk() {
		return isDrunk;
	}
	public void setDrunk(boolean isDrunk) {
		this.isDrunk = isDrunk;
	}

	private int nameNum=(int)(Math.random()*2);
	private String name="";
	public boolean isWanted() {
		return wanted;
	}
	public void setWanted(boolean wanted) {
		this.wanted = wanted;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public double getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}

	private Collision c;
	public Collision getC() {
		return c;
	}
	public void setC(Collision c) {
		this.c = c;
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
	
	public Person(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		c=new Collision(x,y,width,height);
		alive=true;
		id=1;
		isDrunk=false;
		resetGoals();
		
	}
	public Person(int x, int y, int width, int height,int id) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		c=new Collision(x,y,width,height);
		alive=true;
		this.id=id;
		isDrunk=false;
		resetGoals();
		
	}
	
	public void tick() {
		if(Math.abs(velX)>20&&id!=2&&id!=4) {
			velX/=Math.abs(velX);
		}
		if(Math.abs(velY)>20&&id!=2) {
			velY/=Math.abs(velY);
		}
		x+=velX;
		y+=velY;
		c.setX(x);
		c.setY(y);
		
		
		
		
		
		if(!alive) {
			wanted=false;
			isDrunk=false;
			if(Math.random()<40.0/60) {
				velX*=0.9;
				velY*=0.9;
			}
			
			if(r<50) {
				r+=1.0/(r+1);
				//r=1.0;
			}
			
		}
		else {
			r=1.0;
			
			if(id!=2) {
				velX*=0.6;
				velY*=0.6;
			}
			else {
				velX*=0.6;
				velY*=0.6;
			}
			
			if(velX!=0) {
				velX+=(int) ((velX/Math.abs(velX*1.0)*Math.random()))*5;
			}
			else if(velY!=0) {
				velY+=(int) ((velY/Math.abs(velY*1.0)*Math.random()))*5;
			}
			else if(id!=2&&Math.random()<0.01){
				
				resetGoals();
				
			}
			
			
			
			
		}
		
		
		
		
	}
	public void tick(int xx, int yy) {
		
		int speed=2;
		
		if(id==2) {
			speed=3;
		}
		
		if(alive) {
			if(x<xx) {
				velX+=speed;
			}
			if(x>xx) {
				velX-=speed;
			}
			if(y>yy) {
				velY-=speed;
			}
			if(y<yy) {
				velY+=speed;
			}
			r=0;
			
			
			
		}
		
		
		
		if(gender.equals("boy")) {
			name=boyNames[randNameNum];
		}
		if(gender.equals("girl")) {
			name=girlNames[randNameNum];
		}
		//tick();
	}
	
	public void tick(Person p) {
		tick(p.getX(),p.getY());
		if(x>5000) {
			System.out.println("OUT OF BOUNDS");
		}
	}
	
	
	
	
	public void render(Graphics g) {
		Color c=g.getColor();
		if(!alive) {
			
			if(gender.equals("girl")) {
				g.setColor(Color.yellow);
				g.fillRect(x+width/2-width/4, y-height/4, width/2, height);
			}
			
			
			if(velX==0&&velY==0) {
				g.setColor(Color.red);
				//g.fillOval(x-width/2, y-height/2,(int)((2)*r), (int)((2)*r));
				g.fillRoundRect(x+width/2-(int)r/2, y-(int)r/2+height/2, (int)r, (int)r, 100, 100);
				//System.out.println(r);
			}
			
			g.setColor(new Color(230,230,150));
			// legs
			g.drawLine(x + 10, y + 10, x + 5, y + 20+(int)(Math.abs(velX)+Math.abs(velY)));
			g.drawLine(x + 10, y + 10, x + 15, y + 20+(int)(Math.abs(velX)+Math.abs(velY)));
			// arms
			g.drawLine(x + 10, y + 10, x + 5, y + 12+(int)(Math.abs(velX)+Math.abs(velY)));
			g.drawLine(x + 10, y + 10, x + 15, y + 12+(int)(Math.abs(velX)+Math.abs(velY)));

			// neck and head
			g.drawLine(x + 10, y + 10, x + 10, y + 5+(int)(Math.abs(velX)+Math.abs(velY)));
			g.fillOval(x + 10 - 5, y - 5, 10+(int)(Math.abs(velX)+Math.abs(velY)), 10+(int)(Math.abs(velX)+Math.abs(velY)));
			
			//if they are police
			if(id==2) {
				g.setColor(Color.blue);
				g.fillRect(x+width/2-width/4, y-height/4, width/2, height/4);
			}
			//if they are paramedic
			if(id==4) {
				g.setColor(Color.red);
				g.fillRect(x+width/2-width/4, y-height/4, width/2, height/4);
			}
			
			
			
		}
		
		else if(id==0) {
			g.setColor(c);
			g.fillRect(x, y, width, height);
		}
		else if(id==1) {
			g.setColor(c);
			//g.setColor(Color.darkGray);
			g.fillOval(x-width/2, y-height/2, width, height);
			text="Hello!";
			gender="boy";
		}
		//police
		else if(id==2) {
			g.setColor(c);
			g.setColor(Color.blue);
			g.fillOval(x-width/2, y-height/2, width, height);
			text="How are you today citizen?";
			gender="boy";
		}
		else if(id==3) {
			g.setColor(c);
			g.fillOval(x-width/4, y-height/4, width, height);
			g.setColor(Color.yellow);
			g.fillRect(x, y, width/2, height/2);
			text="HEYYYYYY";
			gender="girl";
		}
		//paramedic
		else if(id==4) {
			g.setColor(c);
			g.setColor(Color.red);
			g.fillOval(x-width/2, y-height/2, width, height);
			text="How are you today citizen, Im saving lives?";
			gender="girl";
		}
		else if(id==5) {
			g.setColor(c);
			
			g.setColor(Color.yellow);
			g.fillRect(x, y-height/2, width, height);
			
			g.setColor(Color.red);
			// legs
			g.drawLine(x + 10, y + 10, x + 5, y + 20+(int)(Math.abs(velX)+Math.abs(velY)));
			g.drawLine(x + 10, y + 10, x + 15, y + 20+(int)(Math.abs(velX)+Math.abs(velY)));
			// arms
			g.drawLine(x + 10, y + 10, x + 5, y + 12+(int)(Math.abs(velX)+Math.abs(velY)));
			g.drawLine(x + 10, y + 10, x + 15, y + 12+(int)(Math.abs(velX)+Math.abs(velY)));

			// neck and head
			g.drawLine(x + 10, y + 10, x + 10, y + 5+(int)(Math.abs(velX)+Math.abs(velY)));
			g.setColor(new Color(230,230,150));
			g.fillOval(x  + width/4, y - height/4, 10+(int)(Math.abs(velX)+Math.abs(velY)), 10+(int)(Math.abs(velX)+Math.abs(velY)));
			velX=0;
			velY=0;
			text="Just getting a tan";
			gender="girl";
		}
		else if(id==6) {
			g.setColor(c);
			//g.setColor(Color.darkGray);
			g.fillOval(x-width/2, y-height/2, width, height);
			text="Extra extra read all about it!";
			gender="boy";
		}
		
		if(wanted) {
			g.setColor(Color.yellow);
			g.drawString("Wanted", x-width, y-height);
		}
		text=name+": "+text;
		g.setColor(c);
	}
	public boolean isAlive() {
		return alive;
	}
	public int getGoalX() {
		return goalX;
	}
	public void setGoalX(int goalX) {
		this.goalX = goalX;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
	public void resetGoals() {
		goalX=(int)((Math.random()-0.5)*5000);
		goalY=(int)((Math.random()-0.5)*5000);
		
		if(id==5||id==6) {
			goalX=x;
			goalY=y;
		}
	}
	public void resetGoals(Person p) {
		goalX=(int) p.getX();
		goalY=(int)p.getY();
		
		if(id==5) {
			goalX=x;
			goalY=y;
		}
	}
	public void resetGoals(Building b) {
		goalX=(int) b.getX();
		goalY=(int)b.getY();
		
		if(id==5) {
			goalX=x;
			goalY=y;
		}
	}
	public int getGoalY() {
		return goalY;
	}
	public void setGoalY(int goalY) {
		this.goalY = goalY;
	}
}
