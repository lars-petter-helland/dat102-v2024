package dat102.f06.rekursivlenketbag;

/*
 * Ny implementasjon av LenketBag der vi prøver oss med rekursjon
 * i stedet for løkke i noen av metodene.
 * 
 * Metoder som er påvirket av omskriving  med rekursjon er:
 *  
 * - public boolean remove(T anEntry), som bruker private Node finnNode(T entry)
 * - public	int getFrequencyOf(T anEntry)
 * - public	void skrivUt() Ikke med i BagADT-en.
 * 
 * Skrevet av Lars-Petter Helland, 23. januar 2024
 */

public class LenketBagRekursiv<T> implements BagADT<T> {
	
	private Node forste;
	private int antall;
	
	public LenketBagRekursiv() {
		forste = null;
		antall = 0;
	}
	
	/************************************************************/

	@Override
	public int getCurrentSize() {
		return antall; 
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public boolean add(T newEntry) {
		// Legger inn først i listen siden det er enklest
		Node ny = new Node(newEntry);
		ny.neste = forste;
		forste = ny;
		antall++;
		
		return true;
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		// Fjerner den første siden det er enklest
		T verdi = forste.data;
		forste = forste.neste;
		antall--;
		return verdi;
	}

	@Override
	public boolean remove(T anEntry) {
		
		//1) Finn referanse til den som skal fjernes, null hvis ikke funnet.
		Node funnetNode = finnNode(anEntry); 
		
		//2) Hvis ikke funnet, så return false.
		if (funnetNode == null) {
			return false;
		}
		
		//3) Fjerning kan gjøres ved å overskrive data med data fra første node, 
		//	 og deretter fjerne første node.
		funnetNode.data = forste.data;
		forste = forste.neste;
		antall--;
		
		return true;
	}
	
	/* Private hjelpemetode til bruk i f.eks. remove(T e);
	 * Returnerer referanse til node hvis funnet, ellers null.
	 */
	Node finnNode(T entry) {
		return finnNode(entry, forste);
	}
	Node finnNode(T entry, Node denne) {
		if (denne == null) { // Basistilfelle 1
			return null;
		}
		if (denne.data.equals(entry)) { // Basistilfelle 2
			return denne;
		}
		return finnNode(entry, denne.neste);
	}
	
	
	@Override
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		return getFrequencyOf(anEntry, forste);
	}
	public int getFrequencyOf(T anEntry, Node denne) {
		if (denne == null) { //Basistilfelle
			return 0;
		} else {
			int antallIResten = getFrequencyOf(anEntry, denne.neste);
			int antallIDenne = (denne.data.equals(anEntry)) ? 1 : 0;
			return antallIDenne + antallIResten;
		}
	}
	
	@Override
	public boolean contains(T anEntry) {
		return getFrequencyOf(anEntry) > 0;
	}

	@Override
	public T[] toArray() {
		// Starter med å lage tabellen elementene skal settes inn i.
		// Hva hvis tom? Lage en tabell med plass til 0 elementer?
		@SuppressWarnings("unchecked")
		T[] resultat = (T[]) new Object[antall];

		//Deretter er det å kopiere over elementene.
		Node temp = forste;
		int i = 0;
		while (temp != null) {
			resultat[i] = temp.data;
			temp = temp.neste;
			i++;
		}
		return resultat;
	}
	
	/************************************************************/
	
	/*
	 * Utskrift.
	 * Ikke en del av BagADT-kontrakten.
	 */
	public void skrivUt() {
		//TODO
	}

	/************************************************************/
	
	private class Node {
		
		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/************************************************************/

}
