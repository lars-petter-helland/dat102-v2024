package dat102.f03.lenketbag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LenketBagTest {

	@Test
	void test() {
		
		//Lager en bag - LenketBag har ingen begrensning / størrelse
		BagADT<String> bag = new LenketBag<>();
		
		//Sjekker at den er tom
		assertEquals(0, bag.getCurrentSize());
		assertTrue(bag.getCurrentSize() == 0);
		assertTrue(bag.isEmpty());
		
		//Legge til Per skal være OK
		boolean leggeTilOk = bag.add("Per");
		assertTrue(leggeTilOk);
		
		//Legge til Pål skal være OK
		leggeTilOk = bag.add("Pål");
		assertTrue(leggeTilOk);
		
		//Nå skal det være 2 ting i bagen, og den skal ikke være tom
		assertEquals(2, bag.getCurrentSize());
		assertFalse(bag.isEmpty());
		
		//Legge til Espen skal være OK
		leggeTilOk = bag.add("Espen");
		assertTrue(leggeTilOk);
		assertEquals(3, bag.getCurrentSize());
		
		//Sjekke om søk virker
		assertTrue(bag.contains("Per"));
		assertFalse(bag.contains("Anne"));
		
		//Skal sjekke sletting. Før sletting inneholder nå bagen
		// Per --> Pål --> Espen
		bag.remove("Pål");
		assertTrue(bag.contains("Per"));
		assertFalse(bag.contains("Pål"));
		assertTrue(bag.contains("Espen"));

		bag.remove("Espen");
		assertTrue(bag.contains("Per"));
		assertFalse(bag.contains("Pål"));
		assertFalse(bag.contains("Espen"));
		
		bag.remove("Per");
		assertFalse(bag.contains("Per"));
		assertFalse(bag.contains("Pål"));
		assertFalse(bag.contains("Espen"));
		
		assertTrue(bag.isEmpty());
		
		//Tømmer bagen. Nå skal den være tom.
		bag.clear();
		assertEquals(0, bag.getCurrentSize());
		assertTrue(bag.isEmpty());

	}

}
