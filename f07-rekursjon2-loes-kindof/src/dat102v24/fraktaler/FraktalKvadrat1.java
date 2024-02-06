package dat102v24.fraktaler;

public class FraktalKvadrat1 extends Fraktal {

	public FraktalKvadrat1(int depth, int delay, Tegneflate canvas) {
		super(depth, delay, canvas);
	}

	@Override
	public void tegn() {
		drawSquare(depth, 20, 20, 800, 800);
	}
	
	private void drawSquare(int level, int p1X, int p1Y, int p2X, int p2Y) {
		
		canvas.tegnFirkant(p1X, p1Y, p2X, p2Y);
		ventMillis(delay);
	    
	    if (level > 0) {
	      drawSquare(level-1, p1X+10, p1Y+10, p2X-10, p2Y-10);
	    }
	}
}
