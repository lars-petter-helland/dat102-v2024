package dat102.f02.wrappere;

/*
 * Litt eksperimentering med int og Integer ....
 */
public class WrappereMain {
	
	public static void main(String[] args) {
		
		int a = 1;		//vanlig primitiv datatype int
		Integer b = a; 	//boxing, altså konvertering fra int til Integer
		int c = b; 		//unboxing, altså konvertering fra Integer til int
		
		Integer d = Integer.parseInt("3"); //parsing av String til Integer
		
		//Boxing
		Integer e = 4;
		Integer f = a;
		
		if (e > f) {
			System.out.println("Halle");
		};
		
		//Unboxing av c, "+", boxing av resultat
		Integer g = b + c;
		
		//Unboxing
		int h = f + g;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
	}

}
