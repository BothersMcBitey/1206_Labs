package lab2.q3;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PanelTracking extends MouseAdapter{
	
	public static void main(String[] args){
		new PanelTracking();
	}
	
	private JPanel[] panels;
	private boolean[] inside;
	private JLabel[] labels;
	
	JPanel lowerPanel;
	
	public PanelTracking() {
		JFrame frame = new JFrame("Lab 2, Q3");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(null);
		frame.setContentPane(mainPanel);
				
		JPanel upperPanel = new JPanel(null);
		upperPanel.setBounds(0, 0, 800, 600);
		upperPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		upperPanel.setBackground(Color.white);
		mainPanel.add(upperPanel);
		
		lowerPanel = new JPanel(new FlowLayout());
		lowerPanel.setBounds(0, 600, 800, 200);
		lowerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		lowerPanel.setBackground(Color.white);
		mainPanel.add(lowerPanel);
		
		Random r = new Random();
		int max = r.nextInt(10)+5;
		panels = new JPanel[max];
		inside = new boolean[max];
		labels = new JLabel[max];
		for(int i = 0; i < max; i++){
			JPanel p = new JPanel();
			
			int w = r.nextInt(250) + 30;
 			int h = r.nextInt(250) + 30;
			int x = r.nextInt(upperPanel.getWidth() - w);
			int y = r.nextInt(upperPanel.getHeight() - h);
			p.setBounds(x, y, w, h);
			
			p.setOpaque(true);
			p.setBackground(new Color(r.nextInt(200) + 55, r.nextInt(200) + 55, r.nextInt(200) + 55));
			
			p.add(new JLabel(Integer.toString(i)));
			
			panels[i] = p;
			inside[i] = false;
			labels[i] = new JLabel();
			upperPanel.add(p);
		}
		
		Component glassPane = frame.getGlassPane();
		glassPane.addMouseMotionListener(this);
		glassPane.setVisible(true);
		
		frame.setVisible(true);
	}
	
	@Override
	public void mouseMoved(MouseEvent e){				
		for(int i = 0; i < panels.length; i++){
			JPanel p = panels[i];
			if(p.contains(e.getX() - p.getX(), e.getY() - p.getY())){
				if(!inside[i]){
					lowerPanel.add(labels[i]);
					inside[i] = true;
				}
				labels[i].setText(i + ": " + e.getX() + ", " + e.getY());
				int c = 255/labels.length;
				labels[i].setForeground(new Color(c * i, c * (labels.length - i), (100 * i) % 255));
			} else {
				if(inside[i]){
					inside[i] = false;
					lowerPanel.remove(labels[i]);
				}
			}
		}
		lowerPanel.revalidate();
		lowerPanel.repaint();
	}
}