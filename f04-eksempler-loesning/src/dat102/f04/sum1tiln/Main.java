package dat102.f04.sum1tiln;

import java.util.function.UnaryOperator;

/*
 * Et lite program som måler kjøretiden for de tre ulike
 * algoritmene for å summere tallene 1..n.
 * 
 * Det er ikke meningen at dere skal forstå alt jeg har skrevet i
 * dette programmet: 
 * 		# n -> sum1tilnAlgoA(n)
 * 		# UnaryOperator<Long> fu
 * 		# fu.apply(n)
 * 
 * men i september (etter 1 mnd med DAT108) forstår dere nok det meste.
 */
public class Main {

	public static void main(String[] args) {
		
		final long N = 400_000L;
		
		taTidOgSkrivUt("A", n -> sum1tilnAlgoA(n), N);
		taTidOgSkrivUt("B", n -> sum1tilnAlgoB(n), N);
		taTidOgSkrivUt("C", n -> sum1tilnAlgoC(n), N);
	}
	
	private static long sum1tilnAlgoA(long n) {
		
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	private static long sum1tilnAlgoB(long n) {

		long sum = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= i; j++) {
				sum++;
			}
		}
		return sum;
	}

	private static long sum1tilnAlgoC(long n) {
		return n * (n+1) / 2;
	}
	
	/*
	 * Hjelpemetode for tidtaking og utskrift
	 */
	private static void taTidOgSkrivUt(String abc, UnaryOperator<Long> fu, long n) {
		
		System.out.print("Algoritme " + abc + " ");
		
		long startMillis = System.currentTimeMillis();
		long sum = fu.apply(n);
		long millis = System.currentTimeMillis() - startMillis;
		
		System.out.println("("+ millis + " ms): " + sum);
	}
}
