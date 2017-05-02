import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Keypad {

	public static void main(String[] args) {
		System.out.println((Arrays.asList(new Keypad().getOutput("6262"))));
		
	}



	private HashMap<Character, MultiKey> keypad;
	
	Keypad() {
		keypad = new HashMap<Character, Keypad.MultiKey>();
		
		keypad.put('1', MultiKey.EMPTY);
		keypad.put('2', new MultiKey('A', 'B', 'C'));
		keypad.put('3', new MultiKey('D', 'E', 'F'));
		
		keypad.put('4', new MultiKey('G', 'H', 'I'));
		keypad.put('5', new MultiKey('J', 'K', 'L'));
		keypad.put('6',  new MultiKey('M', 'N', 'O'));
	
		keypad.put('7', new MultiKey('P', 'Q', 'R', 'S'));
		keypad.put('8', new MultiKey('T', 'U', 'V'));
		keypad.put('9',  new MultiKey('W', 'X', 'Y', 'Z'));
		keypad.put('0',  MultiKey.EMPTY );
	}
	
	private String[] getOutput(String sequence) {
		return getOutput(sequence, new LinkedList<String>()).toArray(new String[0]);
	}
	
	
	private List<String> getOutput(String sequence, List<String> prefixes) {
		if (sequence.length() == 0)
			return prefixes;
		
		char button = sequence.charAt(0);			
		MultiKey currentKey = keypad.get(button);
		
		LinkedList<String> newPrefixes = new LinkedList<String>();;
		
		if (prefixes.isEmpty()) {
			for (int j = 0; j < currentKey.letters.length; j++) {
				newPrefixes.add(currentKey.letters[j]+"");
			}
		}
		else {
			for (int i = 0; i < prefixes.size(); i++) {
				String currentPrefix = prefixes.get(i);
				
				for (int j = 0; j < currentKey.letters.length; j++) {
					newPrefixes.add(currentPrefix +  currentKey.letters[j]);
				}
			}
		}
		return getOutput(sequence.substring(1), newPrefixes);
		
	
	}
	
	
	
	static class MultiKey {

		public final static MultiKey EMPTY = new MultiKey();
		private char[] letters;

		public MultiKey(char... letters) {
			this.letters = letters;
		}
		
	}
	
}
