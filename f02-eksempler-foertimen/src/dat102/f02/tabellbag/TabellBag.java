package dat102.f02.tabellbag;

import java.util.Arrays;

/**
 * En implementasjon av BagADT
 * 
 * @author Lars-Petter Helland
 */
public class TabellBag<T> {

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

}
