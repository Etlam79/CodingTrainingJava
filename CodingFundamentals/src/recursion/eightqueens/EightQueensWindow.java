package recursion.eightqueens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import recursion.helper.Position;

public class EightQueensWindow extends JFrame implements Observer {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sizeFactor = 40;
	
	private ChessBoard board;
	
	public EightQueensWindow(EightQueens game) {
		
		game.addObserver(this);
		this.board = game.getBoard();
		 
		//System.out.println(map.getSizeX()*sizeFactor +" "+ map.getSizeY()*sizeFactor);
		setSize(board.getSizeX()*sizeFactor, board.getSizeY()*sizeFactor+sizeFactor/2);
		
//		setResizable(false);
	
		getContentPane().add(new BoardPanel(), BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object val) {
//		System.out.println("update");
		repaint();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
	}

	class BoardPanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public  BoardPanel() {
			super();
			setPreferredSize(new Dimension(board.getSizeX()* sizeFactor, board.getSizeY()*sizeFactor+ sizeFactor/2 ));
		}

		@Override
		public void paint(Graphics g) {			
				paintBoard(g);
		}

		private void paintBoard(Graphics g) {
			boolean white = true;
		
			for (Position p: board) {
			
				white = !white;
				if (p.x == 0)
					white = p.y %2 == 0;
				
				Color c = white ? Color.orange : Color.orange.darker().darker();			
					
				
				paintField(p.x, p.y, c, g);	
				
				if (board.getValueAt(p) == ChessBoard.Queen) {
					g.setColor(Color.orange);
					g.drawImage(new ImageIcon("img/queen.png").getImage(), p.x*sizeFactor-2, p.y*sizeFactor+17, this);
				}
//				 if (board.isVisited(p)) 
//					paintField(p.x, p.y, new Color(60,60,60,50), g);	
			
				
			}
		}

		private void paintField(int i, int j, Color color, Graphics g) {
				g.setColor(color);
				g.fillRect(i*sizeFactor, j*sizeFactor+sizeFactor/2, sizeFactor, sizeFactor);
				g.setColor(Color.black);
				g.drawRect(i*sizeFactor, j*sizeFactor+sizeFactor/2, sizeFactor, sizeFactor);
		//		g.setColor(Color.red);
				//g.drawString(""+ board.getValueAt(i,j), i*sizeFactor+10, j*sizeFactor+sizeFactor/2+15);
			}
		
	}

	public static void main(String[] args) {
		EightQueens q = new EightQueens(8);
		new EightQueensWindow(q);
		q.placeQueens();
	
	}
}

