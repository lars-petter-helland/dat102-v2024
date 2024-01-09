package dat102.f01.ordnetpar;

public class OrdnetParMain {
	
	public static void main(String[] args) {
		
		OrdnetPar<Integer> treOgTo = new OrdnetParImpl<>(3, 2);
		System.out.println(treOgTo);
		
		treOgTo.byttOm();
		System.out.println(treOgTo);
		
		OrdnetPar<String> perOgPal = new OrdnetParImpl<>("Per", "Pål");
		perOgPal.byttOm();
		System.out.println(perOgPal);
	}

}

