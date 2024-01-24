package dat102.f06.diverse;

public class Node<T> {

	public T data;
	public Node<T> neste;

	public Node(T data) {
		this.data = data;
		this.neste = null;
	}

	@Override
	public String toString() {
		if (neste == null) { //Basistilfelle
			return "[ " + data + " | null ] ";
		} else {
			//NB! Rekursivt kall til toString() her!
			return "[ " + data + " | •-]--> " + neste.toString(); 
		}
	}
}
