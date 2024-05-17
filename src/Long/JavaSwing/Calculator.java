package Long.JavaSwing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public static double result(String currentS, String newS){
		double c = Double.parseDouble(newS);
		if(currentS.isEmpty()){
			return c;
		}
		String s = "";
		for(int i = 0; i < currentS.length(); ++i){
			if(currentS.charAt(i) == ' '){
				break;
			}
			s += currentS.charAt(i);
		}
		if(s.isEmpty()){
			return c;
		}
		double a = Double.parseDouble(s);
		char b = '+';
		if(currentS.length() > 0){
			b = currentS.charAt(currentS.length() - 1);
		}
		double res = 0;
		if(b == '+'){
			res = a + c;
		}
		else if(b == '-'){
			res = a - c;
		}
		else if(b == '*'){
			res = a * c;
		}
		else if(b == '/'){
			res = a / c;
		}
		else{
			res = a + c;
		}
		
		return res;
	}
	public static String stand(String s){
		int flag = 1;
		String res = "";
		int n = s.length() - 1;
		for(int i = 0; i < s.length(); ++i){
			if(s.charAt(i) == 'E'){
				if(s.charAt(i + 1) != '-'){
					flag = 0;
				}
				break;
			}
		}
		if(flag == 0){
			res += s.charAt(0);
			int m = s.charAt(n) - '0';
			for(int i = 2; i < n && s.charAt(i) != 'E'; ++i){
				res += s.charAt(i);
				--m;
				if(m == 0){
					if(i + 1 < n && s.charAt(i + 1) != 'E'){
						res += '.';
					}
				}
			}
			while(m > 0){
				res += '0';
				--m;
			}
			s = res;
			res = "";
		}
		n = s.length() - 1;
		while(n >= 0){
			if(s.charAt(n) == '.'){
				--n;
				break;
			}
			--n;
		}
		if(n < 0){
			n = s.length() - 1;
		}
		for(int i = 0; i <= n; ++i){
			if(i > 0 && i % 3 == (n + 1) % 3){
				res += ',';
			}
			res += s.charAt(i);
		}
		if(n + 2 < s.length()){
			String mod = "";
			if(s.charAt(n + 2) >= '0' && s.charAt(n + 2) <= '9'){
				mod += '.';
				for(int i = n + 2; i < s.length(); ++i){
					if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
						mod += s.charAt(i);
					}
					else{
						break;
					}
				}
			}
			if(mod.length() > 2 || (mod.length() == 2 && mod.charAt(1) > '0')){
				res += mod;
			}
		}
		
		return res;
	}
	
	public Calculator() {
		JFrame frame = new JFrame();
		final JTextField inSideText = new JTextField(25);
		final JTextField outSideText = new JTextField(25);
		final JTextField flag = new JTextField(5), debug = new JTextField(25);
		final JTextField text = new JTextField(25);
		flag.setText("0");
		outSideText.setText("0");
		inSideText.setText("0");
		debug.setPreferredSize(new Dimension(50, 30));
		inSideText.setPreferredSize(new Dimension(130, 60));
		text.setPreferredSize(new Dimension(75, 30));
		debug.setEditable(false);
		text.setEditable(false);
		outSideText.setEditable(false);
		JButton j0, j1, j2, j3, j4, j5, j6, j7, j8, j9;
		JButton jm, jd, ja, js, jnp, jr, jc;
		JButton a1, a2, a3, a4;
		JButton b1, b2, b3, b4;
		j0 = new JButton("0");
		j1 = new JButton("1");
		j2 = new JButton("2");
		j3 = new JButton("3");
		j4 = new JButton("4");
		j5 = new JButton("5");
		j6 = new JButton("6");
		j7 = new JButton("7");
		j8 = new JButton("8");
		j9 = new JButton("9");
		jm = new JButton("*");
		jd = new JButton("/");
		ja = new JButton("+");
		js = new JButton("-");
		jnp = new JButton("+/-");
		jr = new JButton("=");
		jc = new JButton(".");
		a1 = new JButton("%");
		a2 = new JButton("CE");
		a3 = new JButton("C");
		a4 = new JButton("<-");
		b1 = new JButton("1/x");
		b2 = new JButton("x^2");
		b3 = new JButton("x^½");
		b4 = new JButton("/");
		j0.setBackground(Color.LIGHT_GRAY);
		j1.setBackground(Color.LIGHT_GRAY);
		j2.setBackground(Color.LIGHT_GRAY);
		j3.setBackground(Color.LIGHT_GRAY);
		j4.setBackground(Color.LIGHT_GRAY);
		j5.setBackground(Color.LIGHT_GRAY);
		j6.setBackground(Color.LIGHT_GRAY);
		j7.setBackground(Color.LIGHT_GRAY);
		j8.setBackground(Color.LIGHT_GRAY);
		j9.setBackground(Color.LIGHT_GRAY);
		jm.setBackground(Color.LIGHT_GRAY);
		jd.setBackground(Color.LIGHT_GRAY);
		ja.setBackground(Color.LIGHT_GRAY);
		js.setBackground(Color.LIGHT_GRAY);
		jnp.setBackground(Color.LIGHT_GRAY);
		jr.setBackground(Color.gray);
		jc.setBackground(Color.LIGHT_GRAY);
		a1.setBackground(Color.LIGHT_GRAY);
		a2.setBackground(Color.LIGHT_GRAY);
		a3.setBackground(Color.LIGHT_GRAY);
		a4.setBackground(Color.LIGHT_GRAY);
		b1.setBackground(Color.LIGHT_GRAY);
		b2.setBackground(Color.LIGHT_GRAY);
		b3.setBackground(Color.LIGHT_GRAY);
		b4.setBackground(Color.LIGHT_GRAY);
		
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton click = (JButton) e.getSource();
				String s = click.getText();
				String currentText = text.getText();
				String newText = inSideText.getText();
				int n = s.length();
				if(s.charAt(0) >= '0' && s.charAt(0) <= '9' && n == 1 ){
					if(flag.getText().charAt(0) == '0'){
						newText = "";
						flag.setText("1");
					}
					if(flag.getText().charAt(0) == '2'){
						newText = "";
						text.setText("");
						flag.setText("1");
					}
					inSideText.setText(newText + s);
					outSideText.setText(stand(newText + s));
				}
				else if(s.equals(".")){
					inSideText.setText(stand(newText) + ".");
					outSideText.setText((stand(newText) + "."));
				}
				else if(s.equals("1/x")){
					text.setText("1/" + inSideText.getText());
					double k = Double.parseDouble(inSideText.getText());
					if(k == 0){
						inSideText.setText("Cannot divide by zero");
						outSideText.setText("Cannot divide by zero");
						flag.setText("2");
					}
					else{
						inSideText.setText("" + Double.toString((double)1/k));
						outSideText.setText(stand(Double.toString((double)1/k)));
					}
				}
				else if(s.equals("x^2")){
					double k = Double.parseDouble(inSideText.getText());
					text.setText(inSideText.getText() + "^2");
					inSideText.setText("" + Double.toString((double)k*k));
					outSideText.setText(stand(Double.toString((double)k*k)));
				}
				else if(s.equals("x^½")){
					double k = Double.parseDouble(inSideText.getText());
					text.setText(inSideText.getText() + "^½");
					inSideText.setText("" + Double.toString((double)Math.sqrt(k)));
					outSideText.setText(stand(Double.toString((double)Math.sqrt(k))));
				}
				else if(s.charAt(0) == '<'){
					if(flag.getText().charAt(0) == '2'){
						text.setText("");
					}
					else{
						String newTextN = "";
						for(int i = 0; i < newText.length() - 1; ++i){
							newTextN += newText.charAt(i);
						}
						if(newTextN.length() == 0){
							newTextN = "0";
							flag.setText("0");
						}
						inSideText.setText(newTextN);
						outSideText.setText(stand(newText));
					}
				}
				else if(s.charAt(0) == 'C' || s.charAt(0) == '%' ){
					flag.setText("0");
					text.setText("");
					inSideText.setText("0");
					outSideText.setText("0");
				}
				else if(s.charAt(0) == '+' && n == 3){
					if(newText.charAt(0) != '-'){
						newText = '-' + newText;
					}
					else{
						int m = newText.length();
						newText = newText.substring(1, m);
					}
					inSideText.setText(newText);
					outSideText.setText(stand(newText));
				}
				else if(s.charAt(0) != '=' && n == 1){
					flag.setText("0");
					if(newText.charAt(newText.length() - 1) == '.'){
						newText = newText.substring(0, newText.length() - 1);
					}
					text.setText(newText + ' ' + s);
					outSideText.setText(newText);
				}
				else if(s.charAt(0) == '='){
					if(flag.getText().charAt(0) == '2'){
						String a , b ,c;
						a = b = c = "";
						int i = 0, m = currentText.length();
						while(i < m && currentText.charAt(i) != ' '){
							a += currentText.charAt(i);
							++i;
						}
						if(i + 1 < m){
							b += currentText.charAt(i + 1);
						}
						i += 3;
						while(i < m && currentText.charAt(i) != ' '){
							c += currentText.charAt(i);
							++i;
						}
						if(c.isEmpty()){
							text.setText(a + ' ' + b);
							inSideText.setText(a);
							outSideText.setText(stand(a));
						}
						else{
							text.setText(newText + ' ' + b + ' ' + c + ' ' + '=');
							newText = Double.toString(result(newText + ' ' + b, c));
							inSideText.setText(newText);
							outSideText.setText(stand(newText));
						}
					}
					else{
						if(currentText.isEmpty()){
							text.setText(newText + ' ' + '=');
							inSideText.setText(newText);
							outSideText.setText(stand(newText));
						}
						else{
							text.setText(currentText + ' ' + newText + ' ' + '=');
							newText = Double.toString(result(currentText, newText));
							inSideText.setText((newText));
							outSideText.setText(stand(newText));
						}
						
						flag.setText("2");
					}
				}
				
			}
		};
		j0.addActionListener(listener);
		j1.addActionListener(listener);
		j2.addActionListener(listener);
		j3.addActionListener(listener);
		j4.addActionListener(listener);
		j5.addActionListener(listener);
		j6.addActionListener(listener);
		j7.addActionListener(listener);
		j8.addActionListener(listener);
		j9.addActionListener(listener);
		jm.addActionListener(listener);
		jd.addActionListener(listener);
		ja.addActionListener(listener);
		js.addActionListener(listener);
		jnp.addActionListener(listener);
		jr.addActionListener(listener);
		jc.addActionListener(listener);
		a1.addActionListener(listener);
		a2.addActionListener(listener);
		a3.addActionListener(listener);
		a4.addActionListener(listener);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		b4.addActionListener(listener);
		int a = 70, b = 40;
		j0.setPreferredSize(new Dimension(a, b));
		j1.setPreferredSize(new Dimension(a, b));
		j2.setPreferredSize(new Dimension(a, b));
		j3.setPreferredSize(new Dimension(a, b));
		j4.setPreferredSize(new Dimension(a, b));
		j5.setPreferredSize(new Dimension(a, b));
		j6.setPreferredSize(new Dimension(a, b));
		j7.setPreferredSize(new Dimension(a, b));
		j8.setPreferredSize(new Dimension(a, b));
		j9.setPreferredSize(new Dimension(a, b));
		jm.setPreferredSize(new Dimension(a, b));
		jd.setPreferredSize(new Dimension(a, b));
		ja.setPreferredSize(new Dimension(a, b));
		js.setPreferredSize(new Dimension(a, b));
		jnp.setPreferredSize(new Dimension(a, b));
		jr.setPreferredSize(new Dimension(a, b));
		jc.setPreferredSize(new Dimension(a, b));
		a1.setPreferredSize(new Dimension(a, b));
		a2.setPreferredSize(new Dimension(a, b));
		a3.setPreferredSize(new Dimension(a, b));
		a4.setPreferredSize(new Dimension(a, b));
		b1.setPreferredSize(new Dimension(a, b));
		b2.setPreferredSize(new Dimension(a, b));
		b3.setPreferredSize(new Dimension(a, b));
		b4.setPreferredSize(new Dimension(a, b));
		FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(10);
		JPanel p = new JPanel(), pl = new JPanel(), p1 = new JPanel(), p2 = new JPanel(), p3 = new JPanel(), p4 = new JPanel();
		JPanel pp = new JPanel(), pa = new JPanel(), pb = new JPanel();
		pp.add(text);
		//pdebug.add(debug);
		//p.add(pdebug);
		p.add(pp);
		pl.add(outSideText);
		p.add(pl);
		pa.add(a1);
		pa.add(a2);
		pa.add(a3);
		pa.add(a4);
		p.add(pa);
		pb.add(b1);
		pb.add(b2);
		pb.add(b3);
		pb.add(b4);
		p.add(pb);
		p1.add(j7);
		p1.add(j8);
		p1.add(j9);
		p1.add(jm);
		p.add(p1);
		p2.add(j4);
		p2.add(j5);
		p2.add(j6);
		p2.add(js);
		p.add(p2);
		p3.add(j1);
		p3.add(j2);
		p3.add(j3);
		p3.add(ja);
		p.add(p3);
		p4.add(jnp);
		p4.add(j0);
		p4.add(jc);
		p4.add(jr);
		p.add(p4);
		p.setLayout(flowLayout);
		frame.add(p);
		frame.pack();
		frame.setTitle("Calculator");
		frame.setSize(350, 530);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		//System.out.println(result("1238 + 1238"));
		new Calculator();
	}
}
