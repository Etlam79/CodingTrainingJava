package listsandarrays;

import org.junit.Test;

public class FooTest {

	public static void main(String[] args) {
		Foo f = new Foo(12) {
			@Override
			public void print() {
			System.out.println("Hallo!");
				super.print();
			}
		};
	
		Foo f2 = new Foo(12);
		
		f.print();
		f2.print();
	}

}
