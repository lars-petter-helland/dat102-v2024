package dat102.f06.rekursivlenketbag;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Tester ut ny implementasjon av LenketBag der vi prøver oss 
 * med rekursjon i stedet for løkke i noen av metodene.
 * 
 * Metoder som er påvirket av omskriving  med rekursjon er:
 *  
 * - public boolean remove(T anEntry), som bruker private Node finnNode(T entry)
 * - public	int getFrequencyOf(T anEntry)
 * - public	void skrivUt(), ikke så lett å teste med JUnit.
 * 
 * Skrevet av Lars-Petter Helland, 23. januar 2024
 */
class LenketBagTest {
	
	BagADT<String> tomBag;
	BagADT<String> fruktBag;
	
	@BeforeEach
	void oppsettSomGjenbrukesIHverTest() {
		
		tomBag = new LenketBagRekursiv<>();
		fruktBag = new LenketBagRekursiv<>();
		
		fruktBag.add("eple");
		fruktBag.add("pære");
		fruktBag.add("eple");
		fruktBag.add("banan");
		fruktBag.add("eple");
	}

	@Test
	void testFindAndRemoveAnEntry() {
		
		//Fjerne fra tom bag? Nei
		assertFalse(tomBag.remove("noe"));
		
		//Før vi gjør noe
		assertTrue(fruktBag.contains("banan"));
		
		//Fjerning av den ene bananen vi har
		assertTrue(fruktBag.remove("banan"));
		assertFalse(fruktBag.contains("banan"));
		
		//Ingen av disse finnes i bag
		assertFalse(fruktBag.remove("banan"));
		assertFalse(fruktBag.remove("appelsin"));
		
		//3 epler og 1 pære igjen i bag
		assertEquals(4, fruktBag.getCurrentSize());
	}
	
	@Test
	void testGetFrequencyOf() {
		
		assertEquals(0, tomBag.getFrequencyOf("eple"));
		
		assertEquals(3, fruktBag.getFrequencyOf("eple"));
		assertEquals(1, fruktBag.getFrequencyOf("pære"));
		assertEquals(0, fruktBag.getFrequencyOf("mango"));
	}

	//---------------------------------------------------------------
	
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
	
}
