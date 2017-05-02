package recursion;

import datastructures.ArrayList;

public class StaircaseHops {
	private ArrayList<Integer> cache;
		
	public int hop(int n) {
		if (n < 1)
			return 0;
		
		System.out.println("For " + n + " Stairs ----------");
		int hop = hop(n, "");
		System.out.println("\n\n");
		return hop;
	}

	private int hop(int n, String path) {
		if (n < 0)
			return 0;				
		if ( n == 0) {			
			System.out.println(path);
			return 1;
		}		
		else {
			return hop(n-1, path + " 1") + 
				   hop(n-2, path + " 2") +
				   hop(n-3, path + " 3");
		}
	}
	
	
	
	
	public int hopDyn(int n) {		
		if (n < 1)
			return 0;
		
		cache = new ArrayList<Integer>();
		return hopDynRek(n);		
	}

	private int hopDynRek(int n) {
		if (n < 0)
			return 0;
		if (n == 0) 
			return 1;
				
		if (cache.size() >= n)
			return cache.get(n-1);
		else {
			int hops = 
				hopDynRek(n-1) + 
				hopDynRek(n-2) +
				hopDynRek(n-3);
			cache.add(hops);
			return hops;
		}
	}	
}