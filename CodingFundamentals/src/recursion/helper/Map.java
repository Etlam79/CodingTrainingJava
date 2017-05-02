package recursion.helper;

import java.util.Iterator;
import java.util.stream.Stream;


public class Map implements Iterable<Position>{
	public static final int BLOCK = 2;
	public static final int Free = 1;
	
	protected int[][] map;
	protected int[][] visitedMap;

	public int countVisited;
	
	public Map(int x, int y) {		
		this(new int[x][y]);
		init();
	}
	
	private void init() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Free;
			}			
		}		
	}

	public Map(int[][] map ) {
		this.map = map;
		
		visitedMap = new int[map.length][map[0].length];
	}
	
	public void setVisited(Position pos, boolean visited) {
		
		visitedMap[pos.y][pos.x] = (visited ? 1 : -1);		
	}
	
	public boolean isVisited(Position pos) {
		if (isValidPosition(pos))
			return visitedMap[pos.y][pos.x] > 0;
		return false;
 	}

	public String toString() {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < getSizeX(); i++) 
			b.append("----");
		b.append("\n");
		
		for (int i = 0; i < getSizeX(); i++) {
			for (int j = 0; j < getSizeY(); j++) {
				String val = getValueAt(i, j)+"";
				if(isVisited(new Position(i,j)))
					val = "|"+val+"|";
				b.append(String.format("%3s ", val));
			}
			b.append("\n");
		}
		
		for (int i = 0; i < getSizeX(); i++) 
			b.append("----");
		b.append("\n");
		
		return b.toString();
	}
	
	public boolean isValidPosition(Position pos) {
		return isPositionInMap(pos) && isNotBlocked(pos);				
	}

	public boolean isNotBlocked(Position pos) {
		return getValueAt(pos) != BLOCK;
	}

	public int getValueAt(Position pos) {
		return getValueAt(pos.x, pos.y);	
	}
	
	public int getValueAt(int x, int y) {	
		try {
			return map[y][x];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(x + ", " + y);
			throw e;
		}
	}
	
	public void setValueAt(Position pos, int value) {
		map[pos.y][pos.x] = value;		
	}

	public boolean isPositionInMap(Position pos) {
		return pos.x >= 0 && pos.x < getSizeX() &&
			   pos.y >= 0 && pos.y < getSizeY();
	}
	
	public int getSizeY() {		
		return map.length;
	}

	public int getSizeX() {
		return map[0].length;
	}

	public boolean isBlocked(Position p) {		
		return getValueAt(p) == BLOCK;
	}

	public void setBlocked(Position pos) {
		setValueAt(pos, BLOCK);
		
	}

	public void setFree(Position pos) {
		setValueAt(pos, Free);
		
	}

	@Override
	public Iterator<Position> iterator() {
		return new MapPositionIterator();
	}
	
	class MapPositionIterator implements Iterator<Position> {
		private int x = 0;
		private int y = 0;
		
		@Override
		public boolean hasNext() {
			return x < getSizeX() && y < getSizeY();
		}

		@Override
		public Position next() {
			Position next = new Position(x,y);
			if (x < getSizeX()-1)
				x++;
			else if (y < getSizeY()) {
				x = 0;
				y++;
			}
		
			return next;
			
		}
		
	}
}
