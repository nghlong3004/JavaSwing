package GamePikachu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private final static String address = "C:\\Users\\hh1305\\LONG\\JAVA\\JavaSwing\\src\\GamePikachu\\Image\\";
	private static final long serialVersionUID = 1L;
	private JButton button;
	private	JPasswordField pass;
	private JTextField name;
	private JLabel labelOne, labelTwo;
	private JPanel panel, pOne, pTwo;
	private UserForm user;
	
	public LoginForm(){
		setTitle("Login");
		user = new UserForm();
		button = new JButton();
		ImageIcon old = new ImageIcon(address + "Login" + ".jpg");
		Image cur = old.getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH);
		button.setBackground(Color.white);
		button.setIcon(new ImageIcon(cur));
		pass = new JPasswordField(20);
		name = new JTextField(20);
		labelOne = new JLabel();
		labelTwo = new JLabel();
		old = new ImageIcon(address + "Name" + ".jpg");
		cur = old.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		labelOne.setIcon(new ImageIcon(cur));
		old = new ImageIcon(address + "Pass" + ".jpg");
		cur = old.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		labelTwo.setIcon(new ImageIcon(cur));
		panel = new JPanel();
		pOne = new JPanel();
		pTwo = new JPanel();
		pass.setText(user.getAdmPass());
		name.setText(user.getAdmName());
		button.addActionListener(this);
		pOne.add(labelOne, BorderLayout.CENTER);
		pOne.add(name);
		pTwo.add(labelTwo);
		pTwo.add(pass);
		panel.add(pOne);
		panel.add(pTwo);
		panel.add(button);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		pack();
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String a = String.valueOf(name.getText());
		String b = String.valueOf(pass.getPassword());
		if(user.getAdmName().equals(a) && user.getAdmPass().equals(b)){
			JOptionPane.showMessageDialog(this, "Access Login", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
			new Source(new UserForm());
		}
		else{
			JOptionPane.showMessageDialog(this, "Error PassWorld", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
