package recursion;

public class Exponental {
	
	private int counter;
	private int counterRek;
	private int counterBit;
	
	


	public float exp (int x, int y) {		
		if (y == 0)
			return 1;
		
		double exp = 1;
		for (int i = 0; i < Math.abs(y); i++) 
			exp =  exp *x;		
		
		if (y < 0)
			exp = 1/exp;
		if (exp > Float.MAX_VALUE)
			System.err.println("overflow");
		return (float)exp;
	}
	
	public float ipow(int base, int exp){
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
			
	    float result = 1;
	    int y = Math.abs(exp);
	    while (y != 0)
	    {
	        if ((y & 1) == 1)
	            result *= base;
	        y >>= 1;
	        base *= base;
	        counterBit++;
	    }
	    if (exp < 0)
	    	result = 1/result;
	    return result;
	}
	
	public double expRek(int x, int y ) {
		counterRek++;

		if (y == 0)
			return 1;		
		
		double exp = expRek(x, Math.abs(y/2));			
		exp = exp*exp;	
		
		if(y%2 != 0)
			exp = exp*x;
		
		if (y < 0)
			exp = 1/exp;
		
		if (exp > Float.MAX_VALUE) {
			System.err.println("overflow");			
		}
		
		return exp;
	}
	
	
	
	
	


}
