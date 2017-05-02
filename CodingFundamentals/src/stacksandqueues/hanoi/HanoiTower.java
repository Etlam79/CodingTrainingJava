package stacksandqueues.hanoi;

import datastructures.Stack;

public class HanoiTower extends Stack<Integer> {
		public HanoiTower(int n) {
			super();
			for (int j = n; j > 0; j--) {
				push(j);
			}
		}

		@Override
		public boolean push(Integer elem) {
			if (!isEmpty() && elem > peek())
				return false;
			return super.push(elem);
		}		
	}