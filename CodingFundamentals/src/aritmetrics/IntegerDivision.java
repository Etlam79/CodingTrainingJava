package aritmetrics;
import java.util.Random;

public class IntegerDivision {

	public static void main(String[] args) {
		int rekFaster = 0;
		int iterations = 1;
		// test
		for (int i = 0; i < iterations; i++) {
			Random r = new Random();
			int lhs = Math.abs(r.nextInt(100000));
			int rhs = Math.abs(r.nextInt(1000));
			// int lhs = 220;
			// int rhs = 4;
			System.out.printf("%s/%s  ", lhs, rhs);
			steps = 1;
			nonRekSteps = 1;

			try {
				int resultRek = divide(lhs, rhs);
				int resultNonRek = divideNonRek(lhs, rhs);
				int resultDivideBySubstraction = divideBySubstracting(lhs, rhs);

				if (resultNonRek != resultRek
						&& resultRek != resultDivideBySubstraction)
					System.out
							.printf("ERROR recursive: %s, non recursive: %s substraction: %s, correct: %s,",
									resultRek, resultNonRek,
									resultDivideBySubstraction, lhs / rhs);

				if (steps <= nonRekSteps)
					rekFaster++;
				System.out.printf("r:%s i: %s s:%s ", steps, nonRekSteps,
						resultDivideBySubstraction);
				System.out.printf("\n");

			} catch (IllegalArgumentException e) {

			}

		}
		System.out.printf("rekusive faster in %s percent of the cases:",
				(float) rekFaster / iterations * 100);

		// System.out.println(findMultiple(12, 4, 4));
	}

	private static int divideBySubstracting(int lhs, int rhs) {
		if (rhs == 0)
			throw new IllegalArgumentException("cannot divide by zero");
		if (rhs > lhs)
			return 0;

		int steps = 0;

		while (lhs > rhs) {
			lhs = lhs - rhs;
			steps++;
		}
		return steps;
	}

	// private static char[] findMultiple(int lhs, int rhs, int pivot) {
	// int res = rhs * pivot;
	// if (res == lhs) return pivot;
	// if (res < lhs) findMultiple(lhs, rhs, pivot );
	// if (res < lhs) findMultiple(lhs, rhs, pivot*2);
	//
	// }

	static int steps = 1;
	static int nonRekSteps = 1;

	private static int divideNonRek(int lhs, int rhs) {
		if (rhs == 0)
			throw new IllegalArgumentException("cannot divide by zero");
		if (rhs > lhs)
			return 0;

		int multipleOfRhs = rhs;
		int times = 1;
		while (multipleOfRhs + rhs <= lhs) {
			multipleOfRhs += rhs;
			times++;
			nonRekSteps++;
		}

		return times;
	}

	private static int divide(int lhs, int rhs) {
		return divide(lhs, rhs, 1, 1, lhs);
	}

	private static int divide(int lhs, int rhs, int pivot, int low, int high) {

		if (rhs == 0)
			throw new IllegalArgumentException("cannot divide by zero");
		if (rhs > lhs)
			return 0;

		while (!(pivot * rhs <= lhs && pivot * rhs + rhs > lhs)) {
			steps++;

			System.out.println("(" + lhs + ", " + rhs + ")" + low + " ["
					+ pivot + "] " + high);

			if (pivot * rhs > lhs) {
				high = pivot;
				int mid = (high - low) / 2;
				pivot = mid;

			} else {
				low = pivot + 1;
				int mid = low + (high - low) / 2;
				pivot = mid;

			}

		}
		return pivot;
	}
}
