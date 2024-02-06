package dat102v24.hanoi;

import java.util.function.BiConsumer;

public class MyHanoiSolver implements HanoiSolver {

	@Override
	public void solveHanoi(BiConsumer<Integer, Integer> diskMover, 
			int n, int from, int dest, int by) {
		
		/*  
		 *  Rekursiv flytt n-1 disker fra from til by
		 *  Flytt en disk fra from til dest
		 *  Rekursiv flytt n-1 disker fra by til dest
		 */
		while (n > 0) {
			solveHanoi(diskMover, n-1, from, by, dest);
			diskMover.accept(from, dest);
			
			//solveHanoi(diskMover, n-1, by, dest, from);
			n = n-1;
			int temp = from;
			from = by;
			by = temp;
		}

	}
}