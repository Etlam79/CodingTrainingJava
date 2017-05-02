package listsandarrays;

public class ReverseWords {	
	
	public static void reverse(char[] input) {
		int first = 0;
		int last = input.length-1;
		
		swapAll(input, first, last);		
		first = 0;
		
		while(first < input.length) {			
			last = nextSeperatorIndex(input, first);
			swapAll(input, first, last-1);
			first = last+1;			
		}		
	}

	private static int nextSeperatorIndex(char[] input, int index) {		
		while(index < input.length && input[index] != ' ') {
			index++;
		}
		return index;
	}

	private static void swapAll(char[] input, int first, int last) {
		while (first < last) {
			char temp = input[first];
			input[first] = input[last];
			input[last] = temp;
			first++;
			last--;			
		}		
	}
}