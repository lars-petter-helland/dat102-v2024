package dat102.f01.ordnetpar.utengenerics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdnetParJUnitTest {

	@Test
	void test() {
		
		OrdnetPar treOgTo = new OrdnetParImpl(3, 2);
		
		assertEquals(3, treOgTo.forste());
		assertEquals(2, treOgTo.andre());
		
		treOgTo.byttOm();
		
		assertEquals(2, treOgTo.forste());
		assertEquals(3, treOgTo.andre());

	}

}
