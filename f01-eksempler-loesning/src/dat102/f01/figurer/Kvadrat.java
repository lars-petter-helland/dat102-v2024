package dat102.f01.figurer;

public class Kvadrat implements Figur2d {
	
	private double side;

	public Kvadrat(double side) {
		this.side = side;
	}

	@Override
	public double areal() {
		return side * side;
	}

	@Override
	public double omkrets() {
		return 4 * side;
	}	
}
