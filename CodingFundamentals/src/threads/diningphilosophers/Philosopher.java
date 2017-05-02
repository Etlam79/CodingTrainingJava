package threads.diningphilosophers;


public class Philosopher implements Runnable{
	
	private int place;
	private Fork left;
	private Fork right;
	
	
	public Philosopher(Fork left, Fork right, int place) {		
		this.place = place;
		this.left = left;
		this.right = right;
	}
	

	
	void eat() {
		while (!grabForks()) {	
			waitAWhile();
		}
		
		eatAWhile();		
		releaseForks();
	}

	

	
	private boolean grabForks() {
		//deadlock		
//		left.pickUp();
//		System.out.printf("%s grabs left fork\n", this);
//		right.pickUp();
//		System.out.printf("%s grabs right fork\n", this);
		if (!left.pickUp())
			return false;
		System.out.printf("%s grabs left fork\n", this);
		if (!right.pickUp()) {
			left.putDown();
			return false;
		}
		System.out.printf("%s grabs right fork\n", this);
		return true;
	}

	private void releaseForks() {
		left.putDown();
		right.putDown();
	}
	


	private void waitAWhile() {
		sleep(500);	
	}

	
	private void eatAWhile() {
		System.out.printf("%s starts eating\n", this);
		sleep(500);		
	}
	
	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}	
	}

	@Override
	public void run() {
		eat();		
	}
	
	@Override
	public String toString() {		
		return String.format("Philosopher %s", place);
	}
	
	

}
