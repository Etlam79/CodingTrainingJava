package listsandarrays;
import java.util.Arrays;


public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 40, 50};
	    int b[] = {4, 13, 17, 300, 450};
		
	    
	    int median = median(a, 0, a.length, b, 0, b.length);
//	    int median = median2(a, b);
	    System.out.println(median);
	  
	}
	
	

	private static int median(int[] a, int firstA, int lastA, int[] b, int firstB, int lastB) {
	
		int lengthOfA = lastA-firstA;
		int lengthOfB = lastB-firstB;
		int midPointA = firstA+(lengthOfA)/2;
		int midPointB = firstB+(lengthOfB)/2;
		
		int medianOfA = a[midPointA];		
		int medianOfB = b[midPointB];
		
	
		if (lengthOfA == 1 && lengthOfB == 1)
			return Math.max(a[firstA], b[firstB]) + Math.min(a[lastA], b[lastB])/2;
		
	
		if (medianOfA < medianOfB) {	
			firstA = midPointA+1;
			lastB = midPointB;									
		}
		if (medianOfA > medianOfB) {		
			lastA = midPointA;			
			firstB = midPointB;						
		}		
		return median(a, firstA, lastA, b, firstB, lastB);
	}

}
