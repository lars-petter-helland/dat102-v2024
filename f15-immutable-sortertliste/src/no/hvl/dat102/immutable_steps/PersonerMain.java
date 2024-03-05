package no.hvl.dat102.immutable_steps;

/*
 * Demonstrerer ikke-mutérbarhet (en. immutability) ...
 * 
 * Creating an Immutable Class in Java:
 * 	1 - Make all of the fields private so that direct access is not allowed.
 * 	2 - Don't provide setter methods for variables.
 * 	3 - Make all mutable fields final so that a field's value can be assigned only once.
 * 	4 - Declare the class as final so it can't be extended.
 * 
 * Både boken og artikler på nettet sier dette, men selv med private final Navn navn
 * kan man gjøre navn.setEtternavn("...");
 * 
 * En annen artikkel sier i tillegg:
 *  5 - Deep Copy of objects should be performed in the getter methods to return a 
 *    copy rather than returning the actual object reference.
 *  6 - A parameterized constructor should initialize all the fields performing a 
 *    deep copy so that data members can’t be modified with an object reference.
 *    
 * Vi har altså 6 ting som må gjøres for å gjøre et objekt immutable.
 * 
 */
public class PersonerMain {
	
	public static void main(String[] args) {
		
		Navn atlePatle = new Navn("Atle", "Patle");
		Navn perViskeler = new Navn("Per", "Viskeler");
		Navn madamFelle = new Navn("Madam", "Felle");
		
		//Enkelt å mutere p0 pga. public objektvariabler
		Person0 p0 = new Person0(atlePatle, 2000);
		p0.navn = perViskeler;
		p0.fodselsaar = 1990;
		System.out.println(p0);

		//Enkelt å mutere p1 pga. set-metoder
		Person1 p1 = new Person1(atlePatle, 2000);
		p1.setNavn(perViskeler);
		p1.setFodselsaar(1990);
		System.out.println(p1);
		
		//Ikke så enkelt å mutere p2, p3 og p4 siden vi har fjernet set-metodene
		//Men det er likevel mulig:
		Person4 p4 = new Person4(atlePatle, 2000);
		Navn p4SittNavn = p4.getNavn();
		p4SittNavn.setEtternavn("Endresen");
		System.out.println(p4);
		
		//Hvis vi lar getNavn() returnere en kopi, tetter vi det hullet
		//Men det er likevel mulig:
		Person5 p5 = new Person5(perViskeler, 2000);
		perViskeler.setEtternavn("Endresen");
		System.out.println(p5);
//		
//		//Hvis vi lar konstuktøren lage en kopi, tetter vi det hullet
//		Person6 p6 = new Person6(madamFelle, 1831);
//		madamFelle.setFornavn("Oline");
//		System.out.println(p6);
	}

}
