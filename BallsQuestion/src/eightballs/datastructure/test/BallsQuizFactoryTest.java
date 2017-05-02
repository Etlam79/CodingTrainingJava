/**
 * 
 */
package eightballs.datastructure.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eightballs.datastructure.Ball;
import eightballs.datastructure.BallsQuizFactory;

import static org.junit.Assert.*;
/**
 * @author trxadm
 *
 */
public class BallsQuizFactoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link eightballs.datastructure.BallsQuizFactory#getBalls(int)}.
	 */
	@Test
	public void testGetBalls() {
		int noBalls = 8;
		ArrayList<Ball> balls = BallsQuizFactory.instance().getBalls(8);
		assertTrue("No of balls is " + noBalls + " but factory returns " + balls.size(), balls.size() == noBalls);
		System.out.println(balls); 
	}

	@Test
	public void testGetCorrectAnswer(){
		assertTrue("Balls index is out of range", BallsQuizFactory.instance().getCorrectAnswer() >= 0 && BallsQuizFactory.instance().getCorrectAnswer() < 8);
	}
}
