package dat102.f01.figurer;

public class FigurerMain {
	
	public static void main(String[] args) {
		
		Figur2d kvadrat = new Kvadrat(5.0);
		Figur2d sirkel = new Sirkel(1.0);
		
		System.out.println("En sirkel med radius = 1.0 har");
		System.out.println("   et areal på " + sirkel.areal());
		System.out.println("   og en omkrets på " + sirkel.omkrets());
	
		Figur2d[] figurer = new Figur2d[3];
		figurer[0] = kvadrat;
		figurer[1] = sirkel;
		//figurer[2] vil da være null
		
		System.out.println("Tabell av 2D-figurer");
		for (Figur2d figur : figurer) {
			if (figur != null) {
				System.out.println("   a = " + figur.areal());
			}
		}
	}

}
