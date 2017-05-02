package recursion.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import recursion.helper.Map;
import recursion.helper.Position;
import recursion.maze.Maze;
import datastructures.ArrayList;

public class MazeWindow extends JFrame implements Observer {
	
	private MazeMap map;
	private int sizeFactor = 40;
	private Maze maze;
	private Position currentPosition;
	private Position previousPosition;
	private int maxVisited = 0;
	
	public MazeWindow(Maze m) {
		this.maze = m;
		maze.addObserver(this);
		this.map = maze.getMap();
		currentPosition = null; 
		//System.out.println(map.getSizeX()*sizeFactor +" "+ map.getSizeY()*sizeFactor);
		setSize(map.getSizeX()*sizeFactor, map.getSizeY()*sizeFactor+sizeFactor/2);
		setVisible(true);
		setResizable(false);
	}
	
	@Override
	public void paint(Graphics g) {	
		if (currentPosition == null) {
			paintMaze(g);
		}		
		else {
			if (previousPosition != null)
				printField(g, previousPosition, Color.pink);
			printField(g, currentPosition, Color.blue);		
		}
	}

	private void printField(Graphics g, Position pos, Color c) {		
		g.setColor(c);
		int x = pos.x*(sizeFactor);
		int y = pos.y*(sizeFactor) + +sizeFactor/2;
		g.fillRect(x, y, sizeFactor, sizeFactor);
		g.setColor(Color.black);
		g.drawRect(x, y, sizeFactor, sizeFactor);		
	}

	private void paintMaze(Graphics g) {
		for (Position position : map) {
			Color c = Color.white;
			
			if (map.getValueAt(position) == Map.BLOCK)
				c = Color.black;					
			
			if (map.getValueAt(position) == MazeMap.Exit)
				c = Color.yellow;	
			
			paintField(position, c, g);
		}

	}
	
	private void updateMaze(Graphics g) {
		for (Position position : map) {	
			if (map.isVisited(position))
				paintField(position, Color.lightGray, g);				
		}
	}

	private void paintField(Position position, Color color, Graphics g) {
		int i = position.x;
		int j = position.y;
		g.setColor(color);
		g.fillRect(i*sizeFactor, j*sizeFactor+sizeFactor/2, sizeFactor, sizeFactor);
		g.setColor(Color.black);
		g.drawRect(i*sizeFactor, j*sizeFactor+sizeFactor/2, sizeFactor, sizeFactor);
//		g.setColor(Color.red);
//		g.drawString(""+ map.getValueAt(i,j), i*sizeFactor+10, j*sizeFactor+sizeFactor/2+15);
	}

	@Override
	public void update(Observable o, Object val) {	
		if (val == null)
			updateVisitedFields();
		else
			animateSolution((ArrayList<Position>) val);		
	}

	private void updateVisitedFields() {
	
			updateMaze(getGraphics());
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
	}

	private void animateSolution(ArrayList<Position> track) {		
		currentPosition = null;
		repaint();
		for (Position position : track) {					
			previousPosition = currentPosition;
			currentPosition = position; 
			
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	public static void main(String[] args) {

//		int[][] map = {
//				{ 1, 1, 1, 2, 1 },
//				{ 1, 2, 1, 1, 1 },
//				{ 1, 2, 1, 1, 3 },
//				{ 1, 1, 1, 2, 1 },
//				{ 1, 1, 1, 1, 1 }
//			};
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
			{ 1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1 },
		};
		//	
		//	int[][] map = {
		//			{  1, 1, 1 },
		//			{  1, 1, 1 },
		//			{  1, 1, 3 },
		//		};
		//	
		
		Maze m = new Maze(new MazeMap(map));
		MazeWindow w = new MazeWindow(m);
		
		long time = System.currentTimeMillis();
		m.findExit(new Position(0,0));
		long end = System.currentTimeMillis();
		
		System.out.println("Maze 2: " + (end-time));
		
		
		Maze m1 = new Maze(new MazeMap(map));
		//w = new MazeWindow(m1);
		
		 time = System.currentTimeMillis();
		m.findExit(new Position(0,0));
		 end = System.currentTimeMillis();
		System.out.println("Maze: " + (end-time));
		
		
	}
}

