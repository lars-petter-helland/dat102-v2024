package no.hvl.dat102.immutable_steps;

import java.util.Objects;

public class Person0 {

	public Navn navn;
	public int fodselsaar;
	
	public Person0(Navn navn, int fodselsaar) {
		this.navn = navn;
		this.fodselsaar = fodselsaar;
	}
	
	public Navn getNavn() {
		return navn;
	}

	public void setNavn(Navn navn) {
		this.navn = navn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	public void setFodselsaar(int fodselsaar) {
		this.fodselsaar = fodselsaar;
	}

	@Override
	public String toString() {
		return "Person0 [navn=" + navn + ", fodselsaar=" + fodselsaar + "]";
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
		Person0 other = (Person0) obj;
		return fodselsaar == other.fodselsaar && Objects.equals(navn, other.navn);
	}
}
