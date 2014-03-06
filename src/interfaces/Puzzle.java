package interfaces;

import java.util.List;

import eight.EightPuzzle;
import eight.EightPuzzle.PuzzleMove;
import util.SearchNode;

public interface Puzzle<P extends Puzzle, A> {
	boolean performAction(A action);
	boolean isPossibleMove(A action);
	boolean isGoal();
	boolean equals(Object o);
	int h();
	List<SearchNode<P,A>> getSuccessors(SearchNode<P, A> s);	
}
