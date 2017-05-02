
public class IntegerFormat {
	
	// If you are given a number as a parameter, write a function 
	// that would put commas after every third digit from the right.
	static String format(int input) {
		String s = "";
		
		while (input >= 1000) {
			int mod = input % 1000;
			
			s += ",";
			if (mod < 100)
				s+= "0";
			if (mod < 10)
				s+= "0";
				
			s +=  mod;
			input = input / 1000;
		}
		
		
		return input + s;
	}
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(format((int)(Math.pow(10, i))));
		}
		

	}

}
