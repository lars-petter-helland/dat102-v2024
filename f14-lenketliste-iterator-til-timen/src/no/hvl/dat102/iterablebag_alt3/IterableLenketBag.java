package no.hvl.dat102.iterablebag_alt3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableLenketBag<T> extends LenketBag<T> implements IterableBagADT<T> {
	
	/* ------------------------------------------------------------------- */

	private class LenketBagIterator implements Iterator<T> {
		
		Node nesteNode = forste;
		
		@Override
		public boolean hasNext() {
			return nesteNode != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException(
						"Ulovlig å kalle next() hvis iterator.!hasNext().");
			}
			T data = nesteNode.data;
			nesteNode = nesteNode.neste;
			return data;
		}
	}
	
	/* ------------------------------------------------------------------- */

	@Override
	public Iterator<T> iterator() {
		return new LenketBagIterator();
	}

	/* ------------------------------------------------------------------- */
}
