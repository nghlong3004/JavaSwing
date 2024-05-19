package GamePikachu;


import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Source extends JFrame{
	private SourcePanel scPanel;
	public SourcePanel getScPanel() {
		return scPanel;
	}
	public Source(UserForm User){
		scPanel = new SourcePanel(User.getNameUser());
		this.add(scPanel.getPanel());
		this.setMinimumSize(new Dimension(400, 300));
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Pikachu");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
