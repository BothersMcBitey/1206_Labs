package lab3.q3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Die extends JPanel {
	
	private Color dieColor;
	private int currentVal;
	private int dotRadius;
	private Random r;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Die");
		frame.setSize(800, 940);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		JPanel mainPanel = new JPanel(null);
		frame.setContentPane(mainPanel);
		
		Die die = new Die(new Dimension(800,800));
		mainPanel.add(die);
		
		JButton btn = new JButton("Roll");
		btn.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				die.updateVal(new Random().nextInt(6) + 1);
			}
		});
		btn.setBounds(300, 820, 200, 60);
		mainPanel.add(btn);
		
		frame.setVisible(true);		
	}

	public Die(Dimension d) {
		setBounds(0, 0, d.width, d.height);
		dieColor = new Color(255, 0, 0);
		currentVal = 1;
		dotRadius = 50;
		r = new Random();
	}
	
	public void updateVal(int i){
		currentVal = i;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(dieColor);
		g.drawRect(20, 20, getWidth() - 60, getHeight() - 40);
		//if odd, draw central dot
		if(currentVal % 2 != 0) g.fillOval(getWidth()/2 - dotRadius, getHeight()/2 - dotRadius, dotRadius*2, dotRadius*2);
		//if not one, top left / bottom right corners
		if(currentVal > 1){
			g.fillOval(getWidth()/4 - dotRadius, getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
			g.fillOval(3*getWidth()/4 - dotRadius, 3*getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
		}
		//if bigger than 3, top right / bottom left corners
		if(currentVal > 3){
			g.fillOval(getWidth()/4 - dotRadius, 3*getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
			g.fillOval(3*getWidth()/4 - dotRadius, getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
		}
		//if 6, top and bottom mids
		if(currentVal == 6){
			g.fillOval(getWidth()/2 - dotRadius, getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
			g.fillOval(getWidth()/2 - dotRadius, 3*getHeight()/4 - dotRadius, dotRadius*2, dotRadius*2);
		}
	}
}
