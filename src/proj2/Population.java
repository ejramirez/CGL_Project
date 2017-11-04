package proj2;

import java.util.ArrayList;
import java.util.Random;

public class Population {

	// Row, Column
	boolean[][] pop;
	
	public Population(){
		this.pop = new boolean[25][20];
	}
	
	public Population(int r, int c){
		this.pop = new boolean[r][c];
	}

	public Population(boolean[][] p) {
		this.pop = p;
	}
	
	public boolean[][] getPop(){
		return this.pop;
	}
	
	public void setPop(boolean[][] p){
		this.pop = p;
	}
	
	public boolean isAliveAt(int row, int column){
		return this.pop[row][column];
	}

	public void setClicked(int i, int j){
				
		this.setState(i,j,true);
		
	}
	
	/**
	 * Randomly Generates Cells in the game.
	 * @return
	 */
	public Population random(){
		boolean[][] randomGen = new boolean[this.pop.length][this.pop[0].length];
		boolean alt = false;
		Random rand = new Random();
		
		for(int i = 0; i < randomGen.length; i++){
			for(int j = 0; j < randomGen[0].length; j++){
				
				int k = rand.nextInt(i * randomGen[0].length + j + 1);
				int swapRow = k / randomGen[0].length;
				int swapColumn = k % randomGen[0].length;
				boolean temp = randomGen[swapRow][swapColumn];
				randomGen[swapRow][swapColumn] = alt;
				randomGen[i][j] = temp;
				alt = !alt;
				
			}
		}
		
		Population p = new Population(randomGen);
		return p;
	}
	
	/**
	 * Checks the state of the neighbors around and counts those who are alive
	 * @param row
	 * @param column
	 * @return
	 */
	public int checkNeighborsAt(int row, int column){
		
		int alive = 0;
		
		int ur = Math.max(row - 1, 0);
		int lr = Math.min(row + 1, this.pop.length - 1);
		
		int lc = Math.max(column - 1, 0);
		int rc = Math.min(column + 1, this.pop[0].length - 1);
		
		for(int i = ur; i <= lr; i++){
			for(int j = lc; j <= rc; j++){
				
				//System.out.println("(" + i + "," + j + "): " + this.isAliveAt(i,j));
				alive += this.pop[i][j] ? 1 : 0;
				
			}
			
		}
		
		alive -= this.pop[row][column] ? 1 : 0;
		//System.out.println("total alive around this: " + alive);
		return alive; //not counting itself
		
	}
	
	public void setState(int r, int c, boolean b){
		this.pop[r][c] = b;
	}
	
	/**
	 * The rules for conways game of life
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean nextStateOf(int row ,int column){
		
		if((this.checkNeighborsAt(row,column) < 2 || this.checkNeighborsAt(row,column) > 3) && this.isAliveAt(row,column)){
			return false;
		}else if(this.isAliveAt(row,column)){
			return true;
		}else if(!this.isAliveAt(row,column) && (this.checkNeighborsAt(row,column) == 3)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Grabs all that are alive and outputs a Arraylist<Pair> of the locations of the alive cells
	 * @return
	 */
	public ArrayList<Pair<Integer,Integer>> saveAlive(){
		
		ArrayList<Pair<Integer,Integer>> aliveGroup = new ArrayList<Pair<Integer,Integer>>();
		
		for(int i = 0; i < this.pop.length; i++){
			for(int j = 0; j < this.pop[0].length; j++){
				
				if(isAliveAt(i,j)){
					aliveGroup.add(new Pair<Integer, Integer>(i,j));
				}
				
			}
		}
		
		return aliveGroup;
	}
	
	/**
	 * New population generated based the the state of the previous population
	 * @return
	 */
	public Population nextGeneration(){
		
		boolean[][] nextGen = new boolean[this.pop.length][this.pop[0].length];
		Population p = new Population(nextGen);
		System.out.println(p.getPop().length);
		System.out.println(p.getPop()[0].length);
		
		for(int i = 0; i < this.pop.length; i++){
			for(int j = 0; j < this.pop[0].length; j++){
				
				
				System.out.println("(" + i  + "," + j + ") " + "Old: " + this.isAliveAt(i,j));
				p.setState(i,j,this.nextStateOf(i,j));
				System.out.println(" New: " + p.isAliveAt(i,j));
			}
		}
		
		return p;
	}

}
