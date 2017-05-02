package recursion.eightqueens;

import java.util.Observable;
import java.util.function.Function;

import recursion.helper.Position;
import datastructures.ArrayList;

public class EightQueens extends Observable {	
	private ChessBoard board;
	private int n;

	public EightQueens(int n) {
		this.n = n;
		this.board = new ChessBoard(n);
		
	}	
	
	public int placeQueens() {
		int possibilities = placeQueens(n,0, null);			
		return possibilities;
	}
		
	private int placeQueens(int n, int solutions, Position position) {
		if (n == 0) {					
			setChanged();
			notifyObservers();			
			return solutions + 1;
		}
				
		ArrayList<Position> positions = getAllValidPositions(position);
		if(positions.isEmpty())
			return 0;
		
		// System.out.println(positions.size());
		int newSolutions = 0;
		for (Position pos : positions) {
			setVisited(pos, true);
			// 	System.out.println(board);		
			newSolutions += placeQueens(n-1, solutions, pos);
			setVisited(pos, false);
		}
		return solutions + newSolutions;
	}

	private void setVisited(Position pos, boolean visited) {		
		board.setAt(pos, visited);
		board.setVisited(pos, visited);
		
		setVisited(pos, visited, p -> p.right());
		setVisited(pos, visited, p-> p.left());
		setVisited(pos, visited, p-> p.down());		
		setVisited(pos, visited, p -> p.up());
		
		setVisited(pos, visited, p-> p.left().up());
		setVisited(pos, visited, p-> p.left().down());
		setVisited(pos, visited, p -> p.right().up());
		setVisited(pos, visited, p-> p.right().down());		
	}
		
	private void setVisited(Position pos, boolean visited, Function<Position, Position> d) {
		Position current = d.apply(pos);
		while(board.isValidPosition(current)) {
			board.setVisited(current, visited);
			current =  d.apply(current);		
		}
	}



	private ArrayList<Position> getAllValidPositions(Position from) {	
		ArrayList<Position> list = new ArrayList<Position>();
		
		for (Position p : board){	
			boolean notComputed =
					from == null ||
					p.y > from.y ||
					(p.y == from.y && p.x > from.y);
			
			if (!board.isVisited(p) && notComputed ) 
				list.add(p);					
		}
		
		
		
		return list;
	}
	
	public ChessBoard getBoard() {
		return board;		
	}
	

}