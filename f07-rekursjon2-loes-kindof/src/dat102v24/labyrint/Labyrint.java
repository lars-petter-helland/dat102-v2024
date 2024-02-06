package dat102v24.labyrint;

public class Labyrint {
	
	private static final char STONE = '▦';
	private static final char __o__ = '▢';
	private static final char TRIED = '☒';
	private static final char  PATH = '◼';
	
	private int antallRekker;
	private int antallKolonner;
	
	private char[][] grid = 
			{ {STONE, __o__, __o__, __o__, __o__, STONE, __o__}, 
			  {STONE, STONE, STONE, STONE, __o__, STONE, __o__}, 
			  {__o__, STONE, __o__, __o__, __o__, STONE, __o__}, 
			  {STONE, STONE, __o__, STONE, STONE, STONE, STONE}, 
			  {STONE, __o__, __o__, STONE, __o__, STONE, __o__}, 
			  {STONE, STONE, STONE, STONE, __o__, STONE, STONE}, 
			  {__o__, STONE, __o__, STONE, __o__, __o__, STONE}};

	// Vi kunne lest inn labyrinten fra fil. Her har vi kodet
	// labyrinten direkte i klassen. Vi kan bare gå til celler
	// med 1 og må gå enten opp, ned, til venstre eller høyre

	public Labyrint() {
		antallRekker = grid.length;
		antallKolonner = grid[0].length; //Antar at alle rader tilsv. rad 0.
	}

	public int getRekker() {
		return antallRekker;
	}

	public int getKolonner() {
		return antallKolonner;
	}

	public void markerPosisjonSomProvd(int r, int k) {
		grid[r][k] = TRIED;
	}

	public void markerPosisjonSomSti(int r, int k) {
		grid[r][k] =  PATH;
	}

	public boolean lovlegPosisjon(int r, int k) {
		boolean innanforBrett = (r >= 0) && (r < antallRekker) 
				&& (k >= 0) && (k < antallKolonner);
		
		return innanforBrett && grid[r][k] == STONE;
	}

	@Override
	public String toString() {
		String resultat = "\n";
		for (int r = 0; r < antallRekker; r++) {
			for (int k = 0; k < antallKolonner; k++) {
				resultat += grid[r][k] + " ";
			}
			resultat += "\n";
		}
		return resultat;
	}
}
