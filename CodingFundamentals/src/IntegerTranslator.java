
public class IntegerTranslator {


	
	String[] ones = {"zero", "one", "two", "three", "four", "five", 
					 "six", "seven", "eight", "nine", "ten", 
					 "eleven", "twelve", "thirteen", "fourteen", "fivteen",
					 "sixteen", "seventeen", "eighteen", "nineteen"};
	
	String[] tens = {" ", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	public String translate(int n) {
		if (n < 20)
			return ones[n];
		if (n < 100)
			return tens[n/10] + " " + translate(n%10);
		if (n < 1000)
			return ones[n/100] + " hundred " + translate(n%100);
		
		if (n < 1000000)
			return translate(n/1000) + " thousand " + translate(n%1000);
		
		return ones[n/1000000] + " milion " + translate(n%1000000);
			
		
	
	
	}
	
	
	
	public static void main(String[] args) {
		IntegerTranslator t = new IntegerTranslator();
		System.out.println(t.translate(5));		
		System.out.println(t.translate(15));
		System.out.println(t.translate(75));
		System.out.println(t.translate(315));
		System.out.println(t.translate(4375));
		System.out.println(t.translate(64375));
		System.out.println(t.translate(654375));
		System.out.println(t.translate(5454375));	
		
	}

}
