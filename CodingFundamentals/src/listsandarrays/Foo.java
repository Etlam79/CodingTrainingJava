package listsandarrays;

public class Foo {
	static int counter = 0;
	
	  String text = "";
	
	
	public Foo(int i) {
		text = "Hallo " + i;
		counter++;
	}

	
	public void print() {
		System.out.println(text + " " + counter);
	}
	
}
