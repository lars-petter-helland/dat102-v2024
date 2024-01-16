package dat102.f03.noder;

public class NoderMain {
	
	public static void main(String[] args) {

		/*
		 * I dette eksemplet skal vi se på enkle operasjoner på en lenket
		 * liste av noder. Vi gjør litt og litt.
		 */
		
		
		//1) Opprette en liste med 3 noder, forste--> [Per|-]--> [Pål|-]--> [Espen|null]
		Node<String> temp = null; //Hjelpevariabel
		
		//1a) Vi begynner med å lage og sette inn det som blir siste node, [Espen|..]
		Node<String> forste = new Node<>("Espen");
		
		//1b) Deretter lage nest siste node [Pål|..], og la den peke på [Espen|..]
		temp = new Node<>("Pål");
		temp.neste = forste;
		forste = temp;
		
		//1c) Deretter lage forste node [Per|..], og la den peke på [Pål|..]
		temp = new Node<>("Per");
		temp.neste = forste;
		forste = temp;
		
		//2) Skrive ut innhold/element i alle nodene i listen (bruk hjelpemetoden nedenfor)
		skrivUtListe(forste);
		
		//3) Skrive ut innhold/element i andre node i listen, dvs. [Pål|..] 
		System.out.println(forste.neste.data);
		
		//4)  Slette andre node, [Pål|..]
		//4a) "Søk"
		temp = forste.neste;
		//4b) Slett
		temp.data = forste.data;
		forste = forste.neste;
		skrivUtListe(forste);
		

		//5) Sette inn en ny node, [Anne|..], som andre node
		// TODO
		
		//6) Søke om listen inneholder "Anne". Ende opp med en referanse til [Anne|..]
		// TODO
		
	}

	// Hjelpemetode for utskrift
	private static void skrivUtListe(Node<String> forste) {
		
		Node<String> temp = forste;
		
		System.out.println();
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.neste;
		}
		System.out.println();
	}

}
