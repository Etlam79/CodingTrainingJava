package tests;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import systemdesign.pagevisitanalysis.PageVisitAnalysis;

public class SystemDesignTest {

	@Test
	public void testPageVisitAnalysis() {		
//		Random r = new Random();
//		List<String> list = new ArrayList<String>();
//		for (int i = 0; i < 100000; i++) {
//			boolean[] pages = new boolean[14];
//			int visited = 0;
//			StringBuffer trace = new StringBuffer();
//			
//			while (visited < pages.length) {
//				int rand = r.nextInt(14);
//				if(!pages[rand]) {
//					visited++;
//					trace.append(rand+","); 
//					pages[rand]=true;
//				}
//			}
//			list.add(trace.toString());
//		}
		
		List<String> test = Arrays.asList(
			"1,2,3,4,5,6,7,8,9,10",
			"1,2,3,4,5,7,8,9,10, 9",
			"1,3,1, 4,5,7,8,9,10,9"
		);
		
		System.out.println   (Math.pow(3, 3) + " - "  + 
								factorial(3) / factorial(3-3) ) 
				             ;
		PageVisitAnalysis pv = new PageVisitAnalysis();
		String result = pv.findMostPopularSequence(test, 3);
		System.out.println(">" + result);
	}
	
	  
	private static long[] cache = new long[20];
	public static long factorial(int n) {
		if (n == 0) return 1;
		if (n == 1) return 1;
		
		if (cache[n] == 0) {
			cache[n] = factorial(n-1) * n;		     
		}
    	return cache[n];
    }

}
