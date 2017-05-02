package recursion;

public class MagicIndex {
	
	public int findMagicIndex(int[] a) {
		return findMagicIndex(a, 0, a.length);
		
	}

	
	public int findMagicIndex(int[] a, int low, int high) {
		int candidateIndex = high/2+low/2;
		
		if (high== low) 
			return Integer.MIN_VALUE;
		if(a[candidateIndex] == candidateIndex)
			return candidateIndex;
		
		if(a[candidateIndex] < candidateIndex)
			return findMagicIndex(a, candidateIndex+1, high);
		else 
			return findMagicIndex(a, low, candidateIndex);
	}
}
