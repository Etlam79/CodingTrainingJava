package strings;

import java.util.Arrays;

public class UniqueCharacterCheck {
	
	public static boolean hasUniqueCharacters(String s) {
		byte[] counter = new byte[256];
		char[] c = s.toCharArray();
		
		for (int i = 0; i < c.length; i++) {
			if (counter[c[i]] == 1)
				return false;
			else
				counter[c[i]] = 1;
		}
		return true;		
	}
	
	public static boolean hasUniqueCharactersNoBuffer(String s) {		
		char[] c = s.toCharArray();
		Arrays.sort(c);
		char prev = c[0];
		
		for (int i = 1; i < c.length; i++) {
			if (prev == c[i])
				return false;
			else
				prev = c[i];
		}
		return true;
		
	}
}
