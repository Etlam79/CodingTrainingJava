package recursion.eightqueens;

import recursion.helper.Map;
import recursion.helper.Position;

public class ChessBoard extends Map {
	public static final int Queen = 21; 


	public ChessBoard() {
		super(8,8);
	}

	public ChessBoard(int i) {
		super(i, i);
	}
	
	public void setAt(Position pos, boolean set) {
		if (set)
			setValueAt(pos, Queen);
		else
			setFree(pos);
	}
		

	
	@Override
	public void setVisited(Position pos, boolean visited) {
		visitedMap[pos.y][pos.x] += (visited ? 1 : -1);
	}

	
}
