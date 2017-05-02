package listsandarrays;

import datastructures.LinkedList;
import datastructures.helper.Node;

public class ListPartitioning<T extends Comparable<T>> extends LinkedList<T> {

	public void paritioning(T value) {
		LinkedList<T> smaller = new LinkedList<T>();
		LinkedList<T> larger = new LinkedList<T>();		
		Node<T> current = getFirstNode();
		while(current != null) {
			if (current.getVal().compareTo(value) < 0 ) {
				smaller.add(current.getVal());
			}
			if (current.getVal().compareTo(value) >= 0) {
				larger.add(current.getVal());
			}			
			current = current.getNext();
		}
		
		smaller.addAll(larger);
	    
		removeAll();
		addAll(smaller);		
	}	
}