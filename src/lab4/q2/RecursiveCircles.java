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
		frame.setSize(1980, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		CirclePanel mainPanel = new CirclePanel();
		frame.setContentPane(mainPanel);
		
		mainPanel.repaint();
		
		frame.setVisible(true);
	}
	
	class CirclePanel extends JPanel{
		
		private final int DEPTH = 5;
		private int X_OFFSET;
		
		@Override
		public void paintComponent(Graphics g){
			X_OFFSET = getWidth()/2;
			drawCircles(g, 0, getHeight()/2, getWidth()/6, 1);
		}
		
		private void drawCircles(Graphics g, int x, int y, int r, int d){
			g.setColor(new Color(0, 255/d, 0));
			g.fillOval((x + X_OFFSET)-r, y-r, 2*r, 2*r);		
			if(d < DEPTH){
				d++;
				int r2 = (r/3 < 3) ? 3 : r/3;
				drawCircles(g, x-2*r, y, r2, d);
				drawCircles(g, x, y, r2, d);
				drawCircles(g, x+2*r, y, r/3, d);
			}
		}
	}
}
