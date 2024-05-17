package GamePikachu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

public class SourceButton implements ActionListener{
	private JButton[][] button;
	private JButton oldClick;
	private JButton reset;
	private JLabel scoreJlabel;
	private int score = 0;
	private static int countClick;
	private final static int ROW = 6;
	private final static int COL = 6;
	public  JButton[][] getButton() {
		return button;
	}
	public JLabel getScoreJlabel() {
		return scoreJlabel;
	}
	public JButton getReset() {
		return reset;
	}
	public void setButton(JButton[][] button, int i, int j , int value) {
		button[i][j].setText("" + value);
		this.button = button;
	}
	public static int getRow() {
		return ROW;
	}
	public static int getCol() {
		return COL;
	}
	public static boolean indexNull(String value){
		if(value.equals(".")){
			return true;
		}
		return false;
	}
	public static JButton[][] init(JButton[][] matrix){
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				matrix[i][j].setText(".");
				matrix[i][j].setBackground(Color.white);
			}
		}
		for(int value = 1; value <= (ROW * COL >> 2); ++value){
			for(int p = 0; p < 4; ++p){
				Random numberRow = new Random();
				Random numberCol = new Random();
				int i = numberRow.nextInt(ROW);
				int j = numberCol.nextInt(ROW);
				if(matrix[i][j].getText().equals(".")){
					matrix[i][j].setText("" + value);
				}
				else{
					boolean okIndex = true;
					for(int col = 0; col < ROW && okIndex; ++col){
						for(int row = 0; row < ROW && okIndex; ++row){
							if(indexNull(matrix[col][row].getText())){
								matrix[col][row].setText("" + value);
								okIndex = false;
							}
						}
					}
				}
			}
		}
		
		return matrix;
	}
	public SourceButton(){
		button = new JButton[ROW][COL];
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				button[i][j] = new JButton();
				button[i][j].setPreferredSize(new Dimension(50, 50));
			}
		}
		reset = new JButton("Reset");
		scoreJlabel = new JLabel("Score : 0");
		button = init(button);
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				button[i][j].addActionListener(this);
			}
		}
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		countClick = (countClick + 1) % 2;
		JButton click = (JButton) e.getSource();
		click.setVisible(false);
		if(click.getText().equals(reset.getText())){
			button = init(button);
			score = 0;
			countClick = 0;
			scoreJlabel.setText("Score :" + score);
		}
		else{
			if(countClick == 1){
				oldClick = click;
				click.setBackground(Color.green);
			}
			else{
				if(oldClick.getText().equals(click.getText())){
					click.setBackground(Color.LIGHT_GRAY);
					oldClick.setBackground(Color.LIGHT_GRAY);
					score += 10;
					scoreJlabel.setText("Score :" + score);
				}
				else{
					oldClick.setBackground(Color.white);
				}
			}
		}
	}

}
