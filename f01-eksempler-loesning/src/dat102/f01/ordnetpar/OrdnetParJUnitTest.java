package dat102.f01.ordnetpar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdnetParJUnitTest {

	@Test
	void test() {
		
		OrdnetPar<String> perOgPal = new OrdnetParImpl<>("Per", "Pål");
		
		assertEquals("Per", perOgPal.forste());
		assertEquals("Pål", perOgPal.andre());
		
		perOgPal.byttOm();
		
		assertEquals("Pål", perOgPal.forste());
		assertEquals("Per", perOgPal.andre());
	}

}
