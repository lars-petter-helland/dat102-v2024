package dat102v24.fraktaler;

public abstract class Fraktal {

	protected int depth;
	protected int delay;
	protected Tegneflate canvas;

	public Fraktal(int depth, int delay, Tegneflate canvas) {
		this.depth = depth;
		this.delay = delay;
		this.canvas = canvas;
	}

	protected abstract void tegn();

	protected void ventMillis(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}