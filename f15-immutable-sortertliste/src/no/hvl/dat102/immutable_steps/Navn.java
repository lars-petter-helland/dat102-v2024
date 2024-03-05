package no.hvl.dat102.immutable_steps;

import java.util.Objects;

/*
 * En mutérbar klasse, altså hvor vi kan endre på innholdet i et Navn-objekt
 * via setFornavn() og setEtternavn(), etter at det er opprettet.
 */
public class Navn {
	
	private String fornavn;
	private String etternavn;
	
	public Navn(String fornavn, String etternavn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	@Override
	public String toString() {
		return "Navn[fornavn=" + fornavn + ", etternavn=" + etternavn + "]";
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
		Navn other = (Navn) obj;
		return Objects.equals(etternavn, other.etternavn) && Objects.equals(fornavn, other.fornavn);
	}

}
