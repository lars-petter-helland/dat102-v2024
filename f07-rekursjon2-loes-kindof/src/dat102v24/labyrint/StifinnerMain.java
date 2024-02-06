package dat102v24.labyrint;

public class StifinnerMain {

	public static void main(String[] args) {
		
		Labyrint labyrint = new Labyrint();
		System.out.println(labyrint);
		
		// Prøver å finne stien fra (0,0) til nedre høyre hjørne av labyrinten
		Stifinner sf = new Stifinner(labyrint);
		sf.finnSti(0, 0);
		System.out.println(labyrint);
        
		
	}

}
