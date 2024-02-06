package no.hvl.dat102.oblig2.parenteser;

import java.util.Set;

public class ParentesSjekker {
	
	private static final Set<Character> STARTPARENTESER = Set.of('{', '(', '[', '<');
	private static final Set<Character> SLUTTPARENTESER = Set.of('}', ')', ']', '>');
	private static final Set<String>    PARENTESPAR = Set.of("{}", "()", "[]", "<>");
	
	public static boolean sjekkParenteser(String s) {
		
		StabelADT<Character> stabel = new TabellStabel<>();
		
		//TODO Ca. 10-15 kodelinjer her gir en komplett løsning 
		return false;
	}

	private static boolean erStartParentes(char c) {
		//TODO 1 kodelinje her
		return false;
	}
	
	private static boolean erSluttParentes(char c) {
		//TODO 1 kodelinje her
		return false;
	}
	
	private static boolean erParentesPar(char start, char slutt) {
		//TODO 1-2 kodelinje(r) her
		return false;
	}
}
