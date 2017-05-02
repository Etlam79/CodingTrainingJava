import java.util.Stack;

public class BitsAndBytes {
	
	public static void main(String[] args) {
		BitsAndBytes b = new BitsAndBytes();
		System.out.println(Integer.bitCount(43));
		System.out.println(b.signature(43));
		
		for(int i = 0; i < 30; i ++) {
			System.out.printf("%s: '%s' %s\n", i, b.bytes(i), b.isPalindrome(i) ? "is a palindrome" : "");
		}			
	}
	//(123) 444-3211  
	//(123) 4445-3211
	//(123) 444-321
	//(1235) 444-3211  
	String bytes(int i) {
		return Integer.toBinaryString(i); //// 123 444-3211
	}

	
	// (123) 444-3211
	int signature(int i) {
		int count = 0;
		while (i > 0) {   
			//     xxxxxxxxxxxx
			// AND 000000000001
			// ----------------
			//                X
		    if ((i & 1) == 1)     
		            count++;
	        i >>= 1;              // shift bits, removing lower bit
	    }
		return count;
	}
	
	boolean isPalindrome(int x) {		
		int lengthInBytes = (int) (Math.log(x)/Math.log(2))+1;
		Stack<Integer> s = new Stack<Integer>(); 
		for (int i = 0; i < lengthInBytes/2; i++) {
			  s.push(x & 1); 
			  x >>= 1;
		}
		if (lengthInBytes % 2 == 1)
			x >>= 1;
		
		for (int i = 0; i < lengthInBytes/2; i++) {
			  if (s.pop() != (x & 1))
				  return false;
			  x >>= 1;
		}
		return true;		
	}	
}
