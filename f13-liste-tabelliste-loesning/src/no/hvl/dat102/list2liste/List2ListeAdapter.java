package no.hvl.dat102.list2liste;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat102.listeadt.ListeADT;

public class List2ListeAdapter<T> implements ListeADT<T> {
	
	List<T> list = new ArrayList<>();

	@Override
	public void add(T newEntry) {
		list.add(newEntry);
	}

	@Override
	public void add(int newPosition, T newEntry) {
		list.add(newPosition, newEntry);
	}

	@Override
	public T remove(int givenPosition) {
		return list.remove(givenPosition);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		return list.set(givenPosition, newEntry);
	}

	@Override
	public T getEntry(int givenPosition) {
		return list.get(givenPosition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) list.toArray();
	}

	@Override
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	}

	@Override
	public int getLength() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
