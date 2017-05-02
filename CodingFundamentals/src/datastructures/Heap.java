package datastructures;

import datastructures.helper.KeyValuePair;

public class Heap<T> {	
	private ArrayList<Elem> buffer = new ArrayList<Elem>();

	public Heap() {
		// for easy index calcuation
		buffer.add(null);
	}

	public void add(int... prio) {
		for (int i : prio) 
			add(null, i);			
	}
	
	public void add(T elem, int prio) {
		buffer.add(new Elem(prio, elem));
		bubbleUp(buffer.size-1);		
	}
	
	
	
	public int peekMin() {
		return buffer.isEmpty() ? -1:  buffer.get(1).getKey(); 
	}
	
	public int extractMin() {		
		return removeAt(1);	 
	}
	
	private int removeAt(int index) {		
		if (index >= 0 && index < buffer.size) { 
			int ret = buffer.get(index).getKey();
			buffer.setValueAt(index, buffer.removeLast());
			bubbleDown(index);
			return ret;
		}
		return Integer.MAX_VALUE;
	}

	private void bubbleUp(int index) {
		if (index <= 1) 
			return;
					
		Elem e = buffer.get(index);
		Elem parent = buffer.get(index/2);
		if (e.getKey() < parent.getKey()) { 
			swap(index, index/2);
			bubbleUp(index/2);
		}				
	}	

	private void bubbleDown(int index) {
		if (index >= buffer.size)
			return;
			
		int i = getIndexOfChildToBubbleWith(index);			
		if (i > 0) {
			if(buffer.get(index).getKey() > buffer.get(i).getKey()) {
				swap(index, i);
				bubbleDown(i);
			}
		}		
	}

	private int getIndexOfChildToBubbleWith(int index) {		
		int rindex = getIndex(index*2+1);
		int lindex = getIndex(index*2);
		
		if (rindex > 0) {
			if (lindex > 0) {
				if(buffer.get(rindex).getKey() > buffer.get(lindex).getKey())
					return lindex;
			}
			return rindex;
		}			
		return lindex;				
	}	
	

	private int getIndex(int index) {		
		return index < buffer.size ? index : -1;
	}



	private void swap(int index, int index2) {
		Elem temp = buffer.get(index);
		buffer.setValueAt(index, buffer.get(index2));
		buffer.setValueAt(index2, temp);		
	}
	
	
	@Override
	public String toString() {	
		StringBuffer s = new StringBuffer();
		s.append(buffer.toString()+ "\n");
		visit(s, 1, 0);		
		return s.toString();
	}	

	private void visit(StringBuffer s, int index, int depth) {	
		if (index < buffer.size) {							
			for (int j = 0; j < depth; j++) 
				s.append("  ");			
			s.append(buffer.get(index) + "\n");
			visit(s, index*2, depth+1);
			visit(s, index*2+1, depth+1);
		}
	}

	class Elem extends KeyValuePair<Integer, T> {
		public Elem(Integer key, T value) {
			super(key, value);			
		}	
	}

	public int size() {
		return buffer.size()-1;
	}
}