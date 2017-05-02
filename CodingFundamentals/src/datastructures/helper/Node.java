package datastructures.helper;

public class Node<T> {	
		private Node<T> next;
		private T val;
		
		public Node(T val) {
			this.val = val;
			
		}
		
		public Node(T val, Node<T> prev) {
			this(val);
			prev.setNext(this);
		}
		
		public Node<T> getNext() {
			return next;
		}
		
		public void setNext(Node<T> n) {
			next = n;
		}
		public T getVal() {
			return val;
		}
		
		public void setVal(T val) {
			this.val = val;
		}
		
		@Override
		public String toString() {
			return val.toString();
		}

		public boolean hasNext() {			
			return getNext() != null;
		}
		
	}
