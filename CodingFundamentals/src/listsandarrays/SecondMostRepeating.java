package listsandarrays;
import java.util.Arrays;


public class SecondMostRepeating {
	
	public static void main(String[] args) {
		System.out.println(
			new SecondMostRepeating().find(new int[]{1,1, 1, 2, 2,2,2,3,3})
			);
	}
	
	
	int find(int[] arr) {
		int most = arr[0];
		int secondmost = arr[0];
		
		Arrays.sort(arr);

		int max = 0;
		int secondmax = 0;
	
		
		for (int i = 0; i < arr.length; i++) {
			int repeats = countRepeatsOf(arr, i);
			
			if (repeats > max) {
				secondmax = max;
				secondmost = most;
				max = repeats;
				most = arr[i];
			
			}
			
			else if (repeats > secondmax) {
				secondmax = repeats;		
				secondmost = arr[i];
			}
			
			i += repeats-1;
		
		}
	
		return secondmost;
	}


	private int countRepeatsOf(int[] arr, int index) {
		int count = 1;
		
		for (int i = index+1; i < arr.length; i++) {
			if (arr[i-1]== arr[i])
				count++;
			else 
				break;
		}
		return count;
	}

}


