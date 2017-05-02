package recursion.mazesolver;
public interface MazePosition {
 
   	/**
   	 * @return the MazePosition object above this
   	 * MazePosition object or Null if there is none
   	 */
   	public MazePosition getUpper();
   	
   	/**
   	 * @return the MazePosition object left of this
   	 * MazePosition object or Null if there is none
   	 */
   	public MazePosition getLeft();
   	
   	/**
   	 * @return the MazePosition object right of this
   	 * MazePosition object or Null if there is none
   	 */
   	public MazePosition getRight();
   	
   	/**
   	 * @return the MazePosition object below this
   	 * MazePosition object or Null if there is none
   	 */
   	public MazePosition getLower();
   	
   	/**
   	 * @return true if this MazePosition is an
   	 * exit to the maze
   	 */
   	public boolean isExit ();
   	
   	/**
   	 * @return true if this MazePosition was
   	 * visited before
   	 */
   	public boolean getVisited();
   	
   	/**
   	 * Sets the MazePosition object as a visited
   	 * field of the maze
   	 */
   	public void setVisited(); 
 
}
