package recursion.maze;


import java.util.Observable;

import datastructures.ArrayList;
import recursion.helper.Position;


public class Maze extends Observable {
	
	private MazeMap map;
	private int max;

	public Maze(MazeMap m) {
		this.map = m;		
	}	
	
	public void findExit(Position start) {
		int path;
		int limit = 0;
		max =  map.getSizeX()*map.getSizeY();
		
		try {
			path = findExit(start,track, 0);
			setChanged();
			notifyObservers(this.track);
			
			System.out.println(path);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	ArrayList<Position> track = new ArrayList<Position>();
	
	private int findExit(Position pos, ArrayList<Position> track,  int pathLength) throws CloneNotSupportedException {
		if (map.isExit(pos)) {
			this.track = (ArrayList<Position>)track.clone();
			
			return pathLength;
		}
		
		if(pathLength >= max)
			return -1;		
		
	
		ArrayList<Position> nextPos = getValidSuccessors(pos);
		if (nextPos.isEmpty())
			return -1;
		
		
				
		int tempLength = -1;
		int result = -1;
		
		map.setVisited(pos, true);
		track.add(pos);
		

		
		for (Position next : nextPos) {			
			tempLength = findExit(next, track, pathLength+1);
			if (tempLength > 0) {
				max = Math.min(max, tempLength);	
				if (result < 0)
					result = tempLength;
				else
					result = Math.min(result, tempLength);
			}
		}		
		map.setVisited(pos, false);
		track.removeLast();
		return result;
		
	}


	private ArrayList<Position> getValidSuccessors(Position pos) {		
		ArrayList<Position> list = new ArrayList<Position>();
		addIfValid(list, pos.left());
		addIfValid(list, pos.right());
		addIfValid(list, pos.up());
		addIfValid(list, pos.down());			
		return list;
	}


	private void addIfValid(ArrayList<Position> list, Position pos) {
		if (map.isValidPosition(pos) && !map.isVisited(pos) )
			list.add(pos);
	}
	
	public static void main(String[] args) {
		
//		int[][] map = {
//						{ 1, 1, 1, 2, 1 },
//						{ 1, 2, 1, 1, 1 },
//						{ 1, 2, 1, 1, 3 },
//						{ 1, 1, 1, 2, 1 },
//						{ 1, 1, 1, 1, 1 }
//					};
//				
		
		int[][] map = {
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 2, 1, 2, 2, 1, 1, 1, 1, 1 , 1, 1, 1, 1},
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },		
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },		
			{ 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1 }};
			
		Maze m = new Maze(new MazeMap(map));
		m.findExit(new Position(0,0));
	}

	public MazeMap getMap() {
		return map;
	}
}
