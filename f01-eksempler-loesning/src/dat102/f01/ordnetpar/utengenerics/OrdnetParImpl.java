package dat102.f01.ordnetpar.utengenerics;

public class OrdnetParImpl implements OrdnetPar {
	
	private Object forste;
	private Object andre;

	public OrdnetParImpl(Object forste, Object andre) {
		this.forste = forste;
		this.andre = andre;
	}

	@Override
	public Object forste() {
		return forste;
	}

	@Override
	public Object andre() {
		return andre;
	}

	@Override
	public void byttOm() {
		Object temp = forste;
		forste = andre;
		andre = temp;
	}

	@Override
	public String toString() {
		return "(" + forste + "," + andre + ")";
	}

}
