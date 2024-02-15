package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.KoeADT;

class SirkulaerKoeTest extends AbstractKoeADTTest {

	@Override
	KoeADT<Integer> opprettNyKoe() {
		return new SirkulaerKoe<Integer>(3);
	}
}
