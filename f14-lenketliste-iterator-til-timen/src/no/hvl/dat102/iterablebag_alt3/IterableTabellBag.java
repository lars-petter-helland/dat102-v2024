package no.hvl.dat102.iterablebag_alt3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class IterableTabellBag<T> extends TabellBag<T> implements IterableBagADT<T> {
	
	/* ------------------------------------------------------------------- */

	private class TabellBagIterator implements Iterator<T> {
		
		private int nesteIndeks = 0;

		@Override
		public boolean hasNext() {
			return nesteIndeks < antall;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException(
						"Ulovlig å kalle next() hvis iterator.!hasNext().");
			}
			return tabell[nesteIndeks++];
		}
	}
	
	/* ------------------------------------------------------------------- */
	
	@Override
	public Iterator<T> iterator() {
		return new TabellBagIterator();
	}
	
	/* ------------------------------------------------------------------- */
}
