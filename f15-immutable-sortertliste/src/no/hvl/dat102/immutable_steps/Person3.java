package no.hvl.dat102.immutable_steps;

import java.util.Objects;

public class Person3 {

	private final Navn navn;
	private final int fodselsaar;

	public Person3(Navn navn, int fodselsaar) {
		this.navn = navn;
		this.fodselsaar = fodselsaar;
	}

	public Navn getNavn() {
		return navn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	@Override
	public String toString() {
		return "Person3 [navn=" + navn + ", fodselsaar=" + fodselsaar + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fodselsaar, navn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person3 other = (Person3) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
