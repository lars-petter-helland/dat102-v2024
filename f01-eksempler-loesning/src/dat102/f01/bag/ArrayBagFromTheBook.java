package dat102.f01.bag;

import java.util.Arrays;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 * 
 * @author Frank M. Carrano, Timothy M. Henry
 * @version 5.1
 */
public final class ArrayBagFromTheBook<T> implements BagADT<T> {

	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	private final T[] bag;
	private int numberOfEntries;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBagFromTheBook() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Creates an empty bag having a given capacity.
	 * 
	 * @param desiredCapacity The integer capacity desired.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBagFromTheBook(int desiredCapacity) {

		if (desiredCapacity <= MAX_CAPACITY) {
			bag = (T[]) new Object[desiredCapacity];
			numberOfEntries = 0;

		} else
			throw new IllegalStateException("Attempt to create a bag " + "whose capacity exceeds allowed maximum.");
	}

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) {

		if (isArrayFull()) {
			return false;

		} else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}
	}

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() {
		return Arrays.copyOf(bag, numberOfEntries);
	}

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if this bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Gets the current number of entries in this bag.
	 * 
	 * @return The integer number of entries currently in this bag.
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in this bag.
	 */
	public int getFrequencyOf(T anEntry) {

		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry The entry to locate.
	 * @return True if this bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry) {
		return getIndexOf(anEntry) > -1;
	}

	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	}

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	public T remove() {
		return removeEntry(numberOfEntries - 1);
	} 

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * 
	 * @param anEntry The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean remove(T anEntry) {
		
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	/* 
	 * Returns true if the array bag is full, or false if not.
	 */
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}

	/*
	 * Locates a given entry within the array bag.
	 * Returns the index of the entry, if located,
	 * or -1 otherwise.
	 */
	private int getIndexOf(T anEntry) {
		
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				found = true;
				where = index;
			}
			index++;
		}
		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array.

		return where;
	}

	/*
	 * Removes and returns the entry at a given index within the array.
	 * If no such entry exists, returns null.
	 * Precondition: 0 <= givenIndex < numberOfEntries.
	 */
	private T removeEntry(int givenIndex) {
		T result = null;

		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex]; // Entry to remove
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex]; // Replace entry to remove with last entry
			bag[lastIndex] = null; // Remove reference to last entry
			numberOfEntries--;
		}

		return result;
	}
}
