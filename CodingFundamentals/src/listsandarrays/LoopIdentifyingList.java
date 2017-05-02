package listsandarrays;

import datastructures.LinkedList;
import datastructures.helper.Node;

public class LoopIdentifyingList<T> extends LinkedList<T>{

	public LoopIdentifyingList(Node<T> a) {
		super(a);
	}

	public Node<T> findLoop() {
		Node<T> slow = getFirstNode();
		if (slow == null)
			return null;
		Node<T> fast = slow.getNext();
		System.out.printf("slow at %s fast at %s\n", slow, fast);
		while(fast != slow && fast != null) {			
			slow = slow.getNext();
			if (fast.hasNext())
				fast = fast.getNext().getNext();
			System.out.printf("slow at %s fast at %s\n", slow, fast);
		}
		System.out.printf("slow at %s fast at %s\n", slow, fast);
		return fast;
	}

	
	//A B C D E C
	  
	
}
