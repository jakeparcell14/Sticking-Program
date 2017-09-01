import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

public class StickingFrame extends JFrame
{		
	private int windowWidth;
	private int windowHeight;
	
	public StickingFrame(int w, int h)
	{
		windowWidth = w;
		windowHeight = h;
		
		this.setTitle("Sticking Program");
		
		JPanel panels = new JPanel(new CardLayout());
		CardLayout currentPanel = (CardLayout)(panels.getLayout());
		
		JPanel drumsPanel = new DrumsPanel(windowWidth, windowHeight);
		panels.add(drumsPanel, "DRUMS");
		
		JPanel malletsPanel = new MalletsPanel();
		panels.add(malletsPanel, "MALLETS");
		
		currentPanel.show(panels, "DRUMS");		
		
		this.add(panels);
		this.setVisible(true);
	}
}
