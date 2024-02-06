package dat102v24.tellnedtail;

public class TellNed {

	public static void main(String[] args) {
		tellNedTail(5);
	}
	
	public static void tellNed(int i) {
		if (i >= 1) {
			System.out.print(" " + i);
			tellNed(i-1);
		}
	}

	public static void tellNedTail(int i) {
		while (i >= 1) {
			System.out.print(" " + i);
			i = i-1;
		}
	}
}
