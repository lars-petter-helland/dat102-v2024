package dat102v24.hanoi;

import java.util.function.BiConsumer;

public interface HanoiSolver {

	/**
	 * @param diskMover - Grafikkobjekt som flytter en disk fra en pinne til en annen
	 * 					  f.eks. diskMover.accept(1,2) flytter disk fra pinne 1 til 2
	 * 
	 * @param diskCount - Antall disker som skal flyttes
	 * @param from      - Fra pinne (1, 2 eller 3)
	 * @param dest      - Til pinne (1, 2 eller 3)
	 * @param by        - Via pinne (1, 2 eller 3)
	 */
	void solveHanoi(BiConsumer<Integer, Integer> diskMover, 
			int diskCount, int from, int dest, int by);
}