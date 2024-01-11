package dat102.f02.tabellbag;

import java.util.Arrays;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class TabellBag<T> implements BagADT<T>{

	private static final int DEFAULT_KAPASITET = 10;

	private T[] tabell;
	private int antall;

	/************************************************************/

	public TabellBag() {
		this(DEFAULT_KAPASITET);
	}

	@SuppressWarnings("unchecked")
	public TabellBag(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}

	@Override
	public int getCurrentSize() {
		return antall;
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public boolean add(T newEntry) {
		if (antall == tabell.length) {
			return false;
		}
		tabell[antall] = newEntry;
		antall++;
		return true;
	}

	@Override
	public T remove() {
		if (antall > 0) {
			//Fjerner siste. Slipper å tette hull.
			T element = tabell[antall - 1];
			antall--;
			return element;
		}
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		int length = tabell.length;
		tabell = (T[]) new Object[length];
		antall = 0;
	}
	
//  Alternativt, og kanskje bedre ...
//	@Override
//	public void clear() {
//		while (!isEmpty()) {
//			remove();
//		}
//		antall = 0;
//	}


	@Override
	public int getFrequencyOf(T anEntry) {
		int frekvens = 0;
		for (int i = 0; i < antall; i++) {
			if (anEntry.equals(tabell[i])) {
				frekvens++;
			}
		}
		return frekvens;
	}

	@Override
	public boolean contains(T anEntry) {
		// ... bag.contains("Per");
		for(int i=0; i<antall; i++) {
			T element = tabell[i];
			if (element.equals(anEntry)) {
				return true;
			}
		}
		return false;
	}
//  Alternativt, hvis getFrequencyOf allerede er laget ...
//	@Override
//	public boolean contains(T anEntry) {
//		return getFrequencyOf(anEntry) > 0;
//	}
	
	@Override
	public T[] toArray() {
		return Arrays.copyOf(tabell, antall);
	}

	/************************************************************/

}
