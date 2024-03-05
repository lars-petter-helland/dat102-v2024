package no.hvl.dat102.immutable;

import java.util.Currency;

public class ImmutableObjectsMain {
	
	public static void main(String[] args) {
		
		String nei = "  Nei ";
		String naa = "Nå    ";
		String neiNaa = nei.concat(naa);
		String heiHaa = neiNaa.replace('N','H');
		String stripped = heiHaa.strip();
		String upper = stripped.toUpperCase();
		System.out.println("|" + upper + "|");

		Currency NOK = Currency.getInstance("NOK");
		System.out.println(NOK.getCurrencyCode());
		System.out.println(NOK.getSymbol());
		System.out.println(NOK.getDisplayName());
		
		String s1 = new String();
		System.out.println("#"+s1+"#");
		s1 = s1.concat("O");
		s1 = s1.concat("K");
		
		String s2 = s1;
		s2 = s2.concat("!");

		
	}

}
