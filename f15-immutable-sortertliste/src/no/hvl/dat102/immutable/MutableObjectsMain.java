package no.hvl.dat102.immutable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableObjectsMain {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("O"); // innhold i sb forandres
		sb.append("K"); // innhold i sb forandres
		String s = sb.toString();
		System.out.println(s);
	
		List<Integer> liste = new ArrayList<>();
		liste.add(123); // innhold i liste forandres
		
		Iterator<Integer> iterator = liste.iterator();
		iterator.next(); // innhold i iterator forandres
	}

}
