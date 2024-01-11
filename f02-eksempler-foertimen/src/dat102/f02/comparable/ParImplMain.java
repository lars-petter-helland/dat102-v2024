package dat102.f02.comparable;

public class ParImplMain {
	
	public static void main(String[] args) {
		
		Par<Integer> treOgTo = new ParImpl<>(3, 2);
		System.out.println(treOgTo);
		System.out.println("Minste tall er " + treOgTo.minste());
		System.out.println("Største tall er " + treOgTo.storste());
		
		Par<String> perOgPal = new ParImpl<>("Per", "Pål");
		System.out.println(perOgPal);
		System.out.println("Minste navn er " + perOgPal.minste());
		System.out.println("Største navn er " + perOgPal.storste());
		
		Student anne = new Student(345678, "Anne");
		Student knut = new Student(123456, "Knut");
		Par<Student> gruppe1 = new ParImpl<>(anne, knut);
		System.out.println(gruppe1);
		System.out.println("'Minste' student er " + gruppe1.minste());
		System.out.println("'Største' student er " + gruppe1.storste());
	}

}

