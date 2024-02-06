package dat102.f06.diverse;

public class SumLenketListe {

	public static void main(String[] args) {
		
		Node<Integer> a = new Node<>(5);
		Node<Integer> b = new Node<>(7);
		Node<Integer> c = new Node<>(8);
		b.neste = c;
		a.neste = b;
		
		// a--> [ 5 | •-]--> [ 7 | •-]--> [ 8 | null ]
		// b--> [ 7 | •-]--> [ 8 | null ]
		
//		System.out.println("Summen av tallene i listen a:--> " + a + " = " + sumAvListe(a));
//		System.out.println("Summen av tallene i listen b:--> " + b + " = " + sumAvListe(b));
	}
	
}
