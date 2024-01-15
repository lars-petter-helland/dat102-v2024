package dat102.f02.tabellbag;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TabellBagTest {

	@Test
	void test() {
		
		//Lager en liten bag med plass til 2 ting
		BagADT<String> bag = new TabellBag<>(2);
		
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
		
		//Prøver å legge til Espen, men bagen er full, så det skal ikke gå bra.
		leggeTilOk = bag.add("Espen");
//		assertFalse(leggeTilOk);
//		assertEquals(2, bag.getCurrentSize());
		
		//Nei. Har jo fikset ved å kopiere over i en ny tabell.
		assertTrue(leggeTilOk);
		assertEquals(3, bag.getCurrentSize());
		
		//Sjekke om søk virker
		assertTrue(bag.contains("Per"));
		assertFalse(bag.contains("Anne"));

		//Tømmer bagen. Nå skal den være tom.
//		bag.clear();
//		assertEquals(0, bag.getCurrentSize());
//		assertTrue(bag.isEmpty());
		
		//Skal sjekke sletting. Før sletting inneholder nå bagen
		// t[0]=Per t[1]=Pål t[2]=Espen
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
		
		

	}

}
