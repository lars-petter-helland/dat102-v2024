package dat102.f01.figurer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FigurerJUnitTest {
	
	@Test
	public void testKvadrat() {
		
		Figur2d kvadrat = new Kvadrat(5.0);
		assertEquals(25.0, kvadrat.areal());
		assertEquals(20.0, kvadrat.omkrets());
	}
}


