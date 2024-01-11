package dat102.f02.comparable;

/*
 * Denne "main"-klassen viser hvordan compareTo kan brukes
 * for eksisterende klasser som implementerer Comparable.
 */
public class CompareToMain {
	
	public static void main(String[] args) {
		
		//String
		String arne = "Arne";
		String knut = "Knut";
		System.out.println("arne.compareTo(knut) = " + arne.compareTo(knut));
		System.out.println("knut.compareTo(arne) = " + knut.compareTo(arne));
		System.out.println("arne.compareTo(arne) = " + arne.compareTo(arne));

		//Hva med æøåÆØÅ?
		System.out.println();
		
		//Integer
		Integer tre = 3;
		Integer fire = 4;
		Integer fem = 5;
		System.out.println("tre.compareTo(fem) = " + tre.compareTo(fem));
		System.out.println("fem.compareTo(tre) = " + fem.compareTo(tre));
		System.out.println("fem.compareTo(fire) = " + fem.compareTo(fire));
		System.out.println("fem.compareTo(fem) = " + fem.compareTo(fem));
	}

}
