package no.hvl.dat102.diversekoer;

import no.hvl.dat102.adter.KoeADT;

class LenketKoeTest extends AbstractKoeADTTest {

	@Override
	KoeADT<Integer> opprettNyKoe() {
		return new LenketKoe<Integer>();
	}
}
