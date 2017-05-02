package recursion;

import java.util.Random;

public class FindPath {

	int[][] matrix;
	
	public FindPath(int size) {
		matrix = new int[size][size];
		Random r = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = r.nextInt(100)%2;
			}
		}
	}
	
	
	public FindPath(int[][] m) {
		matrix = m;
	}

int counter;
	public boolean findPath(int ax, int ay, int bx, int by) {
		
		if(ax == bx && ay == by)
			return true;
		if(ax > bx || ay > by)
			return false;
		
		int current = matrix[ax][ay];
		//System.out.printf("%s-%s\n", ax, ay);
		counter++;
		
		if (ax+1 < matrix.length &&  matrix[ax+1][ay]==current) {
			if (findPath(ax+1, ay, bx, by))
				return true;
		}
		
		if (ay+1 < matrix.length && matrix[ax][ay+1]==current) {
			if (findPath(ax, ay+1, bx, by))		
			return true;
		}
		return false;

	}
	
	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				b.append(matrix[i][j]+"");
			}
			b.append("\n");
		}
		return b.toString();
	}
	
	
	public static void main(String[] args) {
		
//		int[][] test1 = {
//				{0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0},				
//				{0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0},				
//				{0,0,0,0,0,0,0,0}
//		};
		int[][] test = {
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				
		};
		
		
		
		FindPath p = new FindPath(test);
		System.out.println(p);
		System.out.println(p.findPath(0,0,17,17));
		System.out.println(p.counter);
	}
}
