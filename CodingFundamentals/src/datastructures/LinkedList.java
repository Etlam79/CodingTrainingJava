package datastructures;

import java.util.Iterator;


import datastructures.helper.Node;




public class LinkedList<T> implements Iterable<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public  LinkedList() {
		size = 0;
	}
	
	public LinkedList(Node<T> head) {
		this.first = head;
		this.size = 1;
		
		Node<T> current = head;
		while (current.hasNext()) {
			this.size++;
			this.last = current;
			current = current.getNext();
		}		
	}

	public void add(T elem) {
		if (first == null) {
			first = new Node<T>(elem);
			last = first;
		}
		else {
			last = new Node<T>(elem, last);
		}
		size++;			
	}

	public T poll() {
		Node<T> ret = first;
		
		if (first != null)
			first = first.getNext();
	
		size--;
		return ret != null ? ret.getVal() : null;
	}
	
	
	public T pollLast() {
		if(first == last)
			return poll();
		
		Node<T> current = first;
		while (current.hasNext() && current.getNext() != last) {
			current = current.getNext();
		}
		current.setNext(null);
		Node<T> ret = last;
		last = current;		
		size--;
		return ret.getVal();
	}
	
	
	
	
	public T get(int index) {		
		Node<T> n = getNode(index);
		return n.getVal();		
	}
	
	public void set(int index, T val) {
		Node<T> n = getNode(index);
		n.setVal(val);
	}
	


	public void addFirst(T elem) {
		first = new Node<T>(elem, first);	
		size++;
	}
	
	public void addLast(T elem) {
		add(elem);
	}

	protected Node<T> getLastNode() {
		return last;
	}

	protected Node<T> getFirstNode() {
		return first;
	}

	public int size() {
		return size;
	}

	@Override 
	public String toString() {
		Node<T> current = first;
		StringBuffer b = new StringBuffer("[");
		while(current != null) {		
			if (current != first)
				b.append(", ");
			b.append(current);
			current = current.getNext();
		}
		return b.append("]").toString();
	}
	
	public void remove(Node<T> elem) {
		while (elem.hasNext()) {
			elem.setVal(elem.getNext().getVal());
			elem = elem.getNext();
		}		
	}	
	
	public void reverse() {				
		int first = 0;
		int last = size()-1;
				
		while (first < last) {		
			T temp = get(first);
			set(first, get(last));
			set(last, temp);
			first++;
			last--;
		}	
	}	

	public void addAll(LinkedList<T> other) {
		if (isEmpty()) {
			first = other.getFirstNode();			
		}
		else {
			last.setNext(other.getFirstNode());		
		}
		last = other.getLastNode();
		size = size + other.size;
	}
	
	public void removeAll() {
		first = null;
		last = null;
		size = 0;		
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T peek() {
		return first.getVal();
	}

	public T peekLast() {
		return last.getVal();
	}

	@Override
	public Iterator<T> iterator() {		
		return new LinkedListIterator(this);
	}
	
	
	private Node<T> getNode(int index) {
		if (index > size)
			throw new RuntimeException();
		
		Node<T> n = first;
		for (int i = 0; i < Math.min(index, size); i++) 
			n = n.getNext();
		return n;
	}
	
	class LinkedListIterator implements Iterator<T> {
		Node<T> current;		
		
		public LinkedListIterator(LinkedList<T> list) {
			this.current = list.getFirstNode();
		}

		@Override
		public boolean hasNext() {			
			return current != null;
		}

		@Override
		public T next() {
			Node<T> ret = current;
			current = current.getNext();
			return ret.getVal();
		}
		
		
		
	}

	
	
}
