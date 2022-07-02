import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
private Handler handler;

public KeyInput(Handler handler) {
	this.handler=handler;
}

private boolean uP = false;
private boolean dP = false;
private boolean lP = false;
private boolean rP = false;

public void keyPressed(KeyEvent e) {
	
	
	
	int key = e.getKeyCode();
	for (int i = 0;i<handler.object.size();i++) {
		GameObject tempObject = handler.object.get(i);
		if (tempObject.getId()==ID.player) {
			if (key == KeyEvent.VK_W) {
				uP = true;
				tempObject.setvelY(-5);
				//System.out.println(tempObject.getvelY());
				
			}
			if (key == KeyEvent.VK_A) {
				lP = true;
				tempObject.setvelX(-5);
				//System.out.println(tempObject.getY());
				
			}
			if (key == KeyEvent.VK_S) {
				dP = true;
				tempObject.setvelY(5);
				//System.out.println(tempObject.getY());
				
			}
			if (key == KeyEvent.VK_D) {
				rP=true;
				tempObject.setvelX(5);
				//System.out.println(tempObject.getY());
				
			}
		}
	}
}
public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
	for (int i = 0;i<handler.object.size();i++) {
		GameObject tempObject = handler.object.get(i);
		if (tempObject.getId()==ID.player) {
			if (key == KeyEvent.VK_W) {
				uP = false;
                if(dP){
                    tempObject.setvelY(5);
                }
                else{
                    tempObject.setvelY(0);
                }
				
				
			}
			if (key == KeyEvent.VK_A) {
				lP = false;
                if(rP){
                    tempObject.setvelX(5);
                }
                else{
                    tempObject.setvelX(0);
                }
				
			}
			if (key == KeyEvent.VK_S) {
				dP = false;
                if(uP){
                    tempObject.setvelY(-5);
                }
                else{
                    tempObject.setvelY(0);
                }
			}
			if (key == KeyEvent.VK_D) {
				rP = false;
                if(lP){
                    tempObject.setvelX(-5);
                }
                else{
                    tempObject.setvelX(0);
                }
				
			}
		}
	}
}

}
