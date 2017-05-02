package recursion;

import datastructures.ArrayList;

public class Fibonacci {
	private ArrayList<Long> cache;

	public Fibonacci() {
		this.cache = new ArrayList<Long>();
		this.cache.add(0L);
		this.cache.add(1L);
	}
	
	public long fibDyn(int n) {
		
		if (cache.size() > n)
			return cache.get(n);
		else {
			long newFib = fibDyn(n-2) + fibDyn(n-1);
			cache.add(newFib);
			//System.err.println("Fibonacci dynamic "+ cache);
			return newFib;			
		}
	}

	public static long fibIter(long n) {
		if (n < 1) throw new IllegalArgumentException();
		if (n == 1) return 1;
		if (n == 2) return 1;
		
		long secondlast = 1;
		long last = 1;
		long fib = 1;
		
		for (int i = 3; i <= n; i++) {
			fib = last + secondlast;
			secondlast = last;
			last = fib;
			
			
		}
		return fib;
		
	}

	public static long fib(long n) {
		if (n < 1) throw new IllegalArgumentException();
		if (n == 1) return 1;
		if (n == 2) return 1;
		
		return fib(n-1) + fib(n-2);		
	}
	
}
