package dat102.f03.lenketbag;

public class LenketBag<T> implements BagADT<T> {

	/*
	 * Vi kunne like godt hatt Node i en egen fil Node.java slik vi gjorde i 
	 * forrige eksempel, og slik dere er vant med, men siden den kun brukes 
	 * internt i LenketBag trenger den ikke være public. Den kan være en 
	 * private klasse inni LenketBag. (en såkalt inner class)
	 * 
	 * Bortsett fra plasseringen, er den en helt vanlig klasse.
	 */
	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/************************************************************/

	private Node forste;
	private int antall;
	
	public LenketBag() {
		forste = null;
		antall = 0;
	}
	
	/************************************************************/

	@Override
	public int getCurrentSize() {
		//TODO
		return 0; 
	}

	@Override
	public boolean isEmpty() {
		//TODO
		return false;
	}

	@Override
	public boolean add(T newEntry) {
		//TODO
		// Legger inn først i listen siden det er enklest
		
		return false;
	}

	@Override
	public T remove() {
		//TODO
		// Først sjekke om tom
		
		// Fjerner den første siden det er enklest
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		//TODO
		//1) Finn referanse til den som skal fjernes, null hvis ikke funnet.
		//   Nesten som da vi søkte etter "Anne". Kanskje vi burde laget en
		//   private hjelpemetode for denne?
		
		//2) Hvis ikke funnet, så return false.
		
		//3) Fjerning kan gjøres ved å overskrive data med data fra første node, 
		//	 og deretter fjerne første node.
		
		return false;
	}
	
	/* Private hjelpemetode til bruk i f.eks. remove(T e);
	 * Returnerer referanse til node hvis funnet, ellers null.
	 */
	private Node finnNode(T entry) {
		//TODO
		return null;
	}

	@Override
	public void clear() {
		//TODO
		// Her kan vi bruke remove() som hjelpemetode og gå i en løkke.
		// Evt. bare nullstille medlemsvariabler.
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		//TODO
		//Litt tilsvarende søkemetoden finnNode()
		return 0;
	}

	@Override
	public boolean contains(T anEntry) {
		//TODO
		// Her kan vi bruke getFrequencyOf() som hjelpemetode?
		// Eller kanskje enda enklere, søkemetoden finnNode()
		return false;
	}

	@Override
	public T[] toArray() {
		// Starter med å lage tabellen elementene skal settes inn i.
		// Hva hvis tom? Lage en tabell med plass til 0 elementer?
		@SuppressWarnings("unchecked")
		T[] resultat = (T[]) new Object[antall];

		//Deretter er det å kopiere over elementene.
		//TODO
		
		return resultat;
	}
	
	/*
	 * Tester ut traversering og utskrift
	 * Ikke en del av BagADT-kontrakten.
	 */
	public void skrivUt() {
		Node denne = forste;
		while(denne != null) {
			System.out.println(denne.data);
			denne = denne.neste;
		}
	}

}
