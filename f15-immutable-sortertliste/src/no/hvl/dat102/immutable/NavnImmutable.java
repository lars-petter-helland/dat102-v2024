package no.hvl.dat102.immutable;

import java.util.Objects;

/*
 * En ikke-mutérbar klasse, altså hvor vi IKKE kan endre på innholdet
 * i et Navn-objekt etter at det er opprettet.
 * 
 * Dette oppnår vi ved å fjerne alle mutator-metoder, i dette tilfellet
 * set-metodene.
 * 
 * I tillegg bør også mutérbare instans-objekter merkes med final.
 * (Ikke med i dette eksemplet.)
 * 
 * For å være helt trygg, kan vi i tillegg gjøre klassen final, slik at
 * det ikke kan lages sub-klasser som lar oss endre på navnet.
 * 
 * PS! Så lenge alle NavnImmutable sine mutator-metoder er enten satt
 *     til private, eller fjernet helt, vil uansett ikke en subklasse
 *     kunne mutére objektene.
 *     
 * (Nederst s.503)
 */
public final class NavnImmutable {

	private final String fornavn; //Egentlig ikke nødv. siden String er immutable.
	private final String etternavn;
	
	public NavnImmutable(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etternavn, fornavn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NavnImmutable other = (NavnImmutable) obj;
		return Objects.equals(etternavn, other.etternavn) && Objects.equals(fornavn, other.fornavn);
	}

	@Override
	public String toString() {
		return "NavnImmutable[fornavn=" + fornavn + ", etternavn=" + etternavn + "]";
	}
}
