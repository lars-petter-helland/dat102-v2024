package no.hvl.dat102.immutable_steps;

import java.util.Objects;

public class Person2 {

	private Navn navn;
	private int fodselsaar;
	
	public Person2(Navn navn, int fodselsaar) {
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
		return "Person2 [navn=" + navn + ", fodselsaar=" + fodselsaar + "]";
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
		Person2 other = (Person2) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
