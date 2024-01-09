package dat102.f01.ordnetpar.utengenerics;

public class OrdnetParMain {
	
	public static void main(String[] args) {
		
		OrdnetPar arneOgNils = new OrdnetParImpl(17, "Per");
		System.out.println(arneOgNils);
		
		arneOgNils.byttOm();
		System.out.println(arneOgNils);
		
		String forste = (String) arneOgNils.forste();
		System.out.println(forste.length());
	}

}
