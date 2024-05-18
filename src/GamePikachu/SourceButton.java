package GamePikachu;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SourceButton implements ActionListener{
	private final static String address = "C:\\Users\\hh1305\\LONG\\JAVA\\JavaSwing\\src\\GamePikachu\\Image\\";
	private final static int colSize = 100, rowSize = 50;
	private JButton[][] solveButton;
	private JButton oldClick;
	private JButton reset;
	private JLabel scoreJlabel;
	private static ImageIcon[] images;
	private int score = 0;
	private static int countClick;
	private final static int ROW = 6;
	private final static int COL = 6;
	public JButton[][] getSolveButton() {
		return solveButton;
	}
	public void setSolveButton(JButton[][] solveButton) {
		this.solveButton = solveButton;
	}
	public JLabel getScoreJlabel() {
		return scoreJlabel;
	}
	public JButton getReset() {
		return reset;
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
	public static ImageIcon[] pikachuIcon(ImageIcon[] matrix){
		for(int i = 1; i <= (13); ++i){
			ImageIcon old = new ImageIcon(address + (i) + ".png");
			Image cur = old.getImage().getScaledInstance(colSize, rowSize, Image.SCALE_SMOOTH);
			matrix[i] = new ImageIcon(cur);
		}
		return matrix;
	}
	public static void init(JButton[][] solveButton){
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				solveButton[i][j].setText(".");
				solveButton[i][j].setEnabled(true);
			}
		}
		for(int value = 1; value <= (9); ++value){
			for(int p = 0; p < 4; ++p){
				Random numberRow = new Random();
				Random numberCol = new Random();
				int i = numberRow.nextInt(ROW);
				int j = numberCol.nextInt(ROW);
				if(solveButton[i][j].getText().equals(".")){
					solveButton[i][j].setText("" + value);
					solveButton[i][j].setIcon(images[13]);
				}
				else{
					boolean okIndex = true;
					for(int col = 0; col < ROW && okIndex; ++col){
						for(int row = 0; row < ROW && okIndex; ++row){
							if(indexNull(solveButton[col][row].getText())){
								solveButton[col][row].setText("" + value);
								solveButton[col][row].setIcon(images[13]);
								okIndex = false;
							}
						}
					}
				}
			}
		}
	}
	public SourceButton(){
		images = new ImageIcon[50];
		solveButton = new JButton[ROW][COL];
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				solveButton[i][j] = new JButton();
				solveButton[i][j].setPreferredSize(new Dimension(colSize, rowSize));
				solveButton[i][j].setBackground(Color.white);
			}
		}
		reset = new JButton("Reset"); 
		scoreJlabel = new JLabel("Score : 0");
		images = pikachuIcon(images);
		init(solveButton);
		scoreJlabel.setPreferredSize(new Dimension(colSize, rowSize));
		reset.setPreferredSize(new Dimension(colSize, rowSize));
		for(int i = 0; i < ROW; ++i){
			for(int j = 0; j < COL; ++j){
				solveButton[i][j].addActionListener(this);
			}
		}
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		countClick = (countClick + 1) % 2;
		final JButton click = (JButton) e.getSource();
		if(click.getText().equals(reset.getText())){
			init(solveButton);
			score = 0;
			countClick = 0;
			scoreJlabel.setText("Score : " + score);
		}
		else{
			if(countClick == 1){
				click.setIcon(images[Integer.parseInt(click.getText())]);
				oldClick = click;
			}
			else{
				click.setIcon(images[Integer.parseInt(click.getText())]);
				if(oldClick.getText().equals(click.getText())){
					score += 10;
					scoreJlabel.setText("Score :" + score);
					oldClick.setIcon(images[12]);
					click.setIcon(images[12]);
					oldClick.setEnabled(false);
					click.setEnabled(false);
				}
				else{
					oldClick.setIcon(images[13]);
					click.setIcon(images[13]);
				}
			}
		}
	}

}
