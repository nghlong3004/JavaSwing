package GamePikachu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SourcePanel{
	private JPanel panel, namePanel;
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
		namePanel = new JPanel();
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		namePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		int spacing = 10;
		c.insets = new Insets(spacing, spacing, spacing, spacing);
		for(int i = 0; i < SourceButton.getRow(); ++i){
			c.gridy = i + 1;
			for(int j = 0; j < SourceButton.getCol(); ++j){
				c.gridx = j;
				panel.add(scButton.getSolveButton()[i][j], c);
			}
		}
		c.gridy = 0;
		c.gridx = 0;
		name.setPreferredSize(new Dimension(70, 50));
		panel.add(name, c);
		c.gridx = 5;
		panel.add(scButton.getScoreJlabel(), c);
		c.gridy = SourceButton.getRow() + 1;
		c.gridx = 0;
		panel.add(scButton.getReset(), c);
	}
}
