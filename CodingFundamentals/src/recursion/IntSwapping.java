package recursion;

import java.util.Arrays;
import java.util.HashSet;

import datastructures.ArrayList;
import datastructures.helper.Node;

public class IntSwapping {
 	
	
	HashSet<String> list;

	public int 	find(int... sequence) {	
		
		list = new HashSet<String>();
		
	
		int ret =  find(sequence, 0, 1, list);
		
		for (String i : list) {
			System.out.println(i);		
		}
	
		return ret;
	}
	
	
	private int find(int[] sequence, int left, int right, HashSet<String> list) {
		if (right >= sequence.length || left >= sequence.length)
			return list.size();
		
		String key = Arrays.toString(sequence);
		if (! list.contains(key)) {
			list.add(key);
			
		}
		
		swap(sequence, left, right);
		
		if(right < sequence.length-1)
			return find(sequence, left, right+1, list); 
		else
			return find(sequence, left+1, left+2, list); 
		
			
	}
		
	
	
	private void swap(int[] sequence, int left, int right) {
		int temp = sequence[left];
		sequence[left] = sequence[right];
		sequence[right] = temp;		
	}




	public static void main(String[] args) {
		IntSwapping swap = new IntSwapping();
		System.out.println("3 : " + swap.find(4, 7, 4));
		System.out.println("1: " + swap.find(4, 47));
		
		System.out.println("1 : " + swap.find(9,9,9,9));
		System.out.println("319 : " + swap.find(22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37));
		

		
	}
	
	class Node<T> {
		private T val;
		private HashSet<T> children;
		public Node (T val) {
			this.val = val;
			this.children = new HashSet<T>();
		}
		
		
		
		
	}


}
