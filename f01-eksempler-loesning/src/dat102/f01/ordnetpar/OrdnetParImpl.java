package dat102.f01.ordnetpar;

public class OrdnetParImpl<T> implements OrdnetPar<T> {
	
	private T forste;
	private T andre;

	public OrdnetParImpl(T forste, T andre) {
		this.forste = forste;
		this.andre = andre;
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
	public void byttOm() {
		T temp = forste;
		forste = andre;
		andre = temp;
	}

	@Override
	public String toString() {
		return "(" + forste + "," + andre + ")";
	}
	
	

}
