package recursion;

import datastructures.ArrayList;

public class PowerSet<T> {
	
	public ArrayList<ArrayList<T>> powerSet(ArrayList<T> set) {
		ArrayList<ArrayList<T>> powerSet = new ArrayList<ArrayList<T>>();
		powerSet.add(new ArrayList<T>());
		
		try {
			return buildPowerSet(set, powerSet);
		} catch (CloneNotSupportedException e) {			
			e.printStackTrace();
		}
		return null;
	
		
	}

	private ArrayList<ArrayList<T>> buildPowerSet(ArrayList<T> set, ArrayList<ArrayList<T>> powerSet) throws CloneNotSupportedException {
		if(set.isEmpty())
			return powerSet;
		T toBeAdded = set.removeLast();
		int size = powerSet.size();
		for (int i = 0; i < size; i++) {
			@SuppressWarnings("unchecked")
			ArrayList<T> newSubset = (ArrayList<T>)powerSet.get(i).clone();
			newSubset.add(toBeAdded);
			powerSet.add(newSubset);
		}
		return buildPowerSet(set, powerSet);
	}

}
