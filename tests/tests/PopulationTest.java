package tests;

import static org.junit.Assert.*;
import proj2.Population;

import org.junit.Test;

public class PopulationTest {

	@Test
	public void testGetPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAliveAt() {
		
		boolean[][] t = {{true,true,true},{true,true,true},{false,false,true}};
		Population pop = new Population(t);
		
		assertEquals(true,pop.isAliveAt(1,1));
	}

	@Test
	public void testCheckNeighborsAt() {
		boolean[][] t = {{true,true,true},{true,true,true},{false,false,true}};
		Population p = new Population(t);
		
		assertEquals(6,p.checkNeighborsAt(1,1));
		assertEquals(5,p.checkNeighborsAt(0,1));
		assertEquals(3,p.checkNeighborsAt(0,0));
		
	}

	@Test
	public void testSetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextStateOf() {
		
		boolean[][] t = {{false,true,false},{false,true,false},{false,true,false}};
		
		Population p = new Population(t);
		
		assertEquals(true,p.nextStateOf(1,1));
		assertEquals(false,p.nextStateOf(0,1));
		assertEquals(false,p.nextStateOf(2,1));
		assertEquals(true,p.nextStateOf(1,0));
		assertEquals(true,p.nextStateOf(1,2));
		
	}
	
	@Test
	public void testNextGeneration(){
	
		System.out.println("Start.");
		boolean[][] before = {{false,false,false},{true,true,true},{false,false,false}};
		boolean[][] after = {{false,true,false},{false,true,false},{false,true,false}};
		
		Population be = new Population(before);
		
		Population Newbe = be.nextGeneration();
		
		assertArrayEquals(after,Newbe.getPop());
		
		assertArrayEquals(before, Newbe.nextGeneration().getPop());
		
		
	}

}
