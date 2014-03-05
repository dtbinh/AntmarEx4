

import java.util.ArrayList;

import robot.Graph;
import robot.RobotMove;
import robot.RobotPuzzle;
import jumble.JumbledMove;
import jumble.JumbledPuzzle;
import eight.EightPuzzle;
import eight.EightPuzzle.PuzzleMove;


public class Test {
	public static void main(String[] args){
		//new EightPuzzle(new int[] { 8, 6, 7, 2, 5, 4, 3, 0, 1 });
//		
//		EightPuzzle p = EightPuzzle.randomEightPuzzle(10);
//		Search<EightPuzzle, PuzzleMove> s = new Search<EightPuzzle, PuzzleMove>(0, new EightPuzzle(p) , EightPuzzle.orderedEightPuzzle());
//		s.findSolution();
//		Search<EightPuzzle, PuzzleMove> t = new Search<EightPuzzle, PuzzleMove>(1, new EightPuzzle(p) , EightPuzzle.orderedEightPuzzle());
//		t.findSolution();
//		Search<EightPuzzle, PuzzleMove> u = new Search<EightPuzzle, PuzzleMove>(2, new EightPuzzle(p) , EightPuzzle.orderedEightPuzzle());
//		u.findSolution();
//		
//		ArrayList<PuzzleMove> a = new ArrayList<PuzzleMove>();
//		a = s.findSolution();
//		System.out.println(a);
//		
//		
//		Search<JumbledPuzzle, JumbledMove> w = new Search<JumbledPuzzle, JumbledMove>(0, JumbledPuzzle.randomJumbledPuzzle("hellowor") , new JumbledPuzzle("hellowor"));
//		a = new ArrayList<JumbledMove>();
//		a = w.findSolution();
//		for(JumbledMove act : a){
//			System.out.println(act);
//		}
//		
//		Graph g = new Graph(10, 10);
//		
//		g.createBlockage(0, 0, 1, 0);
//		g.createBlockage(0, 1, 1, 1);
//
//		
//		RobotPuzzle r = new RobotPuzzle(g, 0, 0);
//		
//		RobotPuzzle goal = new RobotPuzzle(g, 7, 8);
//		
//		
//		Search<RobotPuzzle, RobotMove> u = new Search<RobotPuzzle, RobotMove>(0, r, goal);
//
//		ArrayList<RobotMove> a = new ArrayList<RobotMove>();
//		a = u.findSolution();
//		System.out.println(a.toString());
//		
//		

		
	}
}
