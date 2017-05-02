package stacksandqueues;

public class MultipleStackArray<T> {
	
	private Object[] array;
	private int numberOfStacks;
	private int[] pointers;
	int bufferMax;
	
	public <T> MultipleStackArray (int size, int numberOfStacks) {
		this.array = new Object[size];
		this.numberOfStacks = numberOfStacks;
		this.pointers = initPointers(numberOfStacks, size);
		this.bufferMax = size/numberOfStacks;
	}
	


	public void push(T val, int id) {
		if (hasMoreSpace(id)) {			
			array[pointers[id]] = val;
			pointers[id]++;
		}
	}
	
	private boolean hasMoreSpace(int array) {
		return pointers[array] < (array+1) * bufferMax; 
	}



	public T pop(int id) {
		if(pointers[id]-1 < 0)
			return null;
		
		T val = (T)array[pointers[id]-1];
		pointers[id]--;
		return val;
	}
	
	public T peek(int id) {
		if(pointers[id]-1 < 0)
			return null;
		return (T)array[pointers[id]-1];
	}

	private int[] initPointers(int numberOfStacks, int size) {
		int[] pointer = new int[numberOfStacks];
		for (int i = 0; i < numberOfStacks; i++) {
			pointer[i] = i * (size/numberOfStacks);
		}
		return pointer;
	}
}
