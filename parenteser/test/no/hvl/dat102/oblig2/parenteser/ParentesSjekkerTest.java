package no.hvl.dat102.oblig2.parenteser;

import org.junit.jupiter.api.Test;

class ParentesSjekkerTest {

	@Test
	void test() {
		
		String s1 = "{ [ ( ) ] }"; //er korrekt
		String s2 = "{ [ ( ) }";   //er ikke korrekt. Mangler sluttparentes ]
		String s3 =	"[ ( ) ] }";   //er ikke korrekt. Mangler startparentes {
		String s4 = "{ [ ( ] ) }";  //er ikke korrekt. Sluttparentes ] kommer for tidlig.

		String s5 = """
			class HelloWorld {
			    public static void main(String[] args) {
			        System.out.println("Hello World!");
			    }
			} """; //er korrekt
		
		String s6 = "";
		String s7 = "()";
		
		//TODO Test om ParentesSjekkeren virker korrekt for eksemplene s1-s7 over.
		
	}

}
