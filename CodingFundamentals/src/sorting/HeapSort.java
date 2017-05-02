package sorting;

import datastructures.Heap;

public class HeapSort {

	
	public static void sort(int[] a) {
		Heap<Integer> h = new Heap<Integer>();
		for (int i : a) {
			h.add(i);
				
		}
		
//		h.add(1,2,3,4,5,6,7,8);
		System.out.println(h);
		for (int i = 0; i < a.length; i++) {
			a[i] = h.extractMin();
			
		}
		
	}
}
