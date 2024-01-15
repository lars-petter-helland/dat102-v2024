package dat102.f03.noder;

public class NoderMain {
	
	public static void main(String[] args) {

		/*
		 * I dette eksemplet skal vi se på enkle operasjoner på en lenket
		 * liste av noder. Vi gjør litt og litt.
		 */
		
		Node<String> temp = null; //Hjelpevariabel
		
		//1) Opprette en liste med 3 noder, forste--> [Per|-]--> [Pål|-]--> [Espen|null]
		
		//1a) Vi begynner med å lage og sette inn det som blir siste node, [Espen|..]
		// TODO
		
		//1b) Deretter lage nest siste node [Pål|..], og la den peke på [Espen|..]
		// TODO
		
		//1c) Deretter lage forste node [Per|..], og la den peke på [Pål|..]
		// TODO
		
		//2) Skrive ut innhold/element i alle nodene i listen (bruk hjelpemetoden nedenfor)
		// TODO
		
		//3) Skrive ut innhold/element i andre node i listen, dvs. [Pål|..] 
		// TODO
		
		//4) Slette andre node, [Pål|..]
		// TODO

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
