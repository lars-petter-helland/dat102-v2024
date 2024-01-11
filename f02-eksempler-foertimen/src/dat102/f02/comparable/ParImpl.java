package dat102.f02.comparable;

public class ParImpl<T> implements Par<T> {
	
	private T forste;
	private T andre;

	public ParImpl(T forste, T andre) {
		this.forste = forste;
		this.andre = andre;
	}
	
	@Override
	public T minste() {
		return null;
	}
	
	@Override
	public T storste() {
		return null;
	}
	
	@Override
	public T forste() {
		return forste;
	}

	@Override
	public T andre() {
		return andre;
	}

	@Override
	public String toString() {
		return "(" + forste + "," + andre + ")";
	}

}
