package no.hvl.dat102.diversekoer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adter.EmptyQueueException;
import no.hvl.dat102.adter.KoeADT;

/*
 * JUnit 5 User Guide
 * https://junit.org/junit5/docs/snapshot/user-guide/
 * 
 * § 2.3 Test Classes and Methods
 * 
 * Class and method visibility
 * ---------------------------
 * ... It is generally recommended to omit the public modifier for 
 * test classes, test methods, and lifecycle methods unless there 
 * is a technical reason for doing so ...
 */

abstract class AbstractKoeADTTest {
	
	private KoeADT<Integer> tomKoeMedPlassTil3;
	private KoeADT<Integer> koeMedEttElement;
	private KoeADT<Integer> fullKoeMedPlassTil3;
	
	abstract KoeADT<Integer> opprettNyKoe();
	
	@BeforeEach
	void nullstill() {
		
		tomKoeMedPlassTil3 = opprettNyKoe();
		
		koeMedEttElement = opprettNyKoe();
		koeMedEttElement.enqueue(65);
		
		fullKoeMedPlassTil3 = opprettNyKoe();
		
		fullKoeMedPlassTil3.enqueue(1);
		fullKoeMedPlassTil3.enqueue(2);
		fullKoeMedPlassTil3.enqueue(3);
	}
	
	@Test
	void info() {
		System.out.println(this.getClass().getSimpleName());
		System.out.println("   " + tomKoeMedPlassTil3.getClass().getSimpleName() + "<Integer> tomKoeMedPlassTil3");
		System.out.println("   " + koeMedEttElement.getClass().getSimpleName() + "<Integer> koeMedEttElement");
		System.out.println("   " + fullKoeMedPlassTil3.getClass().getSimpleName() + "<Integer> fullKoeMedPlassTil3");
	}
	
	/*
	 * Ting å teste (vi har konstruktører, isEmpty, enqueue, getFront, dequeue og clear):
	 * 
	 * - En ny kø skal være tom
	 * - En kø med ett eller to element(er) skal ikke være tom
	 * - enqueue skal legge elementet bakerst i køen
	 * - getFront på en tom kø skal gi EmptyQueueException
	 * - getFront på en ikke-tom kø skal returnere det fremste elementet (første enqueue)
	 * - getFront på en ikke-tom kø skal ikke endre på køens innhold
	 * - dequeue på en tom kø skal gi EmptyQueueException
	 * - dequeue på en ikke-tom kø skal fjerne og returnere topp-elementet
	 * - dequeue på en kø med ett element resultere i en tom kø
	 * - clear skal tømme køen
	 * 
	 * Spesielt for sirkulær tabell-kø:
	 * - For å sikre at kapasitetsutvidelse, at modulus-inkrement, og
	 *   tom og full kø virker, bør det gjøres en del tester rundt dette.
	 */
	
	@Test
	void enNyKoeSkalVaereTom() {
		assertTrue(tomKoeMedPlassTil3.isEmpty());
	}
	
	@Test
	void enKoeMedEttEllerFlereElementerSkalIkkeVaereTom() {
		assertFalse(koeMedEttElement.isEmpty());
		assertFalse(fullKoeMedPlassTil3.isEmpty());
	}
	
	@Test
	void enqueueSkalLeggeElementetBakerstIKoen() {
		
		tomKoeMedPlassTil3.enqueue(10);
		assertEquals(10, tomKoeMedPlassTil3.getFront());
		
		koeMedEttElement.enqueue(66);
		assertEquals(65, koeMedEttElement.dequeue());
		assertEquals(66, koeMedEttElement.getFront());
		
		fullKoeMedPlassTil3.enqueue(4);
		assertEquals(1, fullKoeMedPlassTil3.dequeue());
		assertEquals(2, fullKoeMedPlassTil3.dequeue());
		assertEquals(3, fullKoeMedPlassTil3.dequeue());
		assertEquals(4, fullKoeMedPlassTil3.dequeue());
		assertTrue(fullKoeMedPlassTil3.isEmpty());
	}
	
	@Test
	void getFrontPaaTomKoeSkalGiEmptyQueueException() {
		assertThrows(EmptyQueueException.class, () -> tomKoeMedPlassTil3.getFront());
	}
	
	@Test
	void getFrontPaaIkkeTomKoeSkalReturnereFremsteElement() {
		assertEquals(65, koeMedEttElement.getFront());
		assertEquals(1, fullKoeMedPlassTil3.getFront());
	}
	
	@Test
	void getFrontSkalIkkeEndreKoensInnhold() {
		assertEquals(65, koeMedEttElement.getFront());
		assertEquals(65, koeMedEttElement.getFront());
		assertEquals(1, fullKoeMedPlassTil3.getFront());
		assertEquals(1, fullKoeMedPlassTil3.getFront());
	}
	
	@Test
	void dequeuePaaTomKoeSkalGiEmptyQueueException() {
		assertThrows(EmptyQueueException.class, () -> tomKoeMedPlassTil3.dequeue());
	}
	
	@Test
	void dequeuePaaIkkeTomKoeSkalFjerneOgReturnereFremsteElement() {
		assertEquals(1, fullKoeMedPlassTil3.dequeue());
		assertEquals(2, fullKoeMedPlassTil3.dequeue());
		assertEquals(3, fullKoeMedPlassTil3.dequeue());
	}
	
	@Test
	void dequeuePaaKoeMedEttElementSkalGiTomKoe() {
		assertEquals(65, koeMedEttElement.dequeue());
		assertTrue(koeMedEttElement.isEmpty());
	}
	
	@Test
	void clearSkalTommeKoen() {
		koeMedEttElement.clear();
		assertTrue(koeMedEttElement.isEmpty());
		fullKoeMedPlassTil3.clear();
		assertTrue(fullKoeMedPlassTil3.isEmpty());
	}

	@Test
	void leggeTilOgSletteEnRekkeElementerSkalVirkeFint() {
		
		KoeADT<Integer> k = tomKoeMedPlassTil3; //Ville ha et kortere variablenavn :)

		// Legger til tallene 1..6 i køen
		for (int i = 1; i <= 6; i++) { k.enqueue(i); }
//		System.out.println(k);
		assertEquals(1,  k.getFront());
		
		// Fjerner tallene 1..5
		for (int i = 1; i <= 5; i++) { k.dequeue(); }
//		System.out.println(k);
		assertEquals(6, k.getFront());
		
		// Legger til tallene 7..10  
		for (int i = 7; i <= 10; i++) { k.enqueue(i); }
//		System.out.println(k);
		assertEquals(6, k.getFront());
		
		// Fjerner 5 tall. Nå skal køen være tom.
		for (int i = 1; i <= 5; i++) { k.dequeue();	}
//		System.out.println(k);
		assertTrue(k.isEmpty());
	}
}
