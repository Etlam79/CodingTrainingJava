package strings;

public class StringCompression {
	
	public static String compress(String input) {
		if (input.length() < 3)
			return input;
		
		
		
		int prev = 0;
		int index = 1;
		int length = 0;
		
		
		StringBuffer b = new StringBuffer();
		while (index < input.length()) {
			if (input.charAt(index) != input.charAt(prev)) {				
				b.append(input.charAt(prev)).append(index-prev);
				length+=2;
				if (length >= input.length())
					return input;
				prev = index;
				
			}
			index ++;
		}
		b.append(input.charAt(prev)).append(index-prev);
		if (length+2 >= input.length())
			return input;
		return b.toString();
	}

}
