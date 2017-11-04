package proj2;
import java.util.ArrayList;
import java.util.Observable;


public class CGLModel extends Observable {
	
	private Population pop;
	private int generation;
	private boolean timeState;
	private Pair<Integer,Integer> p;
	
	public CGLModel(){
		this.timeState = false;
		this.pop = new Population();
	}
	
	public CGLModel(Population p) {
		this.pop = p;
	}
	
	public void setPop(Population p){
		this.pop = p;
	}
	
	public Population getPop(){
		return this.pop;
	}
	
	public ArrayList<Pair<Integer,Integer>> getAlive(){
		return this.pop.saveAlive();
	} 
	
	public void setTimeState(boolean b){
		this.timeState = b;
		setChanged();
		notifyObservers();
	}
	
	public boolean isTicking(){
		
		if(this.timeState == true){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Restarts the game by giving the game an empty population
	 */
	public void restart(){
		this.pop = new Population();
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Gives the game a random population
	 */
	public void random(){
		this.pop = new Population().random();
		setChanged();
		notifyObservers();
	}

	/**
	 * Goes up by one when called and goes to the next generation of the population
	 */
	public void incrementGeneration(){
		this.generation += 1;
		this.pop = this.pop.nextGeneration();
		setChanged();
		notifyObservers();
	}
	
	public int getGeneration(){
		return this.generation;
	}
	
	/**
	 * Resets the generation integer to 0
	 */
	public void reset(){
		this.generation = 0;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Adds the clicked cell to the population as well as sending it to the view through the pair variable.
	 * @param x
	 * @param y
	 */
	public void addClicked(int x, int y){
		
		this.p = new Pair<Integer,Integer>(x,y);
		this.pop.setClicked(x,y);
		System.out.println(x + " " + y);
		setChanged();
		notifyObservers();
		
	}
	
	public Pair<Integer,Integer> getPair(){
		return this.p;
	}
	
}
