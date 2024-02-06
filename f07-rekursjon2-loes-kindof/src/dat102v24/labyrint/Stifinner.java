package dat102v24.labyrint;

public class Stifinner {

	private Labyrint labyrint;
	private int maalRad;
	private int maalKol;

	public Stifinner(Labyrint labyrint) {
		this.labyrint = labyrint;
		this.maalRad = labyrint.getRekker() - 1;
		this.maalKol = labyrint.getKolonner() - 1;
	}

	/**
	 * Finner sti fra (rad, kol) til nedre høyre hjørne av labyrint. Returnerer om
	 * dette lar seg gjøre eller ikke.
	 */
	public boolean finnSti(int rad, int kol) {

		/*
		 * Basistilfelle: Du ikke kommer videre herfra fordi dette ikke er en celle du
		 * kan bruke som en del av stien, eller du er utenfor labyrinten.
		 */
		if (!labyrint.lovlegPosisjon(rad, kol)) {
			return false;
		}
		/* Basistilfelle: Du har funnet veien til mål og er ferdig. */
		if (rad == maalRad && kol == maalKol) {
			labyrint.markerPosisjonSomSti(rad, kol);
			return true;
		}

		/* Ellers er det å prøve de mulige veiene videre. */
		
		/* Marker første at vi har vært her. */
		labyrint.markerPosisjonSomProvd(rad, kol);

		/* Prøver å finne en sti fra nabocelle i de ulike retningene, 
		 * etter tur.
		 * 
		 * Her benytter vi oss short-circuit-egenskapen til ||. 
		 * Hvis finnSti(rad, kol + 1) er true, vil hele uttrykket
		 * være true, og de siste rekursive kallene blir derfor 
		 * ikke utført. Vi sier at uttrykket blir "kortsluttet".
		 * Osv ...
		 */
		boolean funnetSti = 
				   finnSti(rad, kol + 1) // Høyre
				|| finnSti(rad + 1, kol) // Ned
				|| finnSti(rad, kol - 1) // Venstre
				|| finnSti(rad - 1, kol);// Opp

		if (funnetSti) {
			labyrint.markerPosisjonSomSti(rad, kol);
		}
		return funnetSti;
	}
}
