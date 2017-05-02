package datastructures;

import datastructures.helper.Node;

public class Queue<T> {

	Node<T> first;
	Node<T> last;
	private double size;
	
	public Queue () {
	}
	
	public void enqueue(T elem) {
		if(first == null) {
			first = new Node<T>(elem);
			last = first;
		}
		else {
			Node<T> n = new Node<T>(elem);
			last.setNext(n);
			last = n;
		}
		size++;
		
	}
	
	public T dequeue() {
		if (first == null)
			return null;
		Node<T> ret = first;
		first = first.getNext();
		size--;
		return ret.getVal();
	}

	public double size() {
		return size;
	}
}
