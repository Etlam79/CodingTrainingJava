package datastructures;

import java.util.Iterator;


public class ArrayList<T> implements Iterable<T>, Cloneable {	
	private Object[] array;
	int size = 0;

	public ArrayList() {
		array = new Object[10];
	}
	
	public int size() {		
		return size;
	}

	public void add(T elem) {		
		if(size == array.length) {
			expand();
		}
		array[size] = elem;		
		size++;
	}

	private void expand() {
		Object[] newArray = new Object[array.length*2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;		
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkForValidIndex(index);
		return (T)array[index];
	}
	
	private void checkForValidIndex(int index) {
		if(index < 0 || index >= size)
			throw new RuntimeException("Illegal array list index: " + index);
	}

	public void setValueAt(int index, T value) {
		if (index == size)
			add(value);
		else {
			checkForValidIndex(index);
			array[index] = value;
		}
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer("[");
		for (int i = 0; i < size; i++) {
			if (i > 0)				
				b.append(", ");
			b.append(array[i]);
		}
		b.append("]");
		return b.toString();
	}

	public Object toArray() {
		Object[] ret = new Object[size];
		System.arraycopy(array, 0, ret, 0, size);
		return ret;
	}
	
	public void addAll(ArrayList<T> other) {
		for (T elem : other) {
			add(elem);
		}
	}

	@Override
	public Iterator<T> iterator() {		
		return new ArrayListIterator(this);
	}
	
	class ArrayListIterator implements Iterator<T> {
		int counter = 0;
		private ArrayList<T> list;
		
		public ArrayListIterator(ArrayList<T> arrayList) {
			this.list = arrayList;
		}

		@Override
		public boolean hasNext() {			
			return counter < list.size();
		}

		@Override
		public T next() {
			return list.get(counter++);
		}
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ArrayList<T> clone = new ArrayList<T>();
		clone.addAll(this);
		return clone;
	}

	public T removeLast() {	
		if (size > 0) {
			T val = get(size-1);
			size--;
			return val;
		}
		return null;
	}

	public boolean isEmpty() {		
		return size==0;
	}
	

}
