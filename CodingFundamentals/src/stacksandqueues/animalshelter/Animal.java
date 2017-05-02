package stacksandqueues.animalshelter;

import java.util.Random;

public abstract class Animal {
		String name;		
		
		public Animal(String name) {
			this.name = name;
		}
		
		public abstract String getType();
		

		private static final String[] namePool = {"Sam", "Bob", "Tinka", "Charlie", "Sheela", "Buddy", "Daisy"}; 
		
		public static Animal createRandomAnimal() {
			Random r = new Random();
			String name = namePool[r.nextInt(namePool.length)];
			if (r.nextInt() % 2 == 0)
				return new Dog(name);
			else
				return new Cat(name);
			
		}
	}
