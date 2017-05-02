package datastructures;

public class BitVector {	
	private int [] vector;
	private final int sizeOfInt = 32;	
		
	public BitVector(int size) {
		this.vector = new int[(size/sizeOfInt)+1];
	}	
	
	public void setBit(int index) {
		// bucket = index/32 <=> index/ 2^5 <=>  index>>5
		int bucket = index>>5; 
		int maskWithSetBit = getMaskWithSetBit(index);		
		vector[bucket] = vector[bucket] | maskWithSetBit;
	}

	public boolean isSet(int index) {
		int bucket = index>>5; 		
		int maskWithSetBit = getMaskWithSetBit(index);
		return (vector[bucket] & maskWithSetBit) > 0;
	}
		
	private int getMaskWithSetBit(int index) {
		// 0x1f = 00011111 <=> 31
		byte bitMask = 0x1f;
		// bit = index % 32 <=> index & 31	
		int bit = index & bitMask;
		// create a 0 bit mask with one 1 at the position index%32
		return  1 << bit;		
	}
		
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();		
		for (int i : vector) 
			b.append("[" + Integer.toBinaryString(i) + "]\n");		
		return b.toString();
	}
	
	public static void main(String[] args) {
		BitVector b = new BitVector(200);
		for (int i = 0; i < 200; i+=2) {
			b.setBit(i);
		}
		System.out.println(b.toString());
		System.out.println(b.isSet(88));
	}

}
