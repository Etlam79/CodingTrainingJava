package recursion;

import datastructures.ArrayList;

public class StringPermutations {
	
	public String[] permutationsOf(String s) {
		
//		b.rechar[] c = s.toCharArray();
		ArrayList<String> strings = new ArrayList<String>();
		
		permute(s,"", strings);

		String[] ret = new String[strings.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = strings.get(i);
		}
		return ret;
	}

	private ArrayList<String> permute(String s, String permutation, ArrayList<String> permutations) {
	
		if(s.length() == 0) {
			permutations.add(permutation);
			return permutations;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
//			int size = strings.length();
//			for (int j = 0; j < size; j++) { 
//				String current = strings.get(j);				
//				strings.setValueAt(j, current+c);
//			}
			
			
			permute(s.replaceAll(c+"",""), permutation+c, permutations);
		}
		return permutations;
		
			
		
	}

}
