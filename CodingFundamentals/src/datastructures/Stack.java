package datastructures;

import datastructures.helper.Node;

public class Stack<T extends Comparable<T>> {
	public ValueAndMinimum head;
	private int size;
	

	
	public boolean push(T elem) {
			
		T min;
		if (head == null || head.min.compareTo(elem) > 0)
			min = elem;
		else {
			min = head.min;
		}
		ValueAndMinimum newElem = new ValueAndMinimum(elem, min);
		newElem.setNext(head);
		head = newElem;	
		size++;
		return true;
	
	}
	
	public T pop() {
		if (isEmpty()) 
			return null;
		T val = head.getVal();
		head = (ValueAndMinimum)head.getNext();
		size--;
		return val;
	}
	
	public int getSize() {
		return size;
	}
	
	public T peek() {
		return head.getVal();
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public T min() {
		return head.min;
	}
	
	class ValueAndMinimum extends Node<T>{		
		private T min;

		public ValueAndMinimum(T val, T min) {
			super(val);			
			this.min = min;
		}
	}

	
	@Override
	public String toString() {
		Node<T> current = head;
		StringBuffer b = new StringBuffer();
		while(current!= null) {
			b.append(current.getVal() + "->");
			current = current.getNext();
		}
		return b.toString();
	}
}
