package no.hvl.dat102.tabellstabel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TabellStabelTest {
	
	private StabelADT<String> stabel0; //Tenker at denne er en tom stabel
	private StabelADT<String> stabel1; //Tenker at denne er en stabel med ett element
	private StabelADT<String> stabel2; //Tenker at denne er en stabel med to elementer

	@BeforeEach
	void nullstill() {
		//TODO
	}
	
	/*
	 * Ting å teste (vi har konstruktør, isEmpty, push, peek, pop, clear):
	 * 
	 * - En ny stabel skal være tom
	 * - En stabel med ett eller to element(er) skal ikke være tom
	 * - push skal legge elementet på toppen av stabelen
	 * - peek på en tom stabel skal gi EmptyStackException
	 * - peek på en ikke-tom stabel skal returnere topp-elementet (siste push)
	 * - peek på en ikke-tom stabel skal ikke endre på stabelens innhold
	 * - pop på en tom stabel skal gi EmptyStackException
	 * - pop på en ikke-tom stabel skal fjerne og returnere topp-elementet
	 * - clear skal tømme stabelen
	 */
	
	@Test
	void enNyStabelSkalVaereTom() {
		//TODO
	}
	
	@Test
	void enStabelMedEttEllerFlereElementerSkalIkkeVaereTom() {
		//TODO
	}
	
	@Test
	void pushSkalLeggeElementetPaaToppenAvStabelen() {
		//TODO
	}
	
	@Test
	void peekPaaTomStabelSkalGiEmptyStackException() {
		//TODO
	}
	
	@Test
	void peekPaaIkkeTomStabelSkalReturnereToppelementet() {
		//TODO
	}
	
	@Test
	void peekPaaIkkeTomStabelSkalIkkeEndreStabelensInnhold() {
		//TODO
	}
	
	@Test
	void popPaaTomStabelSkalGiEmptyStackException() {
		//TODO
	}
	
	@Test
	void popPaaIkkeTomStabelSkalFjerneOgReturnereToppelementet() {
		//TODO
	}
	
	@Test
	void clearSkalTommeStabelen() {
		//TODO
	}
}
