package Long.JavaSwing;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HelloSwing {
	public HelloSwing() {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		JButton jb1 = new JButton("Sum");
		JButton jb2 = new JButton("Multiply");
		JButton jb3 = new JButton("Divide"), jb = new JButton("Counter");
		final JLabel jl = new JLabel();
		final JLabel jl1 = new JLabel();
		final JTextField number1 = new JTextField("12");
		final JTextField a = new JTextField("24");
		final JTextArea jA = new JTextArea("A");
		number1.setFont(new Font(null));
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = jA.getText().length();
				jl1.setText("" + x);
			}
		});
		jb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = Integer.parseInt(number1.getText());
				int y = Integer.parseInt(a.getText());
				int sum = x + y;
				jl.setText("" + sum);
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int x = Integer.parseInt(number1.getText());
				int y = Integer.parseInt(a.getText());
				int sum = x * y;
				jl.setText("" + sum);
			}
		});
		JPanel panel = new JPanel();
		panel.add(jb1);
		panel.add(jb2);
		panel.add(jb3);
		panel.add(jb);
		panel.add(number1);
		panel.add(a);
		panel.add(jl);
		panel.add(jA);
		panel.add(jl1);
		panel.setBackground(Color.white);
		panel.setLayout(new GridLayout(10, 6, 2, 10));
		frame.add(panel);
		frame.pack();
		frame.setSize(300, 350);
		frame.setTitle("Java Swing");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HelloSwing();
	}

}
