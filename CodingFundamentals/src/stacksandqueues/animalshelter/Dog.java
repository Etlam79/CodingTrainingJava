package stacksandqueues.animalshelter;

public class Dog extends Animal{

	public Dog(String name) {
		super(name);
	}

	@Override
	public String getType() {
		return "Dog";
	}
}