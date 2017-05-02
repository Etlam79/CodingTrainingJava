package tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import listsandarrays.ReverseWords;

import org.junit.Test;

import sorting.HeapSort;

public class SortingTests {


	
	
	
	@Test 
	public void testHeapSort() {		
		int[] test = new int[] {4,7,8,-3,-1,45,70,-2,0};
		HeapSort.sort(test);
		assertArrayEquals(new int[] {-3, -2, -1, 0, 4,7,8,45,70}, test);	
		
		test = new int[] {1,2,3};
		HeapSort.sort(test);
		assertArrayEquals(new int[] {1,2,3}, test);
		
		test = new int[] {3,2,1};
		HeapSort.sort(test);
		assertArrayEquals(new int[] {1,2,3}, test);
		
		test = new int[] {1,2,1};
		HeapSort.sort(test);
		assertArrayEquals(new int[] {1,1,2}, test);
	}
	
//	@Test
//	public void testSpecialSorting() {
//		int[] test = new int[] {-1, 1, 3, -2, 2};
//		
//		new SpecialSort().sort(test);
//		
//		assertArrayEquals(new int[] {-1, -2, 1, 3, 2}, test);
//		
//	}

}
