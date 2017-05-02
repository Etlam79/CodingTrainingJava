package datastructures;

import datastructures.helper.Node;

public class ListElementAdder  {
	
	public LinkedList<Integer> addBackwards(LinkedList<Integer> lhsList, LinkedList<Integer> rhsList) {
		LinkedList<Integer> sumList = new LinkedList<Integer>();
		
		Node<Integer> lhs = lhsList.getFirstNode();
		Node<Integer> rhs = rhsList.getFirstNode();
		int carry = 0;
		
		
		while(lhs != null || rhs != null || carry > 0) {
			int sum = carry;	
			if (lhs != null) {
				sum += lhs.getVal();
				lhs = lhs.getNext();
			}
			if (rhs != null) {
				sum += rhs.getVal();
				rhs = rhs.getNext();
			}
				
			sumList.add(sum % 10);			
			carry = Math.max(0, sum/10);
		}
		return sumList;
	}

	public LinkedList<Integer> addForewards(LinkedList<Integer> lhs, LinkedList<Integer> rhs) {
		addZeroTo(lhs, 1);
		addZeroTo(rhs, 1);
		
		if (lhs.size() > rhs.size() )
			addZeroTo(rhs, lhs.size() -rhs.size());
		else
			addZeroTo(rhs, rhs.size() -lhs.size());
		
		return new LinkedList<Integer>(addForewards(lhs.getFirstNode(), rhs.getFirstNode()));
	}

	private void addZeroTo(LinkedList<Integer> l, int i) {
		Node<Integer> zero = new Node<Integer>(0);
		zero.setNext(l.getFirstNode());
		l = new LinkedList<Integer>(zero);
	}

	private Node<Integer> addForewards(Node<Integer> lhs, Node<Integer> rhs) {		
		Node<Integer> next = null;
		int carry = 0;
		
		if (lhs.hasNext() && rhs.hasNext()) {
			next = addForewards(lhs.getNext(), rhs.getNext());
			int valOfNext = next.getVal();
			if(valOfNext > 10) {
				next.setVal(valOfNext % 10);
				carry = valOfNext / 10;
			}
		}
		Node<Integer> current = new Node<Integer>(carry + lhs.getVal() + rhs.getVal());
		current.setNext(next);
		return current;			
	}
}