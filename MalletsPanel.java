import javax.swing.JPanel;

public class MalletsPanel extends JPanel
{
	private JPanel malletListener;
	
	public MalletsPanel()
	{
		malletListener = new MalletsListenerPanel();
		this.add(malletListener);
	}
}
