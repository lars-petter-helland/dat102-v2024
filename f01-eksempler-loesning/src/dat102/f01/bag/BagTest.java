package dat102.f01.bag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BagTest {
	
	BagADT<String> newEmptyBag;
	BagADT<String> perPerPaalBag;

	@BeforeEach
	void nullstill() {
		newEmptyBag = new TabellBag<>(3);
		
		perPerPaalBag = new TabellBag<>(3);
		perPerPaalBag.add("Per");
		perPerPaalBag.add("Per");
		perPerPaalBag.add("Pål");
	}
	
	@Test
	void aNewBag() {
		assertEquals(0, newEmptyBag.getCurrentSize());
		assertTrue(newEmptyBag.isEmpty());
		assertEquals(0, newEmptyBag.getFrequencyOf("Per"));
		assertFalse(newEmptyBag.contains("Per"));
	}
	
	@Test
	void addingSomeElementsToBag() {
		
		assertEquals(3, perPerPaalBag.getCurrentSize());
		assertFalse(perPerPaalBag.isEmpty());
		assertEquals(2, perPerPaalBag.getFrequencyOf("Per"));
		assertEquals(1, perPerPaalBag.getFrequencyOf("Pål"));
		assertEquals(0, perPerPaalBag.getFrequencyOf("Espen"));
		assertTrue(perPerPaalBag.contains("Per"));
		assertTrue(perPerPaalBag.contains("Pål"));
		assertFalse(perPerPaalBag.contains("Espen"));
	}

	@Test
	void addingOnTooManyToBag() {
		assertTrue(newEmptyBag.add("Per"));
		assertTrue(newEmptyBag.add("Pål"));
		assertTrue(newEmptyBag.add("Espen"));
		assertFalse(newEmptyBag.add("Anne"));
		
		assertEquals(3, newEmptyBag.getCurrentSize());
		assertTrue(newEmptyBag.contains("Espen"));
		assertFalse(newEmptyBag.contains("Anne"));
	}

	@Test
	void clearingTheBag() {
		
		perPerPaalBag.clear();
		
		assertEquals(0, perPerPaalBag.getCurrentSize());
		assertTrue(perPerPaalBag.isEmpty());
		
		assertFalse(perPerPaalBag.contains("Per"));
	}
	
	@Test
	void removingElementsFromBag() {
		
	}

}
