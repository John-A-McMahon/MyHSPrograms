import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public static final int WIDTH =640, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;
	private Handler handler = new Handler();
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		}catch(Exception e) {
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
			delta += (now-lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				System.out.println("FPS:"+frames);
				frames=0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		x++;
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		g.setColor(Color.white);
		//g.fillRect(x, 0, WIDTH, HEIGHT);
		handler.render(g);
		g.dispose();
		bs.show();
		
	}
	
	int x=0;
	public Game() {
		handler = new Handler();
		//this.addEventListener(new keyInput(handler));
		
		new Window("title",500,500,this);
		int[] instructions = {0,0,0,0};
		handler.addObject(new Player(0,0,ID.Player,instructions));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Game();
	}

}
