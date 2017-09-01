import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrumsPanel extends JPanel
{
	private JPanel drumsListener;
	
	private int windowWidth;
	private int windowHeight;
	
	private JPanel upperButtonPanel;
	private JButton malletsButton;
	private JCheckBox formatDiddleCheckBox;
	
	private JPanel textPanel;
	private JTextField stickingTextField;
	
	private JPanel lowerButtonPanel;
	private JButton copyButton;
	private JButton clearButton;
	
	public DrumsPanel(int w, int h)
	{
		windowWidth = w;
		windowHeight = h;
		

		
		this.setLayout(new BorderLayout());
		
		createComponents();
	}
	
	private void createComponents()
	{		
		JPanel upperButtonPanel = new JPanel();
		malletsButton = new JButton("Write Stickings For Mallets"); //TODO add action listener
		formatDiddleCheckBox = new JCheckBox("Notate diddles as one note");//TODO add action listener
		
		//add components to panel
		upperButtonPanel.add(malletsButton);
		upperButtonPanel.add(formatDiddleCheckBox);
		
		textPanel = new JPanel();
		stickingTextField = new JTextField("Start drumming!"); //TODO add action listener that clears this text
		stickingTextField.setPreferredSize(new Dimension(windowWidth - 10, windowHeight / 2));
		
		//add components to panel
		textPanel.add(stickingTextField);
		
		lowerButtonPanel = new JPanel();
		copyButton = new JButton("Copy All");
		clearButton = new JButton("Clear All");
		
		//add components to panel
		lowerButtonPanel.add(copyButton);
		lowerButtonPanel.add(clearButton);
		
		drumsListener = new DrumsListenerPanel(stickingTextField);

		//add panels to main panel
		this.add(drumsListener);
		add(upperButtonPanel, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(lowerButtonPanel, BorderLayout.SOUTH);


	}

}
