import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Dimension;
public class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Window(String title, int width,int height,Game game) {
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}

}
