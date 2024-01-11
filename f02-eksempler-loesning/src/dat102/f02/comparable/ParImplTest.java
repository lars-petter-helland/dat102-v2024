package dat102.f02.comparable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParImplTest {

	@Test
	void test() {
		
		Par<String> perOgPal = new ParImpl<>("Per", "Pål");
		
		assertEquals("Per", perOgPal.minste());
		assertEquals("Pål", perOgPal.storste());
	}

}
