package no.hvl.dat102.lenketkoe;

import no.hvl.dat102.koeadt.EmptyQueueException;
import no.hvl.dat102.koeadt.KoeADT;

/**
 * A class that implements a queue of objects by using a chain of linked nodes
 * that has both head and tail references.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 * 
 * Fikset littegrann av Lars-Petter Helland, februar 2024
 */

public final class LenketKoe<T> implements KoeADT<T> {
	
/* -------------------------------------------------------------- */
	
	private class Node {
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}
/* -------------------------------------------------------------- */
	
	private Node fremsteNode; 	// References node at front of queue
	private Node bakersteNode;  // References node at back of queue

	public LenketKoe() {
		//TODO
	}

	@Override
	public void enqueue(T newEntry) {
		//TODO
	}

	@Override
	public T getFront() {
		//TODO
		return null;
	}

	@Override
	public T dequeue() {
		//TODO
		return null;
	}

	@Override
	public boolean isEmpty() {
		//TODO
		return false;
	}

	@Override
	public void clear() {
		//TODO
	}
}
