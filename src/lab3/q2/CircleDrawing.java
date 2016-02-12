package lab3.q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CircleDrawing extends MouseAdapter{
	
	public static void main(String[] args){
		CircleDrawing circle = new CircleDrawing();
	}
	
	ArrayList<Shape> shapes;
	HashSet<Shape> updatedShapes;
	Random r = new Random();
	final int height = 400;
	final int width = 400;
	
	CirclePanel mainPanel;
	
	public CircleDrawing(){
		JFrame frame = new JFrame("Q2");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(height, width);
		frame.setResizable(false);
		
		mainPanel = new CirclePanel(this);
		mainPanel.addMouseListener(this);
		frame.setContentPane(mainPanel);
		
		shapes = new ArrayList<Shape>();
		updatedShapes = new HashSet<Shape>();
		addCircle();
		addSquare();
		
		mainPanel.repaint();
		frame.setVisible(true);
	}
	
	public void addCircle(){
		float diameter = r.nextFloat() * 190 + 10;
		Ellipse2D.Float c = new Ellipse2D.Float(r.nextFloat()*width, r.nextFloat()*height, diameter, diameter);
		shapes.add(c);
		updatedShapes.add(c);
		mainPanel.repaint();
	}
	
	public void addSquare(){
		float length = r.nextFloat() * 190 + 10;
		Rectangle2D.Float rect = new Rectangle2D.Float(r.nextFloat()*width, r.nextFloat()*height, length, length);
		shapes.add(rect);
		updatedShapes.add(rect);
		mainPanel.repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		for(Shape s : shapes){
			if(s.contains(e.getPoint())) updatedShapes.add(s);
		}
		mainPanel.repaint();
	}
}
