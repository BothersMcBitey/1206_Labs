package lab4.q2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class RecursiveCircles {

	public static void main(String[] args){
		new RecursiveCircles();
	}
	
	public RecursiveCircles() {
		JFrame frame = new JFrame("CIRCLES");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		CirclePanel mainPanel = new CirclePanel();
		frame.setContentPane(mainPanel);
		
		mainPanel.repaint();
		
		frame.setVisible(true);
	}
	
	class CirclePanel extends JPanel{
		
		private final int DEPTH = 5;
		
		@Override
		public void paintComponent(Graphics g){
			drawCircles(g, getWidth()/2, getHeight()/2, getWidth()/6, 1);
		}
		
		private void drawCircles(Graphics g, int x, int y, int r, int d){
			g.setColor(new Color(0, 255/d, 0));
			g.fillOval(x-r, y-r, 2*r, 2*r);
			if(d < DEPTH){
				drawCircles(g, x/3, y, r/3, d+1);
				drawCircles(g, x, y, r/3, d+1);
				drawCircles(g, (5*x)/3, y, r/3, d+1);
			}
		}
	}
}
