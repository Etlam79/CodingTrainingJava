package recursion;

import datastructures.ArrayList;

public class Parenthesis {

	public ArrayList<String> parenthesis(int n) {
		return parenthesis(n, 0, new ArrayList<String>());
	}

	private ArrayList<String> parenthesis(int open, int close, ArrayList<String> list ) {
		if(open == 0 && close == 0) {
			return list;			
		}
		
		ArrayList<String> ret = new ArrayList<String>();
		if (open > 0)
			ret.addAll(parenthesis(open-1, close+1, add(list,"(")));
		if (close > 0)
			ret.addAll(parenthesis(open, close-1, add(list,")")));
		
		return ret;
	}

	private ArrayList<String> add(ArrayList<String> list, String elem) {
		ArrayList<String> clone = new ArrayList<String>();
		
		if (list.isEmpty())
			clone.add(elem);
		
		for (String str : list) {
			clone.add(str+elem );
		}
		
	
		
		return clone;
	}
}
