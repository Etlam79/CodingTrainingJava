package recursion;
import java.util.HashMap;
import java.util.HashSet;




public class LittleElephant {

	

	public int getNumber(String s) {
		cache = new HashSet<String>();
		max = s.length()+1;
		counter = 0;
		return getNumber(s, 0);
	}

	int counter;
	int max;
	private int getNumber(String s, int i) {
		if (s.length() == 0 || i >= max || cache.contains(s))
			return -1;
		
		if (containsOnlyOneColor(s)) {			
			max = Math.min(max, i);
		
			return i;
		}
		counter++;
		cache.add(s);		
		int front = getNumber(s.substring(1), i+1);
		int back =   getNumber(s.substring(0, s.length()-1), i+1);
		
		if (front < 0)
			return back;
		if (back < 0)
			return front;
		return Math.min(back, front);
	}
	


	
	private HashSet<String> cache; 
	private boolean containsOnlyOneColor(String s) {
		
		char c = s.charAt(0);
		
		for (int i = 1; i < s.length(); i++) {
			if (c != s.charAt(i)) {
				
				return false;
			}			
		}
		
		return true;
	}
	public static void main(String[] args) {
		LittleElephant l = new LittleElephant();
		
				    	
		System.out.printf("should be 4, was %s\n", l.getNumber("RRGGBB"));
		System.out.printf("should be 0, was %s\n", l.getNumber("R"));
		System.out.printf("should be 5, was %s\n", l.getNumber("RGBRGB"));
		System.out.printf("should be 3, was %s\n", l.getNumber("RGGGBB"));
		System.out.printf("should be 46, was 5, %s  steps\n", 
				l.getNumber("RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR"), l.counter);
		
		
//		s = "R";
//		ret =  0;
//		  	
//		s = "RGBRGB";
//		ret = 5;
//		
//		    	
//		s = "RGGGBB";
//		ret =  3;
//		
//		s = "RGBRBRGRGRBBBGRBRBRGBGBBBGRGBBBBRGBGRRGGRRRGRBBBBR";
//		ret = 46
	}
}
