package recursion.mazesolver;
import java.io.IOException;


public class Position implements MazePosition {
	
	private Maze maze;
	private boolean isVisited = false;
	private int x;
	private int y;

	public Position(Maze maze, int x, int y, boolean exit) {
		this.maze = maze;	
		this.x = x;
		this.y = y;
		this.exit = exit;
	}

	private boolean exit;
	
	
	@Override
	public MazePosition getUpper() {
		return maze.get(x, y-1);
	}

	@Override
	public MazePosition getLeft() {
		return maze.get(x-1, y);
	}

	@Override
	public MazePosition getRight() {
		return maze.get(x+1, y);
	}

	@Override
	public MazePosition getLower() {
		return maze.get(x, y+1);		
	}

	@Override
	public boolean isExit() {		
		return exit;
	}

	@Override
	public boolean getVisited() {
		return isVisited;
	}

	@Override
	public void setVisited() {
		isVisited = true;		
	}

	
	@Override 
	public String toString() {			
		return String.format("%s%s", x, y);
		
	}
}
