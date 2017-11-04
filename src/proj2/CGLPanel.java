package proj2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class CGLPanel extends JPanel{

	private int squareW = 20;
	private int squareH = 20;
	private ArrayList<Pair<Integer,Integer>> alp;
	
	public CGLPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.alp = new ArrayList<Pair<Integer,Integer>>();
	}

	public Dimension getPreferredSize(){
		return new Dimension(500,400);
	}
	
	public void setALP(ArrayList<Pair<Integer,Integer>> a){
		this.alp = a;
	}
	
	public void addToAlp(Pair<Integer,Integer> p){
		this.alp.add(p);
	}
	
	public void redraw(){
		repaint();
	}
	
	/**
	 * paints a square
	 * @param x
	 * @param y
	 * @param g
	 */
	public void paintSquare(int x, int y, Graphics g){
		
		int columnPos = (int) Math.floor(x * 20);
		int rowPos = (int) Math.floor(y * 20);
		
		System.out.println("RowPos: " + rowPos + " ColumnPos: " + columnPos);
		
		//Draw Squares with g
		g.setColor(Color.RED);
		g.fillRect(columnPos,rowPos,this.squareW,this.squareH);
		g.setColor(Color.BLACK);
		g.drawRect(columnPos,rowPos,this.squareW,this.squareH);
		
	}
	
	/**
	 * Paints a square that was clicked in the game
	 * @param g
	 */
	public void paintClickedSquare(Graphics g){
		
		Pair<Integer,Integer> p = this.alp.get(this.alp.size() - 1);
		
		int columnPos = (int) Math.floor(p.getX() * 20);
		int rowPos = (int) Math.floor(p.getY() * 20);
		
		System.out.println("RowPos: " + rowPos + " ColumnPos: " + columnPos);
		
		this.paintSquare(columnPos,rowPos,g);
	}
	
	/**
	 * Paints an arraylist<pair>
	 * @param g
	 */
	public void paintSquareGroup(Graphics g){
		
		for(Pair<Integer,Integer> pair : this.alp){
			
			this.paintSquare(pair.getX(),pair.getY(), g);
			
		}
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.paintSquareGroup(g);
		
	}
	
}
