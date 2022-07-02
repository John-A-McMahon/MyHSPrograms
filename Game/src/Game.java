import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable{
	
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run() {
		long lastTime = System.nanoTime();
		double FPS = 60.0;
		double ns = 1_000_000_000/FPS;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta +=(now - lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				System.out.println("FPS "+frames);
				frames = 0;
			}
		}
		stop();
	}
	private void tick() {
		handler.tick();
		//if (ID.enemy.x<ID.Player.x) {}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		g.dispose();
		bs.show();
	}
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window("Title",500,500,this);
		for (int i = 0; i<12;i++) {
			handler.addObject(new BasicEnemy(i*20,0,0,1,ID.basicEnemy));
		}
		for (int i = 0; i<12;i++) {
			handler.addObject(new BasicEnemy(i*20+250,480,0,1,ID.basicEnemy));
		}
		for (int i = 0; i<25;i++) {
			handler.addObject(new BasicEnemy(i*20,0,0,0,ID.basicEnemy));
			handler.addObject(new BasicEnemy(i*20,460,0,0,ID.basicEnemy));
		}
		for (int i = 0; i<25;i++) {
			handler.addObject(new BasicEnemy(0,i*20,0,0,ID.basicEnemy));
			handler.addObject(new BasicEnemy(480,i*20,0,0,ID.basicEnemy));
		}
		handler.addObject(new BasicEnemy(20,20,2,2,ID.basicEnemy));
		handler.addObject(new BasicEnemy(60,50,2,3,ID.basicEnemy));
		handler.addObject(new BasicEnemy(100,20,1,2,ID.basicEnemy));
		handler.addObject(new BasicEnemy(140,50,2,1,ID.basicEnemy));
		
		handler.addObject(new BasicEnemy(20,320,1,2,ID.basicEnemy));
		handler.addObject(new BasicEnemy(60,350,3,1,ID.basicEnemy));
		handler.addObject(new BasicEnemy(100,320,2,2,ID.basicEnemy));
		handler.addObject(new BasicEnemy(140,350,2,1,ID.basicEnemy));
		
		handler.addObject(new Player(200,200,0,0,ID.player,handler));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();

	}

}
