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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
		frame.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.add(new JLabel("Info"), BorderLayout.CENTER);
		panel.add(new JLabel("ha"), BorderLayout.NORTH);
		frame.add(new JLabel("Info"), BorderLayout.NORTH);
	     frame.add(new JLabel("Nut"), BorderLayout.SOUTH);
	     frame.add(new JLabel("A"), BorderLayout.EAST);
	     frame.add(new JLabel("B"), BorderLayout.WEST);
	    String s = "C:\\Users\\hh1305\\LONG\\JAVA\\JavaSwing\\src\\GamePikachu\\Image\\1.png";
	    ImageIcon k = new ImageIcon(s);
	    button = new JButton();
	    button.setIcon(k);
	     frame.add(button, BorderLayout.CENTER);
		frame.pack();
		frame.setTitle("Include");
		frame.setBounds(100, 100, 200, 300);
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
