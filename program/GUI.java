package program;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{

	public GUI(int x, int y, int width, int height) {
		JFrame frame = new JFrame();
		frame.setBounds(x, y, width,height);
		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
	}

}
