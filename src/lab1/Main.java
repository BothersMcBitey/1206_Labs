package lab1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Q1();
		Q2();
		Q3();
	}

	private static void Q1() {
		JFrame frame = new JFrame("Q1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(0, 1));
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		
		JTextField text1 = new JTextField("Sample Text", 20);
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		
		textPanel.add(text1);
		buttonPanel.add(submit);
		buttonPanel.add(cancel);
		
		pane.add(textPanel);
		pane.add(buttonPanel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void Q2() {
		FontChooser("Q2", 300, true);
	}
	
	public static void Q3(){
		FontChooser("Q3", 700, false);
	}
	
	public static void FontChooser(String name, int xPosition, boolean radio){
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(xPosition, 0);
		Container pane = frame.getContentPane();
		pane.setLayout(new FlowLayout());
		
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new GridLayout(2,1));
		JCheckBox bold = new JCheckBox("Bold");
		JCheckBox italic = new JCheckBox("Italic");
		checkPanel.add(bold);
		checkPanel.add(italic);
		
		JTextField text = new JTextField("Sample Text",	15);
		
		JButton ok = new JButton("Okay");
		
		pane.add(checkPanel);
		if(radio){
			pane.add(RadioFonts());
		} else {
			pane.add(ComboFonts());
		}
		pane.add(text);
		pane.add(ok);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static JPanel RadioFonts(){
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(3,1));
		ButtonGroup btnGrp = new ButtonGroup();
		JRadioButton times = new JRadioButton("Times");
		JRadioButton helvetica = new JRadioButton("Helvetica");
		JRadioButton courier = new JRadioButton("Courier");
		btnPanel.add(times);
		btnPanel.add(helvetica);
		btnPanel.add(courier);
		btnGrp.add(times);
		btnGrp.add(helvetica);
		btnGrp.add(courier);
		return btnPanel;
	}
	
	public static JComboBox<String> ComboFonts(){
		String[] fonts = new String[] {"Times", "Helvetica", "Courier"};
		JComboBox<String> fontsSelector = new JComboBox<>(fonts);
		fontsSelector.setEditable(false);
		return fontsSelector;
	}
	
}
