package strings;

public class RotateMatrix {
	
	public static byte[][] rotate(byte[][] m) {
		byte[][] rotated = new byte[m.length][m.length];
		
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) 
				rotated[j][m.length-1-i] = m[i][j];
		}
		
		return rotated;
	}

	
	
	
	public static byte[][] rotateInPlace(byte[][] m) {		
		int n = m.length-1;
		
		for (int i = 0; i <= n/2; i++) {			
			int first = i;
			
			for (int j = first; j <= n/2; j++) { 
				
				print(m);
				
				
//				byte upperLeft  = m[i][j];
//				byte upperRight = m[j][n-i];
//				byte lowerRight = m[n-i][n-j];
//				byte lowerLeft  = m[n-j][i];		
						
				byte temp = m[first][j];
				m[i][j] = m[n-j][first];
				m[n-j][i] = m[n-i][n-j];
				m[n-i][n-j] = m[j][n-i];
				m[j][n-i] = temp;				
			}
		}		
		print(m);
		return m;
	}


	private static void print(byte[][] m) {

		for (int i = 0; i < m.length; i++) {			
						
			for (int j = 0; j < m.length; j++) 
				System.out.print(m[i][j] + " ");
			
			System.out.print("\n ");
		}
		System.out.print("\n ");
	}
public static void main(String[] args) {
	byte[][] a = new byte[][] { {1, 2, 3, 4},
            					{5, 6, 7, 8},
            					{9, 10, 11, 12},
            					{13, 14, 15, 16}};

rotateInPlace(a);


}
	
}
