import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class StickingFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StickingFrame frame = new StickingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StickingFrame() {

		//set keyboard zones for each type of sticking
		ArrayList<String> leftAccent = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "q", "w", "e", "r", "t", "y"));
		ArrayList<String> rightAccent = new ArrayList<String>(Arrays.asList("7", "8", "9", "0", "-", "=", "u", "i", "o", "p", "[", "]"));
		ArrayList<String> leftTap = new ArrayList<String>(Arrays.asList("a", "s", "d", "f", "g", "z", "x", "c", "v", "b"));
		ArrayList<String> rightTap = new ArrayList<String>(Arrays.asList("h", "j", "k", "l", ";", "'", "n", "m", ",", ".", "/"));

		//represents every playable key
		ArrayList<String> keyboard = new ArrayList<String>();
		keyboard.addAll(leftAccent);
		keyboard.addAll(rightAccent);
		keyboard.addAll(leftTap);
		keyboard.addAll(rightTap);

		boolean[] held = new boolean[keyboard.size()];
		Arrays.fill(held, false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 381);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSaveText = new JMenuItem("Save Text");
		mnFile.add(mntmSaveText);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnFile.add(menuBar_1);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutStickingHelper = new JMenuItem("About Sticking Helper");
		mnHelp.add(mntmAboutStickingHelper);
		
		JMenuItem mntmCheatSheet = new JMenuItem("Cheat Sheet");
		mnHelp.add(mntmCheatSheet);
		
		JMenuBar menuBar_2 = new JMenuBar();
		mnHelp.add(menuBar_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel titlePanel = new JPanel();
		contentPane.add(titlePanel, BorderLayout.NORTH);

		//creates title
		JLabel titleLabel = new JLabel("Sticking Helper");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		titlePanel.add(titleLabel);

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		//allows textArea to be scrollable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel textPanel = new JPanel();
		scrollPane.setViewportView(textPanel);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);

		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//figures out which key was pressed
				char c = arg0.getKeyChar();
				String key = Character.toString(c);
				
				//sets corresponding key index to true to show that it is being held
				int keyIndex = keyboard.indexOf(key);
				
				if(held[keyIndex] == false)
				{
					//retrieves text that is already in the textArea
					String currentText = "";
					try
					{
						currentText = textArea.getText();
					}
					catch(NullPointerException e)
					{
					}


					if(leftTap.contains(key))
					{
						if(textArea.equals("Start Drumming!!"))
						{
							textArea.setText("l ");
						}
						else
						{
							textArea.setText(textArea.getText() + "l ");
						}
					}
					else if(rightTap.contains(key))
					{
						if(textArea.getText().equals("Start Drumming!!"))
						{
							textArea.setText("r ");
						}
						else
						{
							textArea.setText(textArea.getText() + "r ");
						}
					}
					else
					{
						//ignore
					}

					if(leftAccent.contains(key))
					{
						if(textArea.getText().equals("Start Drumming!!"))
						{
							textArea.setText("L ");
						}
						else
						{
							textArea.setText(textArea.getText() + "L ");
						}		
					}
					else if(rightAccent.contains(key))
					{
						if(textArea.getText().equals("Start Drumming!!"))
						{
							textArea.setText("R ");
						}
						else
						{
							textArea.setText(textArea.getText() + "R ");
						}		
					}
				}
				
				//indicates that the key is being held down until the key is released
				held[keyIndex] = true;
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				//figures out which key was pressed
				char c = arg0.getKeyChar();
				String key = Character.toString(c);
				
				//sets corresponding key index to true to show that it is being held
				int keyIndex = keyboard.indexOf(key);
				
				//indicates that the key was released
				held[keyIndex] = false;
			}
		});
		textArea.setWrapStyleWord(true);
		textArea.setText("Start Drumming!!");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 12));
		textArea.setColumns(45);
		textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 225, 4));
		textPanel.add(textArea);

		JButton copyAllButton = new JButton("Copy All");
		copyAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringSelection stringSelection = new StringSelection (textArea.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);

				//sets focus back to textArea after button is pressed
				textArea.requestFocusInWindow();
			}
		});
		buttonPanel.add(copyAllButton);

		JButton clearAllButton = new JButton("Clear All");
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");

				//sets focus back to textArea after button is pressed
				textArea.requestFocusInWindow();
			}
		});
		buttonPanel.add(clearAllButton);		
	}

}
