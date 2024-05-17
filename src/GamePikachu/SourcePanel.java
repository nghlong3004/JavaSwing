package GamePikachu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SourcePanel{
	private JPanel panel, pl, pr, p1;
	private SourceButton scButton;
	public SourceButton getScButton() {
		return scButton;
	}
	public void setScButton(SourceButton scButton) {
		this.scButton = scButton;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public void setPanel(JButton add){
		this.panel.add(add);
	}
	public SourcePanel(String user){
		scButton = new SourceButton();
		JLabel name = new JLabel("Name: " + user);
		panel = new JPanel();
		pl = new JPanel();
		pr = new JPanel();
		p1 = new JPanel();
		pl.add(name);
		p1.add(scButton.getScoreJlabel());
		pr.add(p1);
		panel.add(pl);
		panel.add(pr);
		for(int i = 0; i < SourceButton.getRow(); ++i){
			final JPanel p = new JPanel();
			for(int j = 0; j < SourceButton.getCol(); ++j){
				p.add(scButton.getButton()[i][j]);
			}
			panel.add(p);
		}
		panel.add(scButton.getReset());
		panel.setLayout(new GridLayout(6, 2));
	}
}
