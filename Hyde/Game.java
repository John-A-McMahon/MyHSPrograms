package Hyde;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;



import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener {
	JFrame frame;
	JPanel panel;
	JFrame frame2;
	private boolean twoPlayerFrame = true;
	private boolean twoPlayer = true;
	
	private int population=100;

	public Game() {

		frame = new JFrame();
		frame.setLayout(new GridLayout(1, 2));

		this.setBounds(0, 0, 500, 500);
		frame.add(this);

		frame.setBounds(0, 0, 500, 500);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		// frame.pack();
		frame.setVisible(true);
		long lastTime = System.currentTimeMillis();
		people.add(new Person(90, 90, 20, 20, 2));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(190, 90, 20, 20, 2));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(490, 90, 20, 20, 5));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(90, 90, 20, 20, 2));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(190, 90, 20, 20, 2));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(490, 90, 20, 20, 5));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(90, 90, 20, 20, 2));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(190, 90, 20, 20, 2));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(490, 90, 20, 20, 5));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(490, 90, 20, 20, 5));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(90, 90, 20, 20, 2));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));
		people.add(new Person(190, 90, 20, 20));
		people.add(new Person(290, 90, 20, 20, 3));
		people.add(new Person(290, 90, 20, 20));
		people.add(new Person(390, 90, 20, 20, 3));
		people.add(new Person(590, 90, 20, 20));
		people.add(new Person(290, 190, 20, 20, 4));

		// paperboy
		people.add(new Person(2000, 190, 20, 20, 6));

		// border
		walls.add(new Collision(0, 0, 50, 5000));
		walls.add(new Collision(5000, 0, 50, 5000));
		walls.add(new Collision(0, 0, 5000, 50));
		walls.add(new Collision(0, 5000, 5000, 50));

		// buildings
		buildings.add(new Building("Big Ben", Color.orange, 4400, 200, 100, 100));
		buildings.add(new Building("Houses of Parliament", Color.red, 4500, 200, 500, 500));
		buildings.add(new Building("Palace of Westminster", Color.darkGray, 2800, 700, 2200, 500));
		buildings.add(new Building("House of Lords", Color.red, 4500, 1200, 500, 500));
		buildings.add(new Building("St. Margarets Church", Color.red, 0, 700, 500, 500));

		buildings.add(new Building("News", Color.orange, 2000, 220, 100, 100));
		buildings.add(new Building("Bar", Color.orange, 2300, 220, 100, 100));
		buildings.add(new Building("Police station", Color.blue, 2300, 2600, 100, 100));
		// walls.add(new Collision(500, 500, 50, 50));

		streets.add(new Street("Great George Street", 0, 0, 5000, 200));
		streets.add(new Street("Abingdon Street", 2500, 0, 200, 5000));
		while (true) {
			
			if (System.currentTimeMillis() - lastTime >= 60) {
				
				lastTime = System.currentTimeMillis();
				this.repaint();

			}

		}
		// this.repaint();

	}

	public double dist(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public static void main(String[] args) {
		Game game = new Game();

		System.out.println("READY");

	}

	boolean[] keysPressed = new boolean[257];

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keysPressed[e.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keysPressed[e.getKeyCode()] = false;

		if (e.getKeyCode() == 'T') {
			isHyde = !isHyde;
		}

	}

	private int x = 240;
	private int y = 240;
	private int speedX = 0;
	private int speedY = 0;
	private boolean hasGun=true;
	
	private boolean isHyde = true;
	private ArrayList<Person> people = new ArrayList<>();
	private ArrayList<Street> streets = new ArrayList<>();
	private ArrayList<Collision> walls = new ArrayList<>();
	private ArrayList<Building> buildings = new ArrayList<>();
	Person player = new Person(240, 240, 20, 20);

	
	int money = 0;
	boolean t = false;
	boolean wanted = false;
	private String text = "";
	private int pStationX=250;
	private int pStationY=250;
	

	private String building = "Big Ben";
	private boolean inside = false;
	private long time = 0;
	private int killed = 0;
	private int arrested = 0;
	private int coldCases=0;
	private boolean inCar=false;

	private int detectiveX = 100;
	private int detectiveY = 100;
	Person detective = new Person(detectiveX, detectiveX, 20, 20);

	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		time++;
		
		if (!inside) {
			g.setColor(Color.GRAY);
			text = "";
			t = false;
			building = "Big Ben";
			for (Building b : buildings) {
				if (player.getC().touches(b)&&!(building.equals("Police Station")&&!player.isWanted())) {
					if (keysPressed['K']) {
						inside = true;

						building = b.getName();
					}
					

					// break;

				}
			}
			

			x -= speedX;
			y -= speedY;

			for (Building b : buildings) {
				b.setX(b.getX() + speedX);
				b.setY(b.getY() + speedY);
				b.render(g);

				// b.tick();
			}

			for (Street s : streets) {
				s.setX(s.getX() + speedX);
				s.setY(s.getY() + speedY);
				s.render(g);
				s.tick();
			}
			for (Person p : people) {
				p.setX(p.getX() + speedX);
				p.setY(p.getY() + speedY);
				p.setGoalX(p.getGoalX() + speedX);
				p.setGoalY(p.getGoalY() + speedY);

				if (keysPressed['M']) {
					p.setDrunk(true);
				}

				// g.drawLine(p.getX(), p.getY(), p.getGoalX(), p.getGoalY());
				for (Collision wall : walls) {
					if (wall.touches(p.getC()) || p.getC().touches(wall)) {
						p.setVelX((int)p.getVelX() * -1);
						p.setVelY((int)p.getVelY() * -1);
						p.tick();
						p.resetGoals();

						break;
					}
				}
//System.out.println(x);
//System.out.println(y);
				//System.out.println(keysPressed['K']);

				for (Building b : buildings) {
					if (p.getId() != 2&&b.touches(p.getC()) || p.getC().touches(b) || p.getX() < 50 + 240 - x
							|| p.getX() > 50 + 5000 - (240 - x) || p.getY() < 50 + 240 - y
							|| p.getY() > 50 + 5000 - (240 - y)) {
						// p.setVelX(p.getVelX() * -2);
						// p.setVelY(p.getVelY() * -2);
						do {
							p.setX((int) (Math.random() * 4000) + 240 - x);
							p.setY((int) (Math.random() * 4000) + 240 - y);
						} while (dist(x, y, p.getX(), p.getY()) < 500);
						p.tick();
						p.resetGoals();

						if (b.getName().equals("Bar")&&Math.random()<0.1&&p.getId()!=4) {
							p.setDrunk(true);
						}

						break;
					}
				}

				// AI
				p.tick();
				if (p.getId() == 2) {
					p.tick();
					p.tick();
				}
				p.render(g);
				g.setColor(Color.white);
			}

			for (Collision wall : walls) {
				wall.setX(wall.getX() + speedX);
				wall.setY(wall.getY() + speedY);
				wall.render(g);
			}

			if (Math.abs(speedX) > 200 || Math.abs(speedY) > 200) {
				speedX = 0;
				speedY = 0;
			}

			for (Street s : streets) {
				if (player.getC().touches(s.getC())) {
					text = s.getName();
				}
			}
			for (Person p : people) {
				if (player.getC().touches(p.getC())) {
					if (p.isAlive()) {
						System.out.println();
						text = p.getText();
						
						p.setX(p.getX()-(int)p.getVelX()*3);
						p.setY(p.getY()-(int)p.getVelY()*3);
						

					}
					if (!p.isAlive()) {
						System.out.println();
						text = "AHHHHH someone help me!";
					}
					if (inCar||isHyde && keysPressed[32] && (p.isAlive()
							|| (!p.isAlive() && Math.abs(p.getVelX()) == 0 && Math.abs(p.getVelY()) == 0))) {
						text = "AHHHHH someone help me!";
						if(p.isAlive()) {
							money+=(int)(Math.random()*40);
						}
						
						p.setVelX((int) -((speedX + Math.random() - 0.5) * 2) % 14);
						p.setVelY((int) -((speedY + Math.random() - 0.5) * 2) % 14);
						p.tick();
						p.setAlive(false);
						//player.setWanted(true);

						for (Person by : people) {
							if (by.isAlive()&&dist(240, 240, by.getX(), by.getY()) < 500) {
								// wanted = true;
								player.setWanted(true);
							}
						}
						
						

					}
					
					
					if(isHyde&&keysPressed['G']) {
						
					}

					if (!isHyde && keysPressed[32]) {

						text = "YOU SAVED ME DOCTOR!";
						money+=(int)(Math.random()*20);
						p.setAlive(true);
						
						if(p.isWanted()) {
							p.setX(2400);
							p.setY(2400);
							p.setWanted(false);
							System.out.println("YOU ARRESTED A MURDERER!");
						}
						
					}
				}

				
				if (p.isAlive() && !p.isWanted() &&p.getId() != 2) {
					p.tick(p.getGoalX(), p.getGoalY());
					if (p.getId() != 2 && ((p.getX() == p.getGoalX() && p.getY() == p.getGoalY())
							|| (p.getVelX() == 0 && p.getVelY() == 0)
							|| dist(p.getX(), p.getY(), p.getGoalX(), p.getGoalY()) < 10)) {
						p.resetGoals();

//						if(!p.isDrunk()&&Math.random()<0.01) {
//							//going to the bar
//							p.resetGoals(buildings.get(6));
//						}

					}
				}

//				if (p.getId() != 2) {
//					p.tick();
//					// System.out.println((p.getVelX()==0&&p.getVelY()==0));
//				}
				p.tick();
			}

if(player.isWanted()) {
	if(Math.random()<0.01) {
		player.setWanted(false);
	}
	
	for (Person by : people) {
		if (by.isAlive()&&dist(240, 240, by.getX(), by.getY()) < 250) {
			// wanted = true;
			player.setWanted(true);
		}
	}
}



//using gun
for (Person t : people) {
	if(hasGun) {
		//up
		if(keysPressed[38]) {
			g.drawLine(240, 240, 240, 0);
			if(Math.abs(t.getX()-240)<20&&t.getY()<240) {
				t.setAlive(false);
				player.setWanted(!t.isWanted());
			}
		}
		//down
		if(keysPressed[40]) {
			g.drawLine(240, 240, 240, 400);
			if(Math.abs(t.getX()-240)<20&&t.getY()>240) {
				t.setAlive(false);
				player.setWanted(!t.isWanted());
			}
		}
		//left
		if(keysPressed[37]) {
			g.drawLine(240, 240, 0, 240);
			if(Math.abs(t.getY()-240)<20&&t.getX()<240) {
				t.setAlive(false);
				player.setWanted(!t.isWanted());
			}
		}
		if(keysPressed[39]) {
			g.drawLine(240, 240, 500, 240);
			if(Math.abs(t.getY()-240)<20&&t.getX()>240) {
				t.setAlive(false);
				player.setWanted(!t.isWanted());
			}
		}
	}
	
}

			if (isHyde) {
				g.setColor(Color.white);
				if (keysPressed[32]) {
					g.fillRect(235, 230 + (int) (20 * Math.random()), 5, 20);
				}
				
				
				
				
				
				g.setColor(Color.green);
			} else {
				if (keysPressed[32]) {
					g.setColor(Color.red);
					g.fillRect(240, 225, 20, 10);
					g.fillRect(245, 220, 10, 20);
				}

				g.setColor(Color.white);

			}
			
			
			if(inCar) {
				g.fillRect(200, 200, 70, 40);
				player.setWidth(70);
				player.setHeight(40);
				player.setX(200);
				player.setY(200);
			}
			else {
				player.setX(240);
				player.setY(240);
				player.setWidth(20);
				player.setHeight(20);
				player.render(g);
			}
			

			
			g.drawString(text, 20, 20);
			g.drawString("£"+money, 400, 20);

			// player wall collision
			for (Collision wall : walls) {

				if (player.getC().touches(wall)) {
					t = true;
					speedX *= -1;
					speedY *= -1;
					break;
				}
			}

			if (!t) {
				speedX *= 0.9;
				speedY *= 0.9;

				if (keysPressed[65]) {
					speedX += 3;
				}
				if (keysPressed[68]) {
					speedX -= 3;
				}
				if (keysPressed[83]) {
					speedY -= 3;
				}
				if (keysPressed['W']) {
					speedY += 3;
				}
			}

			for (Person p1 : people) {
				int minDist = Integer.MAX_VALUE;
				if(!isHyde &&Math.random()<0.001&&p1.getId()!=4) {
					p1.setDrunk(true);
				}
				for (Person p2 : people) {
					
					if (p1 == p2 
							|| (p1.getId() == 2 && (Math.abs(p1.getVelX()) > 0 || Math.abs(p1.getVelY()) > 0))
							|| (p2.getId() == 2 && (Math.abs(p2.getVelX()) > 0 || Math.abs(p2.getVelY()) > 0))) {
						continue;
					}

					// paramedic saving person
					if (p1.getC().touches(p2.getC()) || p2.getC().touches(p1.getC())) {
						if (p1.getId() == 4 && !p2.isAlive()) {
							p2.setAlive(true);
							killed++;
							continue;
						}
						if (p2.getId() == 4 && !p1.isAlive()) {
							p2.setAlive(true);
							killed++;
							continue;
						}
					}
					// paramedic AI
					if (p1.getId() == 4 && dist(p1.getX(), p1.getY(), p2.getX(), p2.getY()) < 500) {
						if (!p2.isAlive()) {
							p1.resetGoals(p2);
							p1.tick();
							p1.tick();
							// break;
							// minDist=(int)dist(p1.getX(),p1.getY(),p2.getX(),p2.getY());
						}
					}
					if (p2.getId() == 4 && dist(p1.getX(), p1.getY(), p2.getX(), p2.getY()) < 500) {
						if (!p1.isAlive()) {
							p2.resetGoals(p1);
							p2.tick();

							// break;
						}
					}
					

					// agression
					if (p1.getC().touches(p2.getC()) && Math.random() < 0.1 && p1.isDrunk()) {
						p2.setAlive(false);

						for (Person witness : people) {

							if (p1 != witness && witness.isAlive()
									&& dist(p1.getX(), p1.getY(), witness.getX(), witness.getY()) < 250) {
								p1.setWanted(true);
							}
							
						}
						if(!p1.isWanted()) {
							coldCases++;
						}

					}
					if (p2.getC().touches(p1.getC()) && Math.random() < 0.1 && p2.isDrunk()) {
						p1.setAlive(false);
						for (Person witness : people) {

							if (p2 != witness && witness.isAlive()
									&& dist(p2.getX(), p2.getY(), witness.getX(), witness.getY()) < 200) {
								p2.setWanted(true);
							}
						}
						if(!p2.isWanted()) {
							coldCases++;
						}
					}

					// police chase
					if (p1.isWanted() && p2.getId() == 2&&dist(p1.getX(),p1.getY(),p2.getX(),p2.getY())<2000) {
						p2.tick(p1);
						p1.tick(5000 - p1.getX(), 5000 - p1.getY());

					}
					
					
					
					if (p2.isWanted() && p1.getId() == 2&&dist(p1.getX(),p1.getY(),p2.getX(),p2.getY())<1000) {
						p1.tick(p2);
						p2.tick(5000 - p1.getX(), 5000 - p1.getY());
					}

					if (p1.getC().touches(p2.getC()) && p2.isWanted() && p1.getId() == 2) {
						p1.setX(2400);
						p1.setY(2400);
						arrested++;
						p2.setX(2400);
						p2.setY(2400);
						p2.tick(p1);
						p2.setWanted(false);
						p2.setAlive(true);
						p1.setDrunk(false);
					}
					if (p2.getC().touches(p1.getC()) && p2.isWanted() && p1.getId() == 2) {
						p1.setX(2400);
						p1.setY(2400);
						arrested++;
						p2.setX(2400);
						p2.setY(2400);
						p1.tick(p2);
						p2.setWanted(false);
						p1.setAlive(true);
						p1.setDrunk(false);
					}

					
					
					

				}
			}
			
			for(Person police : people) {
				if(police.getId()!=2||!police.isAlive()) {
					continue;
				}
				//police.tick(people.get((int)(Math.random()*people.size())));
				//player police chase
					if (player.isWanted() && police.getId() == 2) {
						police.tick(player);
						System.out.println("I SEE YOU");
					}
					
					if (police.getC().touches(player.getC()) && player.isWanted() && police.getId() == 2) {
						speedX = x - 2350;
						speedY = y - 2600;
						inside=true;
						building = "Police Station";
						player.setWanted(false);
						player.setAlive(true);
					}
					
					for (Person criminal : people) {
						if(criminal.isWanted()) {
							if(Math.random()<0.5) {
								police.tick(criminal);
								continue;
							}
							if(criminal.isWanted()&&police.getC().touches(criminal.getC())) {
								criminal.setVelX(criminal.getX()-2350);
								criminal.setVelY(criminal.getY()-2600);
								criminal.setWanted(false);
								criminal.setDrunk(false);
							}
						}
						
					}
					
					
					
					
				}
			

		}

		else {
			if (building.equals("Big Ben")) {
				g.setColor(Color.cyan);
				g.fillRect(0, 0, 500, 500);
				g.setColor(Color.orange);
				g.fillRect(100, 100, 300, 500);
				g.setColor(Color.yellow);
				g.fillOval(150, 150, 200, 200);
				// double minute=(time/(3600.0*2*8/6.0));
				// double minute=System.currentTimeMillis()/(60.0*60.0*60.0*2.5);
				double second = System.currentTimeMillis() / (1000 * 60.0 * (60 / 6.5));
				double minute = System.currentTimeMillis() / (1000 * 60.0 * (60 / 6.5) * 60);
				double hour = System.currentTimeMillis() / (1000 * 60.0 * (60 / 6.5) * 60 * 60);
				g.setColor(Color.red);
				g.drawLine(250, 250, 250 + (int) (Math.cos((second / 1.0) * (180 / Math.PI)) * 100),
						250 + (int) (Math.sin((second / 1.0) * (180 / Math.PI)) * 100));
				g.drawLine(250, 250, 250 + (int) (Math.cos((minute / 1.0) * (180 / Math.PI)) * 100),
						250 + (int) (Math.sin((minute / 1.0) * (180 / Math.PI)) * 100));
				g.drawLine(250, 250, 250 + (int) (Math.cos((hour / 1.0) * (180 / Math.PI)) * 50),
						250 + (int) (Math.sin((hour / 1.0) * (180 / Math.PI)) * 50));

			}

			if (building.equals("News")) {
				g.drawString("EXTRA EXTRA! " + killed + " found dead on the streets of London!", 50, 50);
				g.drawString("EXTRA EXTRA! " + arrested + " arrested on the streets of London!", 50, 100);
				g.drawString("EXTRA EXTRA! " + coldCases + " cold cases that are no longer being investagated!", 50, 100);
			}
			if (building.equals("Police Station")) {
				g.setColor(Color.blue);
				g.fillRect(0, 0, 500, 500);
				g.setColor(Color.black);
				g.fillOval(pStationX, pStationY, 20, 20);
				g.drawString("Press L to pay bail and leave",50,50);
				if (keysPressed[76]) {
					money*=0.5;
				}
				
				if (keysPressed[39]&&pStationX<480) {
					pStationX+=5;
				}
				if (keysPressed[37]&&pStationX>20) {
					pStationX-=5;
				}
				if (keysPressed[40]&&pStationY<460) {
					pStationY+=5;
					System.out.println("DOWN");
				}
				if (keysPressed[38]&&pStationY>20) {
					pStationY-=5;
					
				}
				g.setColor(Color.gray);
				g.fillRect(0, 0, 500, 5);
				g.fillRect(495, 0, 5, 500);
				g.fillRect(0, 0, 5, 500);
				g.fillRect(0, 470, 500, 10);
				
				
			}

			if (keysPressed[76]) {
				
				inside = false;
			}
		}
	}
}
