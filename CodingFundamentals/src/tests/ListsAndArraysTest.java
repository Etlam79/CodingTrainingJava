package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import listsandarrays.DuplicateRemovingList;
import listsandarrays.FindTwoOddNumbersInArray;
import listsandarrays.ListPartitioning;
import listsandarrays.LoopIdentifyingList;
import listsandarrays.ReverseWords;

import org.junit.Test;

import datastructures.LinkedList;
import datastructures.ListElementAdder;
import datastructures.Stack;
import datastructures.helper.Node;

public class ListsAndArraysTest {
	
	
	@Test  
	public void testFindTwoOddNumbers() {
		int[][] tests = {
				{2,3,2,3,3,4}, {3, 4},
				{2,1,2,3,3,1,4,5}, {4, 5},
				{3,5,2,4,3,5},{2,4}
		};
		
		FindTwoOddNumbersInArray solver = new FindTwoOddNumbersInArray();
		
		for (int i = 0; i < tests.length; i+=2) {
			Integer[] result = solver.find(tests[i]);			
			
			for (int expectedValue : tests[i+1]) {
				assertArrayContains(result, expectedValue); 
			}				
		}		
	}
	


	@Test 
	public void testReverseWords() {
		char[] test0 = "What a wonderful world".toCharArray();
		char[] test1 = "What a wonderful world!".toCharArray();
		char[] test2 = "".toCharArray();
		char[] test3 = "W".toCharArray();
		char[] test4 = "A B C D E".toCharArray();
		
		ReverseWords.reverse(test0);
		assertArrayEquals(Arrays.toString(test0), "world wonderful a What".toCharArray(), test0);
		

		ReverseWords.reverse(test1);
		assertArrayEquals(Arrays.toString(test1), "world! wonderful a What".toCharArray(), test1);
		

		ReverseWords.reverse(test2);
		assertArrayEquals(Arrays.toString(test2), "".toCharArray(), test2);
		

		ReverseWords.reverse(test3);
		assertArrayEquals(Arrays.toString(test3), "W".toCharArray(), test3);
		
		
		ReverseWords.reverse(test4);
		assertArrayEquals(Arrays.toString(test4), "E D C B A".toCharArray(), test4);
		
		
	}

	private final String[][] tests = {
			{"aa", "[a]"},
			{"aba","[a, b]"}, 
			{"aabbc","[a, b, c]"},
			{"aabc","[a, b, c]"},
			{"abb","[a, b]"}
	};
	
	@Test
	public void testReverseList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.reverse();
		int val = 6;	
		for (Integer integer : list) {
			assertEquals(val, integer.intValue());
			val--;
		}
									
	}
	
	@Test
	public void testRemoveDuplicates() {
			
		for (int i = 0; i < tests.length; i++) {
			DuplicateRemovingList<String> list = new DuplicateRemovingList<String>();
			buildList(list, tests[i][0]);
			list.removeDuplicates();			
			assertEquals(tests[i][1], list.toString());
		}							
	}
	
	@Test
	public void testRemoveDuplicatesNoBuffer() {
			
		for (int i = 0; i < tests.length; i++) {			
			DuplicateRemovingList<String> list = new DuplicateRemovingList<String>();
			buildList(list, tests[i][0]);
			list.removeDuplicatesNoBuffer();
			assertEquals(tests[i][1], list.toString());
		}							
	}
	
	@Test
	public void testFindNthElement() {		

		for (int i = 0; i < tests.length; i++) {	
			DuplicateRemovingList<String> list = new DuplicateRemovingList<String>();
			buildList(list, tests[i][0]);
 			
 			for (int j = 0; j < tests[i][0].length(); j++) {
 				assertEquals("searching the " + j + "th element of " + Arrays.toString(tests[i]), 
 						tests[i][0].charAt(tests[i][0].length()-1-j)+"", list.findNthToLastElement(j));			
			}
		}
		
	}

	
//	@Test
//	public void testRemoveElem() {		
//
//		for (int i = 0; i < tests.length; i++) {
//
//			DuplicateRemovingList<String> list  = new DuplicateRemovingList<String>();
//			buildList(list, tests[i][0]);
//			
// 			for (int j = 0; j < tests[i].length; j++) 
//				list.add(tests[i][j]);
// 			
// 			Node<String> toBeRemoved = list.getFirst();
// 			for (int j = 0; j < tests[j].length; j++) {
// 				
//// 				
//// 				assertEquals("removing the " + j + "th element of " + Arrays.toString(tests[i]), 
//// 						tests[i][tests[i].length-1-j], rm.removeElem((list, toBeRemoved));			
//			}<>
//		}
		
	
	@Test
	public void testPartitioning() {		 
		ListPartitioning<String> list = new ListPartitioning<String>();
		buildList(list, "4728932543");
		list.paritioning("5");
		assertEquals("[4, 2, 3, 2, 4, 3, 7, 8, 9, 5]", list.toString());
		
		
		buildList(list, "2");
		list.paritioning( "5");
		assertEquals("[2]", list.toString());
		
		buildList(list,"2");
		list.paritioning("-5");
		assertEquals("[2]", list.toString());
		
		buildList(list,"98765432");
		list.paritioning("5");
		assertEquals("[4, 3, 2, 9, 8, 7, 6, 5]", list.toString());
	}
	


	@Test
	public void testSum() {
		ListElementAdder adder = new ListElementAdder();
		LinkedList<Integer> lhs = createList(716);
		LinkedList<Integer> rhs = createList(592);
		LinkedList<Integer> sum = createList(219);
		assertEquals(sum.toString(), adder.addBackwards(lhs,rhs).toString());
		
		lhs = createList(617);
		rhs = createList(295);
		sum = createList(912);
		assertEquals(sum.toString(), adder.addForewards(lhs,rhs).toString());
	}
	
	
	@Test
	public void testCircle() {
		Node<String> a = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> c = new Node<String>("C");
		Node<String> d = new Node<String>("D");
		Node<String> e = new Node<String>("E");
		
		
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		
		LoopIdentifyingList<String> list = new LoopIdentifyingList<String>(a);
		e.setNext(c);
		
		assertEquals("C", list.findLoop().getVal());
	}
	
	
	private LinkedList<Integer> createList(int elements) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		while (elements > 0) {
			int digit = elements % 10;
			stack.push(digit);
			elements = elements / 10;			
		}
		while (!stack.isEmpty()) 
			list.add(stack.pop());			
		return list;
	}	
	

	
	private LinkedList<String> buildList(LinkedList<String> list, String elements) {
		list.removeAll();
		for (int i = 0; i < elements.length(); i++) 
			list.add(elements.charAt(i)+"");
		return list;
	}
	
	private void assertArrayContains(Integer[] result, int expectedValue) {		
		assertTrue(String.format("%s, %s", Arrays.toString(result), expectedValue), Arrays.asList(result).contains(expectedValue));		
	}
}
