package threads.diningphilosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
	
	private Lock lock ;
	private int id;
//	private boolean lock;
	

	public Fork(int id) {	
		this.id = id;
		this.lock =  new ReentrantLock();
	}
	
	boolean pickUp() {
		return lock.tryLock();
		
//		if (lock)
//			return false;
//		lock = true;
//		return true;
	}
	
	void putDown() {
		lock.unlock();
		
	}

	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

}
