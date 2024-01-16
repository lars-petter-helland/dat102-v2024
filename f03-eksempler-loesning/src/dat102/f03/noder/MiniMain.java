package dat102.f03.noder;

public class MiniMain {
	
	public static void main(String[] args) {
		
		//1)
		Node<Integer> a = new Node<>(7);
		System.out.println("a --> " + a);
		
		//2)
		Node<Integer> b = new Node<>(12);
		System.out.println("b --> " + b);
		
		//3)
		Node<Integer> c = a;
		System.out.println("c --> " + c);
		
		//4)
		a.neste = b;
		System.out.println("a --> " + a);
		
	}

}
