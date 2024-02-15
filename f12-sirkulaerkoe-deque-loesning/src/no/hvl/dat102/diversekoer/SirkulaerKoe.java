package no.hvl.dat102.diversekoer;

import java.util.Arrays;

import no.hvl.dat102.adter.EmptyQueueException;
import no.hvl.dat102.adter.KoeADT;

/**
 * A class that implements the ADT queue by using an expandable circular array
 * with one unused location after the back of the queue.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.1
 * 
 * Fikset littegrann av Lars-Petter Helland, februar 2024
 * 
 */
public final class SirkulaerKoe<T> implements KoeADT<T> {

	private static final int DEFAULT_CAPACITY = 3; // Small capacity for testing

	private T[] queue; // Circular array of queue entries and one unused location
	private int frontIndex; // Index of front entry
	private int backIndex; // Index of back entry

	public SirkulaerKoe() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public SirkulaerKoe(int initialCapacity) {
		queue = (T[]) new Object[initialCapacity + 1];
		frontIndex = 0;
		backIndex = initialCapacity;
	}

	private int plussEnModuloN(int index) {
		return (index + 1) % queue.length;
	}

	@Override
	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex = plussEnModuloN(backIndex);
		queue[backIndex] = newEntry;
	}

	@Override
	public String toString() {
		return "SirkulaerKoe [queue=" + Arrays.toString(queue) 
				+ ", frontIndex=" + frontIndex 
				+ ", backIndex=" + backIndex + "]";
	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		return queue[frontIndex];
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		T front = queue[frontIndex];
		queue[frontIndex] = null;
		frontIndex = plussEnModuloN(frontIndex);
		return front;
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == plussEnModuloN(backIndex);
	}

	@Override
	public void clear() {
		if (!isEmpty()) { // Deallocates only the used portion
			for (int index = frontIndex; index != backIndex; index = plussEnModuloN(index)) {
				queue[index] = null;
			}
			queue[backIndex] = null;
		}
		frontIndex = 0;
		backIndex = queue.length - 1;
	}

	// Doubles the size of the array queue if it is full.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {

		if (isArrayFull()) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			
//			System.out.println("Kapasitet utvides til " + newSize);
			queue = (T[]) new Object[newSize];
			for (int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}

	private boolean isArrayFull() {
		return frontIndex == ((backIndex + 2) % queue.length);
	}
}
