package recursion.maze;

import recursion.helper.Map;
import recursion.helper.Position;

public class MazeMap extends Map {
	public static final int Exit = 3;
	private int[][] atLeastOnceVisitedPositions;	

	
	public MazeMap(int[][] map) {		
		super(map);		
		atLeastOnceVisitedPositions = new int[map.length][map[0].length];
	}
	
	public boolean isExit(Position pos) {
		return Math.abs(getValueAt(pos)) == Exit;
	}

	
	@Override
	public void setVisited(Position pos, boolean visited) {		
		super.setVisited(pos, visited);
		if(atLeastOnceVisitedPositions[pos.y][pos.x] == 0) {
			atLeastOnceVisitedPositions[pos.y][pos.x] = 1;
			countVisited++;
		}	
	}
	

	
}
