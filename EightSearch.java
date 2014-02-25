import java.util.ArrayList;
import java.util.List;

import rp13.search.problem.puzzle.EightPuzzle;
import rp13.search.problem.puzzle.EightPuzzle.PuzzleMove;
import rp13.search.problem.puzzle.EightPuzzleSuccessorFunction;
import rp13.search.util.ActionStatePair;
import rp13.search.util.EqualityGoalTest;

public class EightSearch {

	private static List<ActionStatePair<PuzzleMove, EightPuzzle>> explored = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
	private List<ActionStatePair<PuzzleMove, EightPuzzle>> frontier = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
	private static EqualityGoalTest<EightPuzzle> gt = new EqualityGoalTest<EightPuzzle>(
			EightPuzzle.orderedEightPuzzle());

	public static void main(String[] args) {

		int searchType = 1;

		EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();
		EightPuzzleSuccessorFunction sf = new EightPuzzleSuccessorFunction();

		List<ActionStatePair<PuzzleMove, EightPuzzle>> successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		sf.getSuccessors(puzzle, successors);

		List<ActionStatePair<PuzzleMove, EightPuzzle>> frontier = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();

		frontier.add(new ActionStatePair<PuzzleMove, EightPuzzle>(null, puzzle));

		ActionStatePair<PuzzleMove, EightPuzzle> current;
		boolean found = false;
		int count = 0;

		System.out.println(puzzle);
		if (searchType == 0) {
			while (!found) {

				current = frontier.get(0);
				explored.add(frontier.get(0));
				frontier.remove(0);

				if (gt.isGoal(current.getState())) {
					found = true;
					System.out.println("found");
					path(current);
				} else {
					successors.clear();
					sf.getSuccessors(current.getState(), successors);

					for (ActionStatePair<PuzzleMove, EightPuzzle> successor : successors) {
						boolean flag = false;
						for (ActionStatePair<PuzzleMove, EightPuzzle> front : frontier) {
							if (front.getState().equals(successor.getState())) {
								flag = true;
							}
						}
						for (ActionStatePair<PuzzleMove, EightPuzzle> front : explored) {
							if (front.getState().equals(successor.getState())) {
								flag = true;
							}
						}

						if (!flag) {
							frontier.add(successor);
						} else {
							count++;
							// System.out.println(count);
						}

						// if (!frontier.contains(successor)
						// && !explored.contains(successor)) {
						// frontier.add(successor);
						// }
						// else {
						// count++;
						// System.out.println(count);
						// }
					}

				}
			}
		} else {
			while (!found) {

				current = frontier.get(0);
				explored.add(frontier.get(0));
				frontier.remove(0);

				if (gt.isGoal(current.getState())) {
					found = true;
					System.out.println("found");
					path(current);
				} else {
					successors.clear();
					sf.getSuccessors(current.getState(), successors);

					for (ActionStatePair<PuzzleMove, EightPuzzle> successor : successors) {
						boolean flag = false;
						for (ActionStatePair<PuzzleMove, EightPuzzle> front : frontier) {
							if (front.getState().equals(successor.getState())) {
								flag = true;
							}
						}
						for (ActionStatePair<PuzzleMove, EightPuzzle> front : explored) {
							if (front.getState().equals(successor.getState())) {
								flag = true;
							}
						}

						if (!flag) {
							frontier.add(successor);
						} else {
							count++;
							// System.out.println(count);
						}

						// if (!frontier.contains(successor)
						// && !explored.contains(successor)) {
						// frontier.add(successor);
						// }
						// else {
						// count++;
						// System.out.println(count);
						// }
					}
				}

			}

		}
		System.out.println("found");
		System.out.println(count);

	}

	public static List<ActionStatePair<PuzzleMove, EightPuzzle>> path(
			ActionStatePair<PuzzleMove, EightPuzzle> pair) {
		ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>> path = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		path.add(pair);

		while (pair.getAction() != null) {

			for (int i = 0; i < explored.size(); i++) {
				if (explored.get(i).getState()
						.equals(pair.getState().undoMove(pair.getAction()))) {
					pair = explored.get(i);
					path.add(0, explored.get(i));
					break;

				}
			}

		}
		System.out.println("path");
		System.out.println(path.size());
		for (int i = 0; i < path.size(); i++) {
			System.out.println(path.get(i).getState());
		}

		return path;
	}
}
