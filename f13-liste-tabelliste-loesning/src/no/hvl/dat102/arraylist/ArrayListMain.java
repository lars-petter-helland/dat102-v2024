package no.hvl.dat102.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
	
	public static void main(String[] args) {
		
		/*
		 * Interface List<E>
		 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/List.html
		 * "An ordered collection, where the user has precise control over where in the 
		 * list each element is inserted. The user can access elements by their integer 
		 * index (position in the list), and search for elements in the list."
		 *  
		 * NB! indekser går fra 0..n-1 (, ikke 1..n som i ListeADT-en)
		 *  
		 * NB! List-interfacet har noen flere metoder enn det som er naturlig for en
		 *  	liste-ADT (~ "interface bloat"). Viser kun de mest sentrale nedenfor!
		 * 
		 * Class ArrayList<E>
		 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html
		 * "Resizable-array implementation of the List interface. ..."
		 */
		List<String> liste = new ArrayList<>();
		
		liste.add("Java");		//Sist i listen ~ indeks 0
		liste.add(0, "C++");	//På indeks 0. Java flyttes til indeks 1.
		liste.add(1, "Python");	//På indeks 1. Java flyttes til indeks 2.
		liste.add("C++");		//Sist i listen ~ indeks 3.
		
		System.out.println(liste); //List har grei toString-metode
		
		System.out.println("Er Python i listen? " + liste.contains("Python"));
		System.out.println("Er JavaScript i listen? " + liste.contains("JavaScript"));
		
		String s = liste.get(1); //Henter element på indeks 1 (som er Python)
		System.out.println(s);
		
		int i = liste.indexOf("C++"); //Første indeks med C++
		System.out.println("Første C++ på indeks " + i);
		
		i = liste.lastIndexOf("C++"); //Siste indeks med C++
		System.out.println("Siste C++ på indeks " + i);
		
		liste.remove(1);		//Fjerner den på indeks 1 og flytter de bak til venstre
		liste.remove("C++");	//Fjerner den første C++ og flytter de bak til venstre
		System.out.println(liste);
		
		liste.set(1, "Kotlin"); //Erstatter den på indeks 1
		System.out.println(liste);
		
		System.out.println("Antall elementer i listen er " + liste.size());
	}

}
