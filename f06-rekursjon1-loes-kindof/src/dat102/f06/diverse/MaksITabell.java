package dat102.f06.diverse;

import java.util.Arrays;

public class MaksITabell {
	
	public static void main(String[] args) {
		
		int[] tabell = {-4, 5, 12, 0, 3, 7, -2, 3};
		
		System.out.println("Den største verdien i tabellen " 
				+ Arrays.toString(tabell) + " er " + maksTab(tabell));
	}
	
	public static int maksTab(int[] tab) {
		return maksTab(tab, 0, tab.length-1);
	}
	
	public static int maksTab(int[] tab, int start, int slutt) {
		
		if (start == slutt) { //basistilfelle
			return tab[start];
			
		} else {
			int midten = (start + slutt) / 2;
			int maksVenstre = maksTab(tab, start, midten);
			int maksHoyre = maksTab(tab, midten+1, slutt);
			
//			return Math.max(maksVenstre, maksHoyre);
			
//			if (maksHoyre >= maksVenstre) {
//				return maksHoyre;
//			} else {
//				return maksVenstre;
//			}
			
			return (maksHoyre >= maksVenstre) ? maksHoyre : maksVenstre;
		}
	}

}



