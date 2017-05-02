package listsandarrays;
public class FindTwoOddNumbersInArray {	
	
	public Integer[] find(int[] array) {
		Integer XOR = null;	
		Integer firstNumber = null;
		Integer secondNumber = null;
		
		for(int i=0; i<array.length; i++){
			if(XOR == null)
				XOR = array[i];
			else
				XOR^=array[i];
		}
		
		// System.out.println("rest " + Integer.toBinaryString(XOR));
		
		int position = findFirstBitWithSetBit(XOR);

		//System.out.println("pos " +position);
		
	
		for (int i=0; i < array.length; i++) {
			if(getBitAtPosition(array[i], position)==0) {
				if(firstNumber==null)
					firstNumber=array[i];
				else
					firstNumber^=array[i];				
			}
			else {
				if(secondNumber == null)
					secondNumber = array[i];
				else
					secondNumber ^= array[i];						
			}				
		}		
		return new Integer[] {firstNumber, secondNumber};
		
	}
	
	
	
	public static int getBitAtPosition(int x, int position){
		return (x>>position)&1;
	}
	
	public static int findFirstBitWithSetBit(int x){
		int position = 0;
		while((x&1) != 1){
			position++;
			x = x>>1;			
		}
		return position;
	}
}