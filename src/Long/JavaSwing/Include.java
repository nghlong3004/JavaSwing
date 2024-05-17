package Long.JavaSwing;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;


public class Include extends JFrame implements ActionListener{
	private String PassWorld = "1";
	public String getPassWorld() {
		return PassWorld;
	}

	public void setPassWorld(String passWorld) {
		PassWorld = passWorld;
	}

	private JFrame frame;
	private JButton button;
	private JPasswordField pass;
	private JPanel panel, p1, p2;
	private JTextField text;
	private JRadioButton box0, box1;
	private ButtonGroup group;
	private JComboBox cbBox;
	public Include(){
		
		frame = new JFrame();
		button = new JButton("Login");
		text = new JTextField(25);
		pass = new JPasswordField(25);
		panel = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		box0 = new JRadioButton();
		box1 = new JRadioButton();
		String s1[] = { "Jalpaiguri", "Mumbai", "Noida", "Kolkata", "New Delhi" };
		cbBox = new JComboBox(s1);
		pass.setText("1");
		text.setText("0");
		box0.setText("VietNam");
		box1.setText("China");
		group = new ButtonGroup();
		group.add(box0);
		group.add(box1);
		box0.setSelected(true);
		button.addActionListener(this);
		p2.add(pass);
		p2.add(text);
		p1.add(box0);
		p1.add(box1, BorderLayout.CENTER);
		p1.add(cbBox);
		p2.add(button);
		panel.add(p1);
		panel.add(p2);
		panel.setLayout(new GridLayout(4, 6 ,4 , 2));
		frame.add(panel);
		frame.pack();
		frame.setTitle("Include");
		frame.setSize(350, 530);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Include();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = String.valueOf(pass.getPassword());
		String outSide = "";
		if(s.equals(PassWorld)){
			//JOptionPane.showMessageDialog(box0, "Access Login", "Message", JOptionPane.INFORMATION_MESSAGE);
			frame.dispose();
			new Calculator();
		}
		if(group.getSelection().equals(box0.getModel())){
			outSide += box0.getText();
		}
		if(group.getSelection().equals(box1.getModel())){
			outSide += box1.getText();
		}
		outSide += cbBox.getSelectedItem();
		text.setText(outSide);
	}
	
}
