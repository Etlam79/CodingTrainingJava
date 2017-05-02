package listsandarrays;

import datastructures.HashMap;
import datastructures.LinkedList;
import datastructures.helper.Node;

public class DuplicateRemovingList<T> extends LinkedList<T> {

	public void removeDuplicates() {		
		Node<T> n = getFirstNode();
		HashMap<T, Node<T>> map = new HashMap<T, Node<T>>();
		while(n != null && n.hasNext()) {
			map.put(n.getVal(), n);
			
			if(map.containsKey(n.getNext().getVal()) ) {
				n.setNext(n.getNext().getNext());
			}	
			n = n.getNext();					
		}
	}
	
	public void removeDuplicatesNoBuffer() {		
		Node<T> n = getFirstNode();
		
		while(n != null) {
			Node<T> current = n;
			Node<T> next = current.getNext();
			
			while(next != null) {
				
				if(next.getVal().equals(n.getVal())){
					current.setNext(next.getNext());
				}
				current = current.getNext();	
				next = current != null ? current.getNext() : null;
				
			}
			n = n.getNext(); 
		}			
	}
	
	public T findNthToLastElement(int n) {
		Node<T> elem = getFirstNode(); 
		Node<T> current = elem;
		while(n > 0) {
			if (!current.hasNext())
				return null;
			current = current.getNext();
			n--;
		}
		
		while (current.hasNext()) {
			current = current.getNext();
			elem = elem.getNext();
		}
		
		return elem.getVal();
	}
	
	
	public void removeElem(LinkedList<T> list, Node<T> elem) {
		while (elem.hasNext()) {
			elem.setVal(elem.getNext().getVal());
			elem = elem.getNext();
		}
		
	}
}
