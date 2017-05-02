package strings;

import java.util.ArrayList;

public class FindSubstring {
	
	// assumptions: there is only one number missing
	public static int findMissingSubstring(String input) { 		
		for (int i = 1; i < input.length(); i++) {
			ArrayList<Integer> list = checkSequence(input, i);
			if (list.size() ==1)
				return list.get(0);
		}		
		return -1;
	}

	private static ArrayList<Integer> checkSequence(String input, int tokenLength) {
		ArrayList<Integer> list = new ArrayList<Integer>();				
		int elem = Integer.parseInt(input.substring(0, tokenLength));
		
		for (int j = tokenLength; j <= input.length()-tokenLength; j+=tokenLength) {
			int current = Integer.parseInt(input.substring(j, j+tokenLength));
			if (elem+1 != current)
				list.add(elem+1);
			elem=current;
		}
		return list;		
	}
}