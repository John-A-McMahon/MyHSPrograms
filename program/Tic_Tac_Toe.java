package program;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tic_Tac_Toe extends JPanel{
static JFrame frame=new JFrame();
public static void main(String[] args) {
	frame.setBounds(0,0,500,500);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
}

public void paint(Graphics g) {
	//super(Graphics g);
	frame.add(this);
	
	g.setColor(Color.red);
	g.drawRect(0, 0, 500,500);
}
}
