package recursion.mazesolver;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Maze {
	
	int [][] maze = {{1,2,1,1,1,1,1,1,1},
					 {1,0,0,0,1,0,0,1,1},
					 {1,0,1,0,1,0,1,1,1},
					 {1,1,1,0,0,0,0,0,1},
					 {1,1,1,1,1,1,0,1,1},
					 {1,0,1,0,0,0,0,1,1},
					 {1,0,1,0,1,1,0,1,1},
					 {1,0,0,0,0,0,0,0,1},
					 {1,0,1,1,1,0,1,1,1},
					 {1,1,1,1,1,1,1,1,1},
					 };
	
	private Hashtable<String, MazePosition> position = new Hashtable<String, MazePosition>();
	
	public MazePosition init(int a, int b) {
		for (int x = 0; x < maze.length; x++) {
			for (int y = 0; y < maze[x].length; y++) {
				if (isAccessible(x,y)) {				
					MazePosition pos = new Position(this, x,y, isExit(x,y));					
					position.put(x+""+y, pos);
				}
			}
		}
		MazePosition start = get(a,b);
		if (start == null)
			throw new RuntimeException("illegal start state");
		return start;
	}

	private boolean isExit(int x, int y) {
		return maze[x][y] == 2;
	}

	private boolean isAccessible(int x, int y) {		
		return maze[x][y] != 1 ;
	}

	public MazePosition get(int x, int y) {				
		return position.get(x+""+y);
	}

	
	private List<String> sequence = new ArrayList<String>();
	
	

	
	
	public void createOutput(int x, int y) throws IOException {
		String s = "<table style='border:solid 0px'>";
		
		for (int i= 0; i < maze.length; i++) {
			s+="<tr style='border:0 px; margin:0ps;padding 0px; '>\n";
			for (int j = 0; j < maze[i].length; j++) {
				String positionType="";
				
				if (i == x && j == y)
					positionType = "background-image:url(rabbit-icon.png);background-size:contain";
				else
					positionType += (maze[i][j]==1) ? "background-image:url(bush.png);background-size:contain" : "";
				s+="<td id='"+i+""+j+"' style='width:20px;height:20px;"+positionType+"'> </td>\n";
			}
			s+="<tr>\n";
			
		}
		
		s=  s + "</table>";	
		s += renderSequenceArray(sequence); 	
		
		
		byte[] part1 = s.getBytes();
		byte[] part2 = Files.readAllBytes(Paths.get("js"));		
		Files.write(getOutputFile(), concat(part1, part2), StandardOpenOption.TRUNCATE_EXISTING);	
	}
	
	private Path getOutputFile() {
		try {
			Path file = Paths.get("maze.html");
			
			if (! Files.exists(file))
				file = Files.createFile(file);
			
			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private byte[] concat(byte[] A, byte[] B) {
	   int aLen = A.length;
	   int bLen = B.length;
	   byte[] C= new byte[aLen+bLen];
	   System.arraycopy(A, 0, C, 0, aLen);
	   System.arraycopy(B, 0, C, aLen, bLen);
	   return C;
	}

	private String renderSequenceArray(List<String> sequence) {
		String values = "";
		for (String point : sequence) 
			values +="\""+point+"\",";
		
		values = values.substring(0, values.length()-1);			
		return "<script>var sequence = [" + values + "];</script>";
	}

	public void addCurrentPos(MazePosition pos) {		
		sequence.add(pos.toString());
	}	

}
