package strings;

public class ReverseString {
	
	public static String reverse(String s) {
		char[] c = s.toCharArray();
		
		int first = 0;
		int last = c.length-1;
		
		while (first < last) {		
			char tmp = c[first];
			c[first] = c[last];
			c[last] = tmp;
			first++;
			last--;
		}
		return new String(c);
	}

}
