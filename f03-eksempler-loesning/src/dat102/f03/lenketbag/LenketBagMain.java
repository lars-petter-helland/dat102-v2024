package dat102.f03.lenketbag;

public class LenketBagMain {
	
	public static void main(String[] args) {
		
		BagADT<String> minBag = new LenketBag<>();
		minBag.add("Per");
		minBag.add("Pål");
		minBag.add("Espen");
		
		((LenketBag<String>) minBag).skrivUt();
	}

}
