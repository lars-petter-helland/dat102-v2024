package dat102.f06.rekursivlenketbag;

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
	private Node finnNode(T entry) {
		
		Node temp = forste;
		while(temp != null) {
			if (temp.data.equals(entry)) {
				return temp;
			}
			temp = temp.neste;
		}
		return null;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		
		int frekvens = 0;
		
		Node temp = forste;
		while(temp != null) {
			if (temp.data.equals(anEntry)) {
				frekvens++;
			}
			temp = temp.neste;
		}
		return frekvens;
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
	
	//---------------------------------------------------------------
	
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
