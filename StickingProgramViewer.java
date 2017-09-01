import javax.swing.JFrame;

public class StickingProgramViewer 
{

	public static void main(String[] args) 
	{
		JFrame frame = new StickingFrame(800, 600);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

}
