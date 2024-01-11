package dat102.f02.comparable;

/*
 * Denne "main"-klassen viser hvordan compareTo kan brukes
 * for egenutviklet klasser Student som implementerer Comparable.
 */
public class StudentMain {
	
	public static void main(String[] args) {
		
		Student student123 = new Student(123, "Arne");
		Student student456 = new Student(456, "Knut");
		
		System.out.println("123 compareTo 456 = " + student123.compareTo(student456));
		
		//Skrive ut studentene i stigende rekkefølge
		int sammenlign123og456 = student123.compareTo(student456);
		if (sammenlign123og456 < 0) { //dvs. 123 er minst
			System.out.println(student123);
			System.out.println(student456);
		} else {
			System.out.println(student456);
			System.out.println(student123);
		}
	}

}
