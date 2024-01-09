package dat102.f01.figurer;

public class Sirkel implements Figur2d {
	
	private double radius;
	
	public Sirkel(double radius) {
		this.radius = radius;
	}

	@Override
	public double areal() {
		return Math.PI * radius * radius;
	}

	@Override
	public double omkrets() {
		return 2 * Math.PI * radius;
	}

}
