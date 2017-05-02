package recursion.helper;

import java.util.function.Function;

public class Position implements Function<Position, Position>{
	public int x;
	public int y;
	
	public Position(int x, int y) {		
		this.x = x;
		this.y = y;	
	}
	
	public Position right() {		
		return new Position(x+1, y);
	}
	
	public Position left() {	
		return new Position(x-1, y);
	}
	
	public Position up() {		
		return new Position(x, y-1);
	}
	
	public Position down() {		
		return new Position(x, y+1);
	}
	
	@Override
	public String toString() {	
		return String.format("(%s,%s)", x, y);
	}

	@Override
	public Position apply(Position pos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}