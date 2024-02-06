package dat102.f05.stabel.lenketstabel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dat102.f05.stabel.StabelADT;

class LenketStabelTest {
	
	StabelADT<Integer> stabel1 = new LenketStabel<>();
	
	@BeforeEach
	void nullstill() {
		stabel1.clear();
	}
	
	@Test 
	void littPushOgPop() {
		
		stabel1.push(14);
		stabel1.push(15);
		stabel1.push(16);
		
		assertEquals(16, stabel1.pop());
		assertEquals(15, stabel1.pop());
		assertEquals(14, stabel1.pop());
		
		assertTrue(stabel1.isEmpty());
	}

	@Test
	void testDiversePaaTomStabel() {
		
		// push, peek, pop, isEmpty, clear
		assertTrue(stabel1.isEmpty());
		
		stabel1.push(14);
		assertFalse(stabel1.isEmpty());
		assertEquals(14, stabel1.peek());
		assertEquals(14, stabel1.pop());
	}
	
	@Test
	void testPeekOgPopPaaTomStabel() {
		
		try {
			stabel1.peek();
			fail("peek på tom stabel skal kaste EmptyStackException");
		} catch (EmptyStackException e) {
		}
		
	}

}







