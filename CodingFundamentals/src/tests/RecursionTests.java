package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import recursion.Exponental;
import recursion.Fibonacci;
import recursion.MagicIndex;
import recursion.Parenthesis;
import recursion.PowerSet;
import recursion.Robot;
import recursion.StaircaseHops;
import recursion.StringPermutations;
import recursion.eightqueens.EightQueens;
import recursion.helper.Map;
import recursion.helper.Position;
import recursion.maze.MazeMap;
import datastructures.ArrayList;

public class RecursionTests {
	
	@Test
	public void testExponential() {
		int[][] tests = {{2, 2}, {2, -2}, {2, 10}, {-2, 9}, {2,-2}, {715, 321}};
		Exponental e = new Exponental();
			
		for (int[] test : tests) {
			double expected  = Math.pow(test[0],test[1]);
			String name = test[1] + ","; 
			assertEquals(name , expected, e.exp(test[0], test[1]), 0);
			assertEquals(name , expected, e.expRek(test[0], test[1]), 0);
//			assertEquals(name , expected, e.ipow(test[0], test[1]), 0);
			
		}

		
	}
	
	
	@Test
	public void testNQueens() {
		
		assertEquals(1, new EightQueens(1).placeQueens());		
		assertEquals(0, new EightQueens(2).placeQueens());
		assertEquals(0, new EightQueens(3).placeQueens());
		
		assertEquals(2, new EightQueens(4).placeQueens());		
		assertEquals(10, new EightQueens(5).placeQueens());
		assertEquals(40, new EightQueens(7).placeQueens());
		assertEquals(92, new EightQueens(8).placeQueens());
		
	}
	@Test
	public void testParenthesis() {
		Parenthesis p = new Parenthesis();
		ArrayList<String> list = p.parenthesis(3);
		System.err.println(list);
	}
	
	@Test
	public void testPowerSet() {
		PowerSet<String> ps= new PowerSet<String>();
		
		ArrayList<String> test = new ArrayList<String>();
		test.add("a");
		test.add("b");
		test.add("c");
		
		ArrayList<ArrayList<String>> set = ps.powerSet(test);
		assertEquals(8, set.size());
		assertEquals("[[], [c], [b], [c, b], [a], [c, a], [b, a], [c, b, a]]", set.toString());
		
	}
	
	@Test
	public void testMaze() {
		
		int[][] map = {
				{ 1, 1, 1, 2, 1 },
				{ 1, 2, 1, 1, 1 }				
			};
		MazeMap m = new MazeMap(map);
		assertEquals(Map.BLOCK, m.getValueAt(1, 1));		
		assertEquals(Map.BLOCK, m.getValueAt(new Position(1, 1)));
		assertEquals(Map.BLOCK, m.getValueAt(3, 0));		
		assertEquals(Map.BLOCK, m.getValueAt(new Position(3, 0)));
		
		assertEquals(2, m.getValueAt(3, 0));	
		m.setValueAt(new Position(3,0),m.getValueAt(new Position(3, 0)));
		assertEquals(2, m.getValueAt(3, 0));
		m.setValueAt(new Position(3,0),m.getValueAt(new Position(3, 0))+5);
		assertEquals(7, m.getValueAt(3, 0));		
		
//		int[][] map2 = {
//				{ 0, 0, 0,1, 0 },
//				{ 0, 1, 0, 0, 0 },
//				{ 0, 1, 0, 0, 3 },
//				{ 0, 0, 0, 1, 0 },
//				{ 0, 0, 0, 0, 0 }
//			};
//		
//		Maze m = new Maze(new MazeMap(map), new Position(0,0));
//		MazeWindow w = new MazeWindow(m);
//		m.findExit();
		
	}
	

	@Test
	public void testPermuteString() {
		StringPermutations s = new StringPermutations();
		String[] var = s.permutationsOf("abc");
		for (int i = 0; i < var.length; i++) {
			System.out.println(var[i]);
		}
	}

	@Test
	public void testMagicValuse() {		
		MagicIndex m = new MagicIndex();
		
		int[] test = {-10, -5, -3,-1, 0, 4, 6, 8, 10};
		assertEquals(6, m.findMagicIndex(test));
		
		test = new int[0];
		assertEquals(Integer.MIN_VALUE, m.findMagicIndex(test));
		
		test = new int[]{0};
		assertEquals(0, m.findMagicIndex(test));
		
	 test = new int[]{-10, -5, -3,-1, 0, 2, 4, 6, 7, 10};
		assertEquals(Integer.MIN_VALUE, m.findMagicIndex(test));
	}
	
	@Test
	public void testRobot() {
		
		int[][] map = {
			{ 0,  0, 0, -1, 0 },
			{ 0, -1, 0,  0, 0 },
			{ 0, -1, 0,  0, 0 },
			{ 0,  0, 0, -1, 0 },
			{ 0,  0, 0,  0, 0 }
		};
		Robot r = new Robot(map);
		r.findPaths();
	}
	
	@Test
	public void testStaircaseHops() {
		StaircaseHops h = new StaircaseHops();
		assertEquals (0, h.hop(0));
		assertEquals (1, h.hop(1));
		assertEquals (2, h.hop(2));
		assertEquals (4, h.hop(3));
		assertEquals (13, h.hop(5));
		
		
		assertEquals (0, h.hopDyn(0));
		assertEquals (1, h.hopDyn(1));
		assertEquals (2, h.hopDyn(2));
		assertEquals (4, h.hopDyn(3));
		assertEquals (13, h.hopDyn(5));
	}


	
	@Test
	public void testFibbonacciIterative() {
		long[] res = {1, 1, 2, 3, 5, 8, 13, 21};
		long fib25 = 75025;
		Fibonacci fib = new Fibonacci();
		
		
		for (int i = 0; i < res.length; i++) {
			assertEquals(res[i], Fibonacci.fibIter(i+1));	
			assertEquals(res[i], Fibonacci.fib(i+1));	
			assertEquals(res[i], fib.fibDyn(i+1));	
		}
		
		assertEquals(fib25, Fibonacci.fibIter(25));	
		assertEquals(fib25, Fibonacci.fib(25));	
		assertEquals(fib25, fib.fibDyn(25));	
		

	}
}
	
