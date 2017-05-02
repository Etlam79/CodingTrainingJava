package stacksandqueues.animalshelter;

import datastructures.LinkedList;

public class AnimalShelter  {

	private LinkedList<AnimalData> cats;
	private LinkedList<AnimalData> dogs;
	private int timestamp;
	
	public AnimalShelter() {
		cats = new LinkedList<AnimalData>();
		dogs = new LinkedList<AnimalData>();
		timestamp = 1;
	}
	
	
	public void enqueue(Animal a) {
		if (a instanceof Cat)
			cats.add(new AnimalData(a, ++timestamp));
		if (a instanceof Dog)
			dogs.add(new AnimalData(a, ++timestamp));
	}
	
	
	public Animal dequeueAny() {
		if (cats.isEmpty())
			return dequeueDog();
		if (dogs.isEmpty())
			return dequeueCat();			

		AnimalData cat = cats.peek();
		AnimalData dog = dogs.peek();
		
		
		if (cat.isOlderThan(dog))
			return dequeueCat();
		else
			return dogs.poll().animal;
		
		
	}
	
	
	public Cat dequeueCat() {
		return (Cat) cats.poll().animal;
	}
	
	public Dog dequeueDog() {
		return (Dog) dogs.poll().animal;
	}
	
	
	
	
	
	class AnimalData {
		private Animal animal;
		private int timestamp;

		public AnimalData(Animal animal, int timestamp) {
			this.animal = animal;
			this.timestamp = timestamp;
		}

		public boolean isOlderThan(AnimalData other) {
			return timestamp < other.timestamp;
		}
		
		
	}
	
	
}
