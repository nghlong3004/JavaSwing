package GamePikachu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private static final long serialVersionUID = 1L;
	private String admName = "nghlong3004";
	private String admPass = "123456";
	private JButton button;
	private	JPasswordField pass;
	private JTextField name;
	private JLabel labelOne, labelTwo;
	private JPanel panel, pOne, pTwo;
	
	public LoginForm(){
		setTitle("Login");
		button = new JButton("Login");
		pass = new JPasswordField(20);
		name = new JTextField(20);
		labelOne = new JLabel("TK");
		labelTwo = new JLabel("MK");
		panel = new JPanel();
		pOne = new JPanel();
		pTwo = new JPanel();
		pass.setText(admPass);
		name.setText(admName);
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
		pack();
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginForm();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String a = String.valueOf(name.getText());
		String b = String.valueOf(pass.getPassword());
		if(admName.equals(a) && admPass.equals(b)){
			JOptionPane.showMessageDialog(this, "Access Login", "Message", JOptionPane.PLAIN_MESSAGE, null);
			this.dispose();
			new Source(new UserForm());
		}
		else{
			JOptionPane.showMessageDialog(this, "Error PassWorld", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
