package lab2;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ListenersExample implements ActionListener{
	
	private JFrame frame;
	private JPanel mainPanel;	
	
	private Font[] fonts;
	private String[] fontNames;
	private JComboBox<String> fontsSelector;
	private JTextField text;
	private JCheckBox bold;
	private JCheckBox italic;
	
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		ListenersExample main = new ListenersExample();
	}
	
	public ListenersExample(){
		Q1();
		Q2();
	}
	
	private void Q1(){
		frame = new JFrame("Lab 2, Q1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		
		mainPanel = new JPanel();
		frame.setContentPane(mainPanel);
		
		JTextField count = new JTextField("0", 10);
		mainPanel.add(count);
		
		JButton incr = new JButton("Increment");
		incr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count.setText(new Integer(Integer.parseInt(count.getText()) + 1).toString());
			}
		});
		mainPanel.add(incr);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				count.setText("0");
			}
		});
		mainPanel.add(reset);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void Q2(){
		frame = new JFrame("Lab 2, Q2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 0);
		
		mainPanel = new JPanel();
		frame.setContentPane(mainPanel);
		
		JPanel stylePanel = new JPanel(new GridLayout(2, 1));
		bold = new JCheckBox("Bold");
		bold.addActionListener(this);
		italic = new JCheckBox("Italic");
		italic.addActionListener(this);
		stylePanel.add(bold);
		stylePanel.add(italic);
		mainPanel.add(stylePanel);
				
		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		fontNames = new String[fonts.length];
		for(int i = 0; i < fontNames.length; i++){
			fontNames[i] = fonts[i].getFontName();
		}
		
		fontsSelector = new JComboBox<String>(fontNames);
		fontsSelector.setEditable(false);
		fontsSelector.addActionListener(this);
		mainPanel.add(fontsSelector);
		
		text = new JTextField(20);
		text.setText("Text");
		text.setEditable(false);
		mainPanel.add(text);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		mainPanel.add(ok);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		int style = bold.isSelected() ? Font.BOLD : 0;
		style += italic.isSelected() ? Font.ITALIC : 0;
		text.setFont(new Font((String) fontsSelector.getSelectedItem(), style, 12));
	}
}
