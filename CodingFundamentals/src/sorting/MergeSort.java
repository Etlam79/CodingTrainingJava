package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort  {
	private int[] array;
	public static void main(String[] args) {
		int[] test = {5,4,66,7,24,3,0,2,44,33,1};
		
		new MergeSort().mergesort(test);
				
	}
	
	public void mergesort (int[] array) {
		this.array = array;
		this.steps = new ArrayList<SortStep>();
			
		mergesort(array, 0, array.length-1, new int[array.length], 0);
	
		
	}

	private void mergesort(int[] array, int low, int high, int[] helper, int depth) {
		
		
		if (low < high) {
			fireValueChangedEvent(array, low, high, depth);
			int middle = (high+low)/2;
			mergesort(array, low, middle, helper, depth+1);
			mergesort(array, middle+1, high, helper, depth+1);
			merge(array, low, middle, high, helper);	
			fireValueChangedEvent(array, low, high, depth+1);
			
		}		
	}

	private void merge(int[] array, int low, int middle, int high, int[] helper) {
		for (int j = low; j <= high;  j++) {
			helper[j] = array[j];
		}
		int left = low;
		int right = middle+1;
		int current = low;
		
		while (left <= middle && right <= high) {
			if( helper[left] <= helper[right]) {
				array[current] = helper[left];
				left++;
			}
			else {
				array[current] = helper[right];
				right++;
			}
			current++;
		}		
		int remaining = middle-left;
		for (int i = 0; i <= remaining; i++) {
			array[current+i] = helper[left+i];
		}	
	}
	
	List<SortStep> steps ;
	protected void fireValueChangedEvent(int[] array2, int low, int high, int depth) {
		StringBuffer b = new StringBuffer();
		for (int i = low; i < high; i++) {
			b.append(array2[i]+" ");
		}
		
		steps.add(new SortStep(b.toString(), depth) );
	}

	
	public List<SortStep> getSteps() {
		
		return steps;
	}
	
	public class SortStep {
		public SortStep(String string, int depth) {
			this.array = string;
			this.step = depth;
		}
		public String array;
		public int step;
		
	}

	
}
