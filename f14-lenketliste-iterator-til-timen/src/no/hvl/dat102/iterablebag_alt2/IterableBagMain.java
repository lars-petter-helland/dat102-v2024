package no.hvl.dat102.iterablebag_alt2;

import java.util.Iterator;

public class IterableBagMain {
	
	public static void main(String[] args) {
		
//		IterableBagADT<String> bag = new IterableTabellBag<>();
		IterableBagADT<String> bag = new IterableLenketBag<>();
		
		System.out.println("Tom bag ...");
//		Iterator<String> iterator = bag.iterator();
//		System.out.println(iterator.next()); //Kaster NoSuchElementException
		
		for (String navn : bag) {
			System.out.println(navn);
		}
		
		bag.add("Per");
		bag.add("Pål");
		bag.add("Espen");
		
		Iterator<String> iterator = bag.iterator();
		
		System.out.println("\nwhile (i.hasNext()) { sysout(i.next()); }");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
//		System.out.println(iterator.next()); //Kaster NoSuchElementException
		
		System.out.println("\nfor (String navn : bag) { sysout(navn); }");
		for (String navn : bag) {
			System.out.println(navn);
		}
	}

}
