package recursion;

public class Robot {
	Position pos;
	private int[][] map;
	
	public Robot(int[][] map ){
		this.map = map;
		print("      ");
		pos = new Position(0,0, map.length, map[0].length);
	}
	
	public int findPaths() {
		return findPaths(pos);
	}
	
	
	boolean fieldBlocked(int x, int y) {
		return map[x][y] == -1;
	}
	
	private int findPaths(Position pos) {
		if (pos == null)
			return 0;
		if(pos.atGoal()) {
			print(pos.track);
			return 1;
		}
		else
			return findPaths(pos.moveDown()) + findPaths(pos.moveRight());
	}
	
	
	
	
	
	private void print(String track) {
		char[] t = ("S" +track).toCharArray();
		StringBuffer b = new StringBuffer("|");
		int rightCounter = 0;
		int downCounter = 0;
		
		for (int i = 0; i < t.length; i++) {
			if (t[i] == 'S') {
				b.append('S');
				
				
			}
			if (t[i] == 'R') {
				b.append('R');
				rightCounter++;
			}
			if (t[i] == 'D') {
				for(int j = rightCounter+1; j < map.length; j++)
					b.append(map[downCounter][j]==-1 ? 'x': ' ');
				
				b.append("|\n|");
				downCounter++;
				for(int j = 0; j <rightCounter; j++)
					b.append(map[downCounter][j]==-1 ? 'x': ' ');
		
				b.append("D");
			}
			
		}
		
		System.out.println(b.toString() + " |\n\n");
	}





	class Position {
		public int x;
		public int y;
		private int maxX;
		private int maxY;
		private String track;
		
		Position(int x, int y, int maxX, int maxY) {
			this(x, y, maxX, maxY, "");
			
		}
		
		

		Position(int x, int y, int maxX, int maxY, String track) {			
			this.x = x;
			this.y = y;
			this.maxX = maxX;
			this.maxY = maxY;
			this.track = track;
		}
		
		public boolean atGoal() {
			return !canMoveDown() && !canMoveRight();
		}

		Position moveRight() {
			if (!canMoveRight())
				return null;
			return new Position(x+1,y, maxX, maxY, track + 'R');			
		}
		
		
		boolean canMoveRight() {
			return x < maxX-1 && !fieldBlocked(x+1,y);
		}
		
		boolean canMoveDown() {
			return y < maxY-1 && !fieldBlocked(x,y+1);
		}		
		
		Position moveDown() {
			if (!canMoveDown())
				return null;
			return new Position(x, y+1, maxX, maxY, track + 'D');			
		}		
	}
}