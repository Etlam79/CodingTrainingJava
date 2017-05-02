package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stacksandqueues.MultipleStackArray;
import stacksandqueues.animalshelter.AnimalShelter;
import stacksandqueues.animalshelter.Cat;
import stacksandqueues.animalshelter.Dog;
import stacksandqueues.hanoi.HanoiTower;
import stacksandqueues.hanoi.TowersOfHanoi;
import datastructures.Stack;

public class StacksAndQueuesTest {


	
	@Test
	public void testAnimalShelter() {
		AnimalShelter s = new AnimalShelter();
		Cat lucy = new Cat("Lucy");
		Dog ben = new Dog("Ben");
		Dog harry = new Dog("Harry");
		Cat sisi = new Cat("sisi");
		Dog buff = new Dog("Buff");
		s.enqueue(lucy);
		s.enqueue(ben);
		s.enqueue(harry);
		s.enqueue(sisi);
		s.enqueue(buff);
		
		
		assertEquals(s.dequeueDog(), ben);
		assertEquals(s.dequeueAny(), lucy);
		
	}
	
	
	@Test
	public void testHanoi() {
		TowersOfHanoi t = new TowersOfHanoi(new HanoiTower(4));
		t.run();
		
	}
	
	@Test
	public void testStackMin() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		assertEquals((Integer) 5, s.min());
		s.push(6);
		assertEquals((Integer) 5, s.min());
		s.push(3);
		assertEquals((Integer) 3, s.min());
		s.push(7);
		assertEquals((Integer) 3, s.min());
		s.pop();
		assertEquals((Integer) 3, s.min());
		s.pop();
		assertEquals((Integer) 5, s.min());
	}
		
	@Test
	public void testMultipleStackArray() {
		MultipleStackArray<Integer> m = new MultipleStackArray<Integer>(30, 3);
		
		m.push(0, 0);
		m.push(20, 1);
		m.push(40, 2);
		
		assertEquals((Integer)0, m.peek(0));
		assertEquals((Integer)(20), m.peek(1));
		assertEquals((Integer)40, m.peek(2));
		
		
		for (int i = 0; i < 15; i++) {
			m.push(i+1, 0);	
			m.push(20+i+1, 1);
			m.push(40+i+1, 2);
		}
		assertEquals((Integer)9, m.peek(0));
		assertEquals((Integer)29, m.peek(1));
		assertEquals((Integer)49, m.peek(2));
		
		for (int i = 9; i <=0 ; i--) {
			assertEquals((Integer)i, m.pop(0));
			assertEquals((Integer)(i+20), m.pop(1));
			assertEquals((Integer)(i+40), m.pop(2));
		}	
	}
	
	

}
