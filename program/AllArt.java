package program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AllArt extends JPanel{
	int[][] picture;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllArt a = new AllArt(500/50,500/50);

	}
	JFrame frame;
	
	public AllArt(int width, int height) {
		picture=new int[width][height];
		frame = new JFrame();
		
		this.setBounds(0, 0, 500, 500);
		frame.add(this);
		
		frame.setBounds(0, 0, 500, 500);
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		
		long lastTime=System.currentTimeMillis();
		while (true) {
			
				//lastTime = System.currentTimeMillis();
				this.repaint();
				
				
			
			
			
		}
		
	}
	
	public void paint(Graphics g) {
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.white);
		picture[0][0]++;
		for(int r=0; r<picture.length; r++) {
			for(int c=0; c<picture[r].length; c++) {
				if(c<picture[r].length-1) {
					if(picture[r][c]>1) {
						picture[r][c]=0;
						picture[r][c+1]++;
					}
				}
				if(c==picture[r].length-1) {
					if(picture[r][c]>1) {
						picture[r][c]=0;
						picture[r+1][0]++;
					}
				}
				
				
				if(picture[r][c]==1) {
					g.fillRect(c*(500/picture[r].length), r*(500/picture.length), (500/picture[r].length), (500/picture.length));
				}
			}
		}
		
	}
}
