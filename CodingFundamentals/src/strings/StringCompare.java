package strings;

public class StringCompare {

	
	public static void main(String[] args) {
		String a = "Malteees";
		String b = "Malteees";
		System.out.println(compare(a,b));
	}
	
	
	static int compare(String a, String b) {
		char[] aTokens = a.toCharArray();
		char[] bTokens = b.toCharArray();
		
		for (int i = 0; i < aTokens.length; i++) {
			if ( bTokens.length <= i ||
				 aTokens[i] > bTokens[i] )
				return 1;
			
			if (aTokens[i] < bTokens[i]) {
				return -1;
			}			
		}
		if (aTokens.length < bTokens.length)
			return -1;
		return 0;
	}
}
