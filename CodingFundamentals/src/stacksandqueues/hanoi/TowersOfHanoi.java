package stacksandqueues.hanoi;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import datastructures.helper.Node;

public class TowersOfHanoi extends Observable {

	HanoiTower start, middle, goal;
	int steps;
	
	public TowersOfHanoi(HanoiTower start) {
		this.start = start;
		this.steps = 0;
		middle = new HanoiTower(0);
		goal = new HanoiTower(0);
	}
	
	
	public void run() {
		moveDisks(start.getSize(), start, goal, middle);	
	}
	
	
	private void moveDisks(int numberOfStones, HanoiTower from, HanoiTower to, HanoiTower buffer) {		
		if (numberOfStones == 0)
			return;
		
		moveDisks(numberOfStones-1, from, buffer, to);
		moveTop(from, to);
		moveDisks(numberOfStones-1, buffer, to, from);	
	}

	private void moveTop(HanoiTower start, HanoiTower goal) {
		if (!start.isEmpty()) {
			goal.push(start.pop());
			setChanged();
		notifyObservers();
		}
		steps++;
	}
	
	
	public static void main(String[] args) {
		TowersOfHanoi t = new TowersOfHanoi(new HanoiTower(20));
		Frame f = new Frame(t, 20);
		t.addObserver(f);
		f.setVisible(true);
		t.run();		
	}
	
	
	
	
	static class Frame extends JFrame implements Observer {
		int x = 800;
		int y = 800;
		int nrOfStones;
		int maxWidth;
		private TowersOfHanoi game;
		int step;
		
		public Frame(TowersOfHanoi t, int stones) {
			setSize(x, y);
			this.game = t;			
			this.nrOfStones = stones;
			this.maxWidth = stones *10;
		
		}
		
		
		@Override
		public void paint(Graphics g) {
			    g.clearRect(0, 0, x, y);     
			int max = nrOfStones;
			
			for (int pos = max; pos > 0; pos--) {		
				printStack(game.start,pos,0, g);
				printStack(game.middle,pos,1, g);
				printStack(game.goal,pos,2, g);
				
				
			}	
	g.drawString("Step " + ++step, x-100, 100);
			
		}

		


		private void printStack(HanoiTower tower, int height, int pos, Graphics g) {
			if (height <= tower.getSize())	{
				
				
				int width = widthOfElem(tower, height);
				
				g.setColor(getColor(width));
				int yHeight = (nrOfStones-height)*20;
				g.fillRect(pos*200 + 50 + (maxWidth-width)/2, yHeight + 50, width, 20);
				g.setColor(Color.black);
				g.drawRect(pos*200 + 50  + (maxWidth-width)/2, yHeight + 50, width, 20);
				
		
			}
			
		}
		
		Color[] colors = {Color.blue, Color.gray, Color.green, Color.yellow, Color.magenta, Color.ORANGE, Color.white, Color.lightGray, Color.black, Color.pink};

		private Color getColor(int width) {
			
			return colors[width/10%10] ;
			
			
		}


		private int widthOfElem(HanoiTower stack, int i) {
			i = stack.getSize() - i ;
			Node<Integer> current = stack.head;
			for (int j = 0; j < i; j++) {
				current = current.getNext();
			}
			return current.getVal() * 10;
		}




		@Override
		public void update(Observable o, Object arg) {
			System.out.println("notify");
		
			 try {
				 
				 repaint();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		

	}
	
	
}
