package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructures.Allrounder;
import datastructures.ArrayList;
import datastructures.HashMap;
import datastructures.Heap;
import datastructures.LinkedList;
import datastructures.Queue;
import datastructures.Tree;

public class DataStructureTest {
	
	@Test
	public void testTree() {
		Tree<String> t = new Tree<String>();
		
		t.setRoot(t.new TreeNode<String>("Malte"));
		
	} 
	
	@Test
	public void testHeap() {
		Heap<Integer> h = new Heap<Integer>();
		h.add(1);
		assertEquals(1, h.peekMin());	
		h.add(31);
		assertEquals(1, h.peekMin());
		h.add(-1);
		System.out.println(h);
		assertEquals(-1, h.extractMin());
		
		System.out.println(h);
		assertEquals(1, h.extractMin());
		assertEquals(31, h.peekMin());
		
		 h = new Heap<Integer>();
		 h.add(4,7,8,-3,-1,45,70,-2,0);
		 assertEquals(9,  h.size());
		 System.out.println(h);
	
		 
		 
			
		 h = new Heap<Integer>();
		 h.add(1,2,3,4,5,6,7,8);
		 assertEquals(h.toString(),1,  h.extractMin());
		 assertEquals(h.toString(), 2,  h.extractMin());
	
		
	}
	
	@Test 
	public void testAllrounder() {
		
		Allrounder ds = new Allrounder();
			
		ds.insert(5);
			
		assertEquals(5, ds.findMode(), 0);
		
		
		ds.insert(10);
		assertEquals(7.5, ds.findMode(), 0);
		ds.remove();
		assertEquals(5, ds.findMode(), 0);
		
		ds.insert(1);
		assertEquals(3, ds.findMode(), 0);
		
		
		ds.insert(1);
		assertEquals(2.3, ds.findMode(), .1);
		
		ds.insert(4);
		assertEquals(2.75, ds.findMode(), 0);
		
		
		ds.insert(4);
		assertEquals(3, ds.findMode(), 0.1);
		
		
		
		
	}
	
	
	@Test
	public void testLinkedList() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(12);
		list.add(22);
		list.add(32);
		list.add(42);
		list.add(52);
		assertEquals((Integer) 12, list.get(0));
		assertEquals((Integer) 22, list.get(1));
		assertEquals((Integer) 32, list.get(2));
		assertEquals((Integer) 42, list.get(3));
		assertEquals((Integer) 52, list.get(4));
		
		assertEquals((Integer) 12, list.peek());
		assertEquals((Integer) 52, list.peekLast());
		
		list.addFirst(25);
		assertEquals((Integer) 25, list.peek());
		list.addFirst(1);
		assertEquals((Integer) 1, list.peek());
		assertEquals((Integer) 52, list.peekLast());
		list.addLast(444);
		assertEquals((Integer) 444, list.peekLast());
		assertEquals(8, list.size());
	}
	
	@Test
	public void testQueue() throws Exception {
		Queue<Integer> q = new Queue<Integer>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		assertEquals((Integer)1, q.dequeue());
		assertEquals((Integer)2, q.dequeue());
		q.enqueue(5);
		assertEquals((Integer)3, q.dequeue());
		assertEquals((Integer)5, q.dequeue());
		
	}
	
	
	
	@Test
	public void testHashMap() {	
		HashMap<String, String> h = new HashMap<String, String>();
		
		assertFalse(h.containsKey("M"));
		h.put("M", "Malte Appeltauer");
		assertTrue(h.containsKey("M"));
	
		h.put("A", "Malte Appeltauer");
				
		assertEquals(h.get("M"), "Malte Appeltauer");
		h.put("K", "Kalle");
		assertEquals(h.get("M"), "Malte Appeltauer");
		assertEquals(h.get("K"), "Kalle");
		
//		for(String key : h.keys()) {
//			System.out.println(key);
//		}
//		
//		for(String key : h.values()) {
//			System.out.println(value);
//		}
//		
		
	}

	@Test
	public void testArrayList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		assertTrue(list.size() == 0);
		list.add(14);
		assertTrue(list.size() == 1);
		list.add(1);
		assertTrue(list.size() == 2);
		assertTrue(list.get(0) == 14);
		
		for (int i = 0; i < 20; i++) {
			list.add(i);
		}
		assertTrue(list.size() == 22);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");	
//		}
		
		
		
		ArrayList<Integer> other = new ArrayList<Integer>();
		other.addAll(list);
		
		assertTrue(other.get(0) == 14);	
		assertEquals(other.get(other.size()-1), list.get(list.size()-1));	
		assertEquals(22, other.size());
		
		
//		try {
//			ArrayList<Integer> other2 = (ArrayList<Integer>)other.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		assertTrue(other.size() == 22);
		
		
	}

}
