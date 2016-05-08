package lab7.q3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class FileViewer implements ActionListener{
	
	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JButton fileBtn;
	private JFileChooser fileChooser;

	private File currentFile;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				FileViewer f = new FileViewer();
				f.init();
			}
		});
	}

	public FileViewer() {
	}
	
	public void init(){
		frame = new JFrame("Lab 7, Q3");
		frame.setSize(1280, 1024);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.add(scrollPane, BorderLayout.CENTER);

		fileBtn = new JButton("Choose file");
		fileBtn.addActionListener(this);
		pane.add(fileBtn, BorderLayout.SOUTH);
		
		fileChooser = new JFileChooser();
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
			File f =  fileChooser.getSelectedFile();
			if(f.canRead() && (f.getName().endsWith(".txt") || f.getName().endsWith(".java"))){
				currentFile = f;
				String text = "";
				try(BufferedReader in = new BufferedReader(new FileReader(currentFile))){
					String s = null;
					while((s = in.readLine()) != null){
						text += s + System.getProperty("line.separator");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea.setText(text);
			} else {
				JOptionPane.showMessageDialog(frame, "Cannot read selected file, must be either .txt or .java");
			}
		}
	}
}
