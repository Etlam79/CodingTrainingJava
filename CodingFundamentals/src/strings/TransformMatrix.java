package strings;

public class TransformMatrix {
	
	
	public static int[][]  tansform(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
					
				}
				
			}
		}
		for (int i = 0; i < m.length; i++) {
			if(m[i][0] == 0)
				nullifyRow(m, i);
			if(m[0][i] == 0)
				nullifyColumn(m, i);
		}
		print(m);
		return m;
	}

	private static void nullifyColumn(int[][] m, int i) {
		for (int j = 0; j < m.length; j++) 
			m[j][i] = 0;			
	}

	private static void nullifyRow(int[][] m, int i) {
		for (int j = 0; j < m.length; j++) 
			m[i][j] = 0;			
		
	}
	
	private static void print(int[][] m) {

		for (int i = 0; i < m.length; i++) {			
						
			for (int j = 0; j < m.length; j++) 
				System.out.print(m[i][j] + " ");
			
			System.out.print("\n ");
		}
		System.out.print("\n ");
	}

}
