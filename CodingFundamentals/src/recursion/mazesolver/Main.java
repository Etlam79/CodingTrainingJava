package recursion.mazesolver;
import java.io.IOException;


public class Main {
	private static Maze maze;
	
	public static void main(String[] args) throws IOException {
		maze = new Maze();
		MazePosition start = maze.init(5,3);
		
		
		System.out.println(getExit(start));
		maze.createOutput(5,3);
	}
	
	
	public static MazePosition getExit(MazePosition pos) {	   	
	   	if (pos.isExit()){
     		return pos;
	   	}
	  
	   	maze.addCurrentPos(pos);
	
	   	pos.setVisited();
	
	   	MazePosition nextPosition = getNextPosition(pos);
	   	MazePosition result;
	
	   	while (nextPosition != null){
	   		result = getExit(nextPosition);
     	
	   		if (result != null)
            	return result;
     	
	   		nextPosition = getNextPosition(pos);
	}
	
	return null;

	}

	private static MazePosition getNextPosition(MazePosition pos) {
		MazePosition next = null;
		if (next == null && isValid(pos.getLeft()))    		
	   		next = getExit(pos.getLeft());
	   			
	   			
	   	if (next == null && isValid(pos.getUpper()))
	   		next = getExit(pos.getUpper());
	   	
	   	if (next == null && isValid(pos.getRight()))
	   		next = getExit(pos.getRight());
	   	
	   	if (next == null && isValid(pos.getLower()))
	   		next = getExit(pos.getLower());
	   	
	   	return next;
	}
	
	
	

	private static boolean isValid(MazePosition pos) {		
		return pos != null && !pos.getVisited();
	}

}
