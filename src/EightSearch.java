import java.util.ArrayList;

import eight.EightPuzzle;
import eight.EightPuzzle.PuzzleMove;

public class EightSearch {

	public static void main(String[] args) {
		EightPuzzle ePuzzle = EightPuzzle.randomEightPuzzle(15);
		
		ArrayList<PuzzleMove> path = new ArrayList<PuzzleMove>();
		
		System.out.println("Depth-First Search");
		Search<EightPuzzle, PuzzleMove> eightSearchD = new Search<EightPuzzle, PuzzleMove>(
				1, new EightPuzzle(ePuzzle));
		path = eightSearchD.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("Breadth-First Search");
		Search<EightPuzzle, PuzzleMove> eightSearchB = new Search<EightPuzzle, PuzzleMove>(
				0, new EightPuzzle(ePuzzle));
		path = eightSearchB.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("A* Search");
		Search<EightPuzzle, PuzzleMove> eightSearchA = new Search<EightPuzzle, PuzzleMove>(
				2, new EightPuzzle(ePuzzle));
		path = eightSearchA.findSolution();
		System.out.println();
		System.out.println(path);
	}

}
