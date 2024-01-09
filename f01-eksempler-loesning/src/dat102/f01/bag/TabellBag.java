package dat102.f01.bag;

import java.util.Arrays;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class TabellBag<T> implements BagADT<T> {

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

	/************************************************************/

	@Override
	public int getCurrentSize() {
		return antall;
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
		antall = 0;
	}

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
		return getFrequencyOf(anEntry) > 0;
	}

	@Override
	public T[] toArray() {
		return Arrays.copyOf(tabell, antall);
	}

	@Override
	public boolean add(T newEntry) {

		if (antall >= tabell.length) {
			return false;
		}

		tabell[antall++] = newEntry;
		return true;
	}

	@Override
	public T remove() {
		if (antall > 0) {
			T element = tabell[antall - 1];
			antall--;
			return element;
		}
		return null;
	}

	@Override
	public boolean remove(T anEntry) {

		// 1. Finne ut hvor et element lik anEntry ligger
		//    Kanskje dette bør være en hjelpemetode
		int funnetIndeks = -1;
		int i = 0;
		while (i < antall && funnetIndeks == -1) {
			if (anEntry.equals(tabell[i])) {
				funnetIndeks = i;
			}
			i++;
		}

		// 2. Hvis ikke funnet, returner false
		if (funnetIndeks == -1) {
			return false;
		}

		// 3. Fjerner den på funnetIndeks ved å sette siste inn i hullet
		tabell[funnetIndeks] = tabell[antall - 1];
		tabell[antall - 1] = null;
		antall--;

		return true;
	}
}
