import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrumsListenerPanel extends JPanel implements KeyListener
{

	static ArrayList<String> leftAccent = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "q", "w", "e", "r", "t", "y"));
	static ArrayList<String> rightAccent = new ArrayList<String>(Arrays.asList("7", "8", "9", "0", "-", "=", "u", "i", "o", "p", "[", "]"));
	static ArrayList<String> leftTap = new ArrayList<String>(Arrays.asList("a", "s", "d", "f", "g", "z", "x", "c", "v", "b"));
	static ArrayList<String> rightTap = new ArrayList<String>(Arrays.asList("h", "j", "k", "l", ";", "'", "n", "m", ",", ".", "/"));

	private Boolean fullDiddle;
	private JTextField text;

	public DrumsListenerPanel(JTextField t)
	{		
		text = t;

		fullDiddle = true;
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}

	public void setFullDiddle(Boolean status)
	{
		fullDiddle = status;
	}

	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		char c = arg0.getKeyChar();
		String key = Character.toString(c);

		String currentText = "";
		try
		{
			currentText = text.getText();
		}
		catch(NullPointerException e)
		{
		}

		if(fullDiddle)
		{
			if(leftTap.contains(key))
			{
				if(text.equals("Start drumming!"))
				{
					text.setText("l ");
				}
				else
				{
					text.setText(text.getText() + "l ");
				}
			}
			else if(rightTap.contains(key))
			{
				if(text.getText().equals("Start drumming!"))
				{
					text.setText("r ");
				}
				else
				{
					text.setText(text.getText() + "r ");
				}
			}
			else
			{
				//ignore
			}
		}
		else
		{
			if(leftTap.contains(key))
			{
				if(leftTap.indexOf(key) <= 4)
				{
					//lower row is now dead keys which makes only the first note register
					if(text.getText().equals("Start drumming!"))
					{
						text.setText("l ");
					}
					else
					{
						text.setText(text.getText() + "l ");
					}
				}
			}
			else if(rightTap.contains(key))
			{
				if(rightTap.indexOf(key) <= 5)
				{
					//lower row is now dead keys which makes only the first note register
					if(text.getText().equals("Start drumming!"))
					{
						text.setText("r ");
					}
					else
					{
						text.setText(text.getText() + "r ");
					}				
				}
			}
			else
			{
				//ignore
			}
		}

		if(leftAccent.contains(key))
		{
			if(text.getText().equals("Start drumming!"))
			{
				text.setText("L ");
			}
			else
			{
				text.setText(text.getText() + "L ");
			}		
		}
		else if(rightAccent.contains(key))
		{
			if(text.getText().equals("Start drumming!"))
			{
				text.setText("R ");
			}
			else
			{
				text.setText(text.getText() + "R ");
			}		
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		//no function
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		//no function
	}
}
