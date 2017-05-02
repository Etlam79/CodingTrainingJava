package listsandarrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import datastructures.Heap;

public class Restructure {
	
	public static void main(String[] args) {
		String s = "AMAMAALLsöklgöklsdfhewfhwöefhAM";
		System.out.println(restructure(s.toCharArray()));
	}
	
	private static char[] restructure(char[] input) {
		Hashtable<Character, Integer> ht = fillHashTable(input);		
		ArrayList<Map.Entry<Character, Integer>> set = getSortedSetOfLetters(ht);
		
		if(hasNoSolution(set, input)) {
			System.err.println("cannot find solution");
			return input;
		}
			
		char[] result = new char[input.length];
		int slot = 0;
		
		for (int i = 0; i < result.length; i++) {			
			Entry<Character, Integer> entry = set.get(slot);
			result[i] = entry.getKey();
			
			if(entry.getValue() == 1)
				set.remove(slot);
			else
				entry.setValue(entry.getValue()-1);
			
			
			if (slot > 0)
				slot = 0;
			else if (set.size()>1)
				slot = 1;
				
		}		
		return result;
	}

	private static boolean hasNoSolution(ArrayList<Entry<Character, Integer>> set, char[] input) {
		return set.get(0).getValue() >= input.length/2+1;

	}

	private static ArrayList<Entry<Character, Integer>> getSortedSetOfLetters(Hashtable<Character, Integer> ht) {
		ArrayList<Map.Entry<Character, Integer>> set = new ArrayList<Map.Entry<Character, Integer>>(ht.entrySet());
		Collections.sort(set, new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {				
				if (o1.getValue() == o2.getValue()) return 0;
				if (o1.getValue() < o2.getValue()) return 1;
				else return -1;
			}
		});
		return set;
	}

	private static Hashtable<Character, Integer> fillHashTable(char[] s) {
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();	   
		
		for (int i = 0; i < s.length; i++) {
			if (!ht.containsKey(s[i]))
				ht.put(s[i], 1);
			else
				ht.put(s[i], ht.get(s[i])+1);
		}
		return ht;		
	}
	

	

}
