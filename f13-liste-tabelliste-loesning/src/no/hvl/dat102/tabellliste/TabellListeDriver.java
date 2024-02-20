package no.hvl.dat102.tabellliste;

import no.hvl.dat102.listeadt.ListeADT;

/**
 * A driver that demonstrates the class AList.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 *          Fikset litt av Lars-Petter Helland februar 2024
 */
public class TabellListeDriver {
	
	public static void main(String[] args) {
		testStringList();
		System.out.println("\n\nDone.");
	}

	public static void testStringList() {
		ListeADT<String> myList = new TabellListe<>();

		System.out.println("Testing add to end: Add 15, 25, 35, 45");
		myList.add("15");
		myList.add("25");
		myList.add("35");
		myList.add("45");

		System.out.println("\n\nList should contain\n15 25 35 45 ");
		displayList(myList);

		System.out.println("\nIs List empty? " + myList.isEmpty());

		System.out.println("Add more entries to end: Add 55, 65, 75, 85, 95");
		myList.add("55");
		myList.add("65");
		myList.add("75");
		myList.add("85");
		myList.add("95");

		System.out.println("\n\nIs List empty? " + myList.isEmpty());

		System.out.println("-------------------------\n");
		System.out.println("\n\nList should contain 15 25 35 45 55 65 75 85 95");
		displayList(myList);

		System.out.println("\n------------------------\n");
		System.out.println("Testing clear() ");
		myList.clear();

		System.out.println("List should be empty: ");
		System.out.println("Is list empty? " + myList.isEmpty());

		System.out.println("-------------------------\n");
		System.out.println("Create a new list.\n");
		myList = new TabellListe<>();

		System.out.println("Add 15 at position 1:");
		myList.add(1, "15");
		System.out.println("Add 25 at position 2:");
		myList.add(2, "25");
		System.out.println("Add 35 at position 3:");
		myList.add(3, "35");
		/*
		 * System.out.println("Add 99 at position 0:"); myList.add(0, "99");
		 * System.out.println("Add 99 at position 9:"); myList.add(9, "99");
		 */

		System.out.println("\n\nList should contain\n15 25 35 ");
		displayList(myList);

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("Add 19 at position 1:");
		myList.add(1, "19");
		System.out.println("Add 39 at position 3:");
		myList.add(3, "39");
		System.out.println("Add 29 at position 2:");
		myList.add(2, "29");
		System.out.println("Add 55 at position 7:");
		myList.add(myList.getLength() + 1, "55");
		System.out.println("Add 65 at position 8:");
		myList.add(8, "65");

		System.out.println("\n\nList should contain\n19 29 15 39 25 35 55 65");
		displayList(myList);

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("\n-------------------------\n");
		System.out.println("Testing remove() ");
		System.out.println("Removing 15 at position 3: returns " + myList.remove(3));
		System.out.println("Removing 19 at position 1: returns " + myList.remove(1));
		System.out.println("Removing 65 at position 6: returns " + myList.remove(6));
		/*
		 * System.out.println("Removing ?? at position 6: returns " + myList.remove(6));
		 * System.out.println("Removing ?? at position 0: returns " + myList.remove(0));
		 */
		System.out.println("\n\nList should contain\n29 39 25 35 55");
		displayList(myList);

		System.out.println("\n-------------------------\n");
		System.out.println("Testing replace() ");
		System.out.println("Replace 29 at position 1 with 92 : returns " + myList.replace(1, "92"));
		System.out.println("Replace 39 at position 2 with 93 : returns " + myList.replace(2, "93"));
		System.out.println("Replace 25 at position 3 with 52 : returns " + myList.replace(3, "52"));
		System.out.println("Replace 35 at position 4 with 53 : returns " + myList.replace(4, "53"));
		System.out.println("Replace 55 at position 5 with 50 : returns " + myList.replace(5, "50"));
		/*
		 * System.out.println("Replace ?? at position 0 with 99 : returns " +
		 * myList.replace(0, "99"));
		 * System.out.println("Replace ?? at position 6 with 99 : returns " +
		 * myList.replace(6, "99"));
		 */
		System.out.println("\n\nList should contain\n92 93 52 53 50");
		displayList(myList);

		System.out.println("Is List empty? " + myList.isEmpty());

		System.out.println("\n-------------------------\n");
		System.out.println("Testing getEntry() ");
		int numberOfEntries = myList.getLength();

		System.out.println("\nThe list contains " + numberOfEntries + " entries, as follows:");
		for (int position = 1; position <= numberOfEntries; position++)
			System.out.println(myList.getEntry(position) + " is entry " + position);
		System.out.println();
		System.out.println("\n-------------------------\n");
		System.out.println("Testing contains() [results should be TRUE]");
		System.out.println("List contains 92: " + myList.contains("92"));
		System.out.println("List contains 52: " + myList.contains("52"));
		System.out.println("List contains 53: " + myList.contains("53"));
		System.out.println("List contains 50: " + myList.contains("50"));
		System.out.println("\n");

		System.out.println("Testing contains() [results should be FALSE]");
		System.out.println("List contains 91 returns : " + myList.contains("91"));
		System.out.println("List contains 55 returns : " + myList.contains("55"));
		System.out.println("List contains 4  returns : " + myList.contains("4"));
		System.out.println("List contains 12 returns : " + myList.contains("12"));

	} // end testStringList

	public static void displayList(ListeADT<String> list) {
		System.out.println("The list contains " + list.getLength() + " string(s), as follows:");
		Object[] listArray = list.toArray();
		for (int index = 0; index < listArray.length; index++) {
			System.out.print(listArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayList
} // end Driver
/*
 * Testing add to end: Add 15, 25, 35, 45
 * 
 * 
 * List should contain 15 25 35 45 
 * The list contains 4 string(s), as follows:
 * 15 25 35 45
 * 
 * Is List empty? false 
 * Add more entries to end: Add 55, 65, 75, 85, 95
 * 
 * 
 * Is List empty? false 
 * -------------------------
 * 
 * 
 * 
 * List should contain 15 25 35 45 55 65 75 85 95 
 * The list contains 9 string(s), as follows: 
 * 15 25 35 45 55 65 75 85 95
 * 
 * ------------------------
 * 
 * Testing clear() 
 * List should be empty: 
 * Is list empty? true
 * -------------------------
 * 
 * Create a new list.
 * 
 * Add 15 at position 1: 
 * Add 25 at position 2: 
 * Add 35 at position 3:
 * 
 * 
 * List should contain 
 * 15 25 35 
 * The list contains 3 string(s), as follows: 
 * 15 25 35 
 * Is List empty? false 
 * Add 19 at position 1: 
 * Add 39 at position 3: 
 * Add 29 at position 2: 
 * Add 55 at position 7: 
 * Add 65 at position 8:
 * 
 * 
 * List should contain 
 * 19 29 15 39 25 35 55 65 
 * The list contains 8 string(s), as follows:
 * 19 29 15 39 25 35 55 65 
 * Is List empty? false
 * 
 * -------------------------
 * 
 * Testing remove() 
 * Removing 15 at position 3: returns 15 
 * Removing 19 at position 1: returns 19 
 * Removing 65 at position 6: returns 65
 * 
 * 
 * List should contain 
 * 29 39 25 35 55 
 * The list contains 5 string(s), as follows:
 * 29 39 25 35 55
 * 
 * -------------------------
 * 
 * Testing replace() 
 * Replace 29 at position 1 with 92 : returns 29 
 * Replace 39 at position 2 with 93 : returns 39 
 * Replace 25 at position 3 with 52 : returns 25
 * Replace 35 at position 4 with 53 : returns 35 
 * Replace 55 at position 5 with 50 : returns 55
 * 
 * 
 * List should contain 
 * 92 93 52 53 50 
 * The list contains 5 string(s), as follows:
 * 92 93 52 53 50 
 * Is List empty? false
 * 
 * -------------------------
 * 
 * Testing getEntry()
 * 
 * The list contains 5 entries, as follows: 
 * 92 is entry 1 
 * 93 is entry 2 
 * 52 is entry 3 
 * 53 is entry 4 
 * 50 is entry 5
 * 
 * 
 * -------------------------
 * 
 * Testing contains() [results should be TRUE] 
 * List contains 92: true 
 * List contains 52: true 
 * List contains 53: true 
 * List contains 50: true
 * 
 * 
 * Testing contains() [results should be FALSE] 
 * List contains 91 returns : false
 * List contains 55 returns : false 
 * List contains 4  returns : false 
 * List contains 12 returns : false
 * 
 * 
 * Done.
 */
