package dat102.f03.lenketbag;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LenketBagBedreTest {
	
	/*
	 * Denne test-klassen viser en bedre måte å bruke JUnit enn det jeg viste
	 * i de første eksemplene.
	 * 
	 * JUnit bør egentlig kun teste én metode / ett eksempel i hver testmetode,
	 * 
	 * og testmetodene bør kunne kjøres uavhengig av hverandre i tilfeldig
	 * rekkefølge med samme resultat.
	 * 
	 * Det er også vanlig å sette opp et par eksempler som gjenbrukes i alle 
	 * testene. 
	 */
	
	BagADT<String> tomBag;
	BagADT<String> fruktBag;
	
	@BeforeEach
	void oppsettSomGjenbrukesIHverTest() {
		
		tomBag = new LenketBag<>();
		
		fruktBag = new LenketBag<>();
		fruktBag.add("eple");
		fruktBag.add("pære");
		fruktBag.add("eple");
		fruktBag.add("banan");
		fruktBag.add("eple");
	}
	
	@Test
	void testGetCurrentSize() {
		assertEquals(0, tomBag.getCurrentSize());
		assertEquals(5, fruktBag.getCurrentSize());
	}

	@Test
	void testIsEmpty() {
		assertTrue(tomBag.isEmpty());
		assertFalse(fruktBag.isEmpty());
	}
	
	@Test
	void testContains() {
		assertFalse(tomBag.contains("eple"));
		assertTrue(fruktBag.contains("eple"));
		assertTrue(fruktBag.contains("pære"));
		assertFalse(fruktBag.contains("mango"));
	}

	@Test
	void testGetFrequencyOf() {
		assertEquals(0, tomBag.getFrequencyOf("eple"));
		assertEquals(3, fruktBag.getFrequencyOf("eple"));
		assertEquals(1, fruktBag.getFrequencyOf("pære"));
		assertEquals(0, fruktBag.getFrequencyOf("mango"));
	}

	@Test
	void testToArray() {
		assertArrayEquals(new String[] 
				{}, tomBag.toArray());

		// Vi kan ikke forvente at elementene i resultat-tabellen kommer i 
		// en gitt rekkefølge. Det kommer an på hvordan bagen er implementert
		// (TabellBag legger nye til bakerst, mensLenketBag legger nye til først.) 
		// Men vi kan gjøre noen indirekte asserts på resultatet.
		
		Object[] fruktTabell = fruktBag.toArray();
		assertEquals(5, fruktTabell.length);
		
		List<Object> fruktListe = Arrays.asList(fruktTabell);
		assertTrue(fruktListe.contains("eple"));
		assertTrue(fruktListe.contains("banan"));
		assertTrue(fruktListe.contains("pære"));
		assertFalse(fruktListe.contains("mango"));
	}
	
	//Da mangler bare test av de to remove-metodene og clear !!
}
