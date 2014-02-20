
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	private static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		EightPuzzle puzzle = EightPuzzle.randomEightPuzzle();
		EightPuzzleSuccessorFunction sf = new EightPuzzleSuccessorFunction();

		List<ActionStatePair<PuzzleMove, EightPuzzle>> successors = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		sf.getSuccessors(puzzle, successors);

		//puzzle.makeMove(PuzzleMove.UP);
		//puzzle.makeMove(PuzzleMove.LEFT);
		List<ActionStatePair<PuzzleMove, EightPuzzle>> frontier = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();

		frontier.add(new ActionStatePair<PuzzleMove, EightPuzzle>(null, puzzle));

		ActionStatePair<PuzzleMove, EightPuzzle> current;
		boolean found = false;
		
		System.out.println(puzzle);
		
		
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
				
				for(ActionStatePair<PuzzleMove, EightPuzzle>  successor : successors){
					if(!frontier.contains(successor) && !explored.contains(successor)){
					frontier.add(successor);
					}
				}
			}

		}
		System.out.println("found");

	}

	public static List<ActionStatePair<PuzzleMove, EightPuzzle>> path(ActionStatePair<PuzzleMove, EightPuzzle> pair) {
		ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>> path = new ArrayList<ActionStatePair<PuzzleMove, EightPuzzle>>();
		
		//System.out.println(explored.size());
		path.add(pair);
		
		//System.out.println(pair.getAction());
		//System.out.println(pair.getState());
		
		
		while(pair.getAction() != null){			
			
			for(int i = 0; i < explored.size(); i++){
				//System.out.println(pair.getState());
				//System.out.println(pair.getAction());
				if(explored.get(i).getState().equals( pair.getState().undoMove(pair.getAction()))){
					pair = explored.get(i);
					path.add(0, explored.get(i));
					break;
					
				}
			}
			
			
		}
		System.out.println("path");
		System.out.println(path.size());
		for(int i = 0; i < path.size(); i++){
			System.out.println(path.get(i).getState());
		}
		
		
		
		
		
		
		return path;
	}
}
