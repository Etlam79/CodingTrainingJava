/**
 * 
 */
package eightballs.datastructure;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author trxadm
 *
 */
public class BallsQuizFactory{
	private static BallsQuizFactory factory = null;
	private static int answer;
	
	/***
	 * Factory singleton
	 * @return
	 */
	public static BallsQuizFactory instance(){
		if (factory == null)
			return factory = new BallsQuizFactory();
		else
			return factory;
	}
	
	/**
	 * 
	 * @param number
	 * @return will return 1 ball that is heavier.
	 */
	public ArrayList<Ball> getBalls(int number){
		
		Random r = new Random();
		answer = r.nextInt(number);
				
		ArrayList<Ball> balls = new ArrayList<Ball>();
		
		for (int i=0; i < number; i++){
			if (i == answer)
				balls.add(new Ball(i,100));
			else
				balls.add(new Ball(i,10));	
				
		}		
		return balls;
	}
	
	public int getCorrectAnswer(){
		return answer;
	}
}
