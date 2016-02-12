package lab3.q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CirclePanel extends JPanel{
	
	CircleDrawing model;
	Random r = new Random();
	
	public CirclePanel(CircleDrawing model){
		super();
		this.model = model;
		JButton addCircleBtn = new JButton("Add Circle");
		addCircleBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addCircle();
			}
		});
		add(addCircleBtn);
		
		JButton addSquareBtn = new JButton("Add Square");
		addSquareBtn.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addSquare();
			}
		});
		add(addSquareBtn);
	}
	
	@Override
	public void paintComponent(Graphics g1){
		Graphics2D g = (Graphics2D) g1;		
		System.out.println("draw");
		for(Shape s : model.updatedShapes){
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			g.fill(s);
		}
		model.updatedShapes.clear();
	}
}