package threads.diningphilosophers;

public class Main {
	
	public static void main(String[] args) {
		int numberOfSeats = 6;
		
		Fork[] forks = new Fork[numberOfSeats];
		for (int i = 0; i < forks.length; i++) 
			forks[i] = new Fork(i);
		
		
		for (int i = 0; i < numberOfSeats; i++) 
			new Thread(new Philosopher(forks[i], forks[(i+1)%forks.length], i)).start();
		
		
	}

}
