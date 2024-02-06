package dat102v24.hanoi;

public class HanoiMain {
	
	public static void main(String[] args) {
		HanoiSolver solver = new MyHanoiSolver();
		new HanoiPuzzle(5, solver);
	}
}