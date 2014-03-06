import java.util.ArrayList;

import jumble.JumbledMove;
import jumble.JumbledPuzzle;

public class JumbledSearch {
	public static void main(String[] args) {
		JumbledPuzzle jPuzzle = JumbledPuzzle.randomJumbledPuzzle("compute");
		
		ArrayList<JumbledMove> path = new ArrayList<JumbledMove>();

		System.out.println("Depth-First Search");
		Search<JumbledPuzzle, JumbledMove> JumbledSearchD = new Search<JumbledPuzzle, JumbledMove>(
				1, new JumbledPuzzle(jPuzzle));
		path = JumbledSearchD.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("Breadth-First Search");
		Search<JumbledPuzzle, JumbledMove> JumbledSearchB = new Search<JumbledPuzzle, JumbledMove>(
				0, new JumbledPuzzle(jPuzzle));
		path = JumbledSearchB.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("A* Search");
		Search<JumbledPuzzle, JumbledMove> JumbledSearchA = new Search<JumbledPuzzle, JumbledMove>(
				2, new JumbledPuzzle(jPuzzle));
		path = JumbledSearchA.findSolution();
		System.out.println();
		System.out.println(path);
	}
}
