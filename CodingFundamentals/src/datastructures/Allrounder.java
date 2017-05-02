package datastructures;


public class Allrounder {	
	private Queue<Integer> q = new Queue<Integer>();
	private Stack<Integer> mode = new Stack<Integer>();
	private HashMap<Integer, Integer> ocurrences = new HashMap<Integer, Integer>();
	
	
	
	
	public void insert(int elem) {
		q.enqueue(elem);
		
		if (!ocurrences.containsKey(elem)) 
			ocurrences.put(elem, 1);		
		else
			ocurrences.put(elem, ocurrences.get(elem)+1);		
		
		int currentMode = mode.isEmpty()? 0 : mode.peek();
		mode.push(currentMode+elem);		
	}	
	
	public int remove() {
		int elem = q.dequeue();
			mode.pop();		
		return elem;
	}	
	
	public double findMode() {
		return mode.peek()/(double)mode.getSize();
	}	
}
