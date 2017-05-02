package recursion;


public class CountCents {
	
	public static void main(String[] args) {
		int[][]coins = {{25,0},{10,0},{5,0},{1,0}};
		
	//	System.out.println(Arrays.toString(coins[1]));
		System.out.println(
				new CountCents().countCents(256, 0, 0, coins));
	}
	
	
	
	int countCents(int n, int ways, int index, int[][] coins) { 		
		if (n < 0)
			return 0;
		if (n == 0){
			printResult(coins);		
			return ways+1;
		}			
		int newWays = ways;
		for (int i = index; i < coins.length; i++) {			
			coins[i][1]++;
			newWays += countCents(n-coins[i][0], ways, i, coins);
			coins[i][1]--;
		}						
		return newWays;
	}



	private void printResult(int[][] coins) {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < coins.length; i++) {
			if(coins[i][1] > 0)
				b.append(String.format("%sx%s, " ,coins[i][1], coins[i][0]));
		}
		System.out.println(b.toString());
	}

}
