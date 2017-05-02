import static org.junit.Assert.assertArrayEquals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PrimeTask {

	/*
	 * Please implement this method to return a list of all prime numbers in the given range (inclusively). A prime number is a
	 * natural number that has exactly two distinct natural number divisors, which are 1 and the prime number itself. The first
	 * prime numbers are: 2, 3, 5, 7, 11, 13
	 */
	public static List<Integer> getPrimeNumbers(int from, int to) {
	
		if (from < 2) {from = 2;}
		
		int[] sieve = new int[to+1];
	
		for (int i=0; i <= to; ++i)
		{
			sieve[i] = i;
		}	
		
		
			
		for (int i=2; i < to/2; ++i)
		{
			
			
			for (int j= 2*i; j <= to; j += i)
			{
				sieve[j] = 0;
			}
	
			
		}		
			
		
		List<Integer> result = new ArrayList();
		
		for (int i=2; i< sieve.length; ++i)
		{
			
			if ( sieve[i] != 0 && i >= from)
				result.add(sieve[i]);
			
		}
		
		System.out.println(result);
		
		return result;
		
	}
	
	
	/* ------- DON'T CHANGE ANYTHING BELOW HERE ------ */

	@Test
	public void test1to7() {
		assertArrayEquals(new Integer[] { 2, 3, 5, 7 }, getPrimeNumbers(1, 7).toArray(new Integer[0]));
	}

	@Test
	public void testMinus1to7() {
		assertArrayEquals(new Integer[] { 2, 3, 5, 7 }, getPrimeNumbers(-1, 7).toArray(new Integer[0]));
	}

	@Test
	public void test2to7() {
		assertArrayEquals(new Integer[] { 2, 3, 5, 7 }, getPrimeNumbers(2, 7).toArray(new Integer[0]));
	}

	@Test
	public void test6to10() {
		assertArrayEquals(new Integer[] { 7 }, getPrimeNumbers(6, 10).toArray(new Integer[0]));
	}

	@Test
	public void test50to68() {
		assertArrayEquals(new Integer[] { 53, 59, 61, 67 }, getPrimeNumbers(50, 68).toArray(new Integer[0]));
	}
}
