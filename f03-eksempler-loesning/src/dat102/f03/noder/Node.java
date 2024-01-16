package dat102.f03.noder;

public class Node<T> {

	public T data;
	public Node<T> neste;

	public Node(T data) {
		this.data = data;
		this.neste = null;
	}

	@Override
	public String toString() {
		if (neste == null) {
			return "[ " + data + " | null ] ";
		} else {
			//NB! Rekursivt kall til toString() her!
			return "[ " + data + " | •-]--> " + neste; 
		}
	}
	
//	@Override
//	public String toString() {
//		if (neste == null) {
//			return "[data-->[" + data + "], neste = null]";
//		} else {
//			//NB! Rekursivt kall til toString() her!
//			return "[data-->[" + data + "], neste-->" + neste + "]"; 
//		}
//	}

}
