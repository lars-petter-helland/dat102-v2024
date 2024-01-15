package dat102.f02.tabellbag;

public class TabellBagMain {
	
	public static void main(String[] args) {
		
		BagADT<String> bag = new TabellBag<>();
		
		System.out.println("size = " + bag.getCurrentSize());
		System.out.println("empty= " + bag.isEmpty());
		
		
	}

}
