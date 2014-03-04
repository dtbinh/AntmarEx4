import java.util.ArrayList;

import robot.Graph;
import robot.RobotMove;
import robot.RobotPuzzle;

public class RobotSearch {
	public static void main(String[] args) {

		Graph g = new Graph(5, 5);

//		g.createBlockage(0, 0, 1, 0);
//		g.createBlockage(0, 4, 1, 4);
//		g.createBlockage(3, 3, 3, 4);
//		g.createBlockage(2, 3, 3, 3);
//		g.createBlockage(1, 4, 2, 4);
//		g.createBlockage(4, 5, 3, 4);
		
		
		
		System.out.println(g.toString());
		
		
		System.exit(0);
		
		
		RobotPuzzle rPuzzle = new RobotPuzzle(g, 0, 0, 4, 4);
		RobotPuzzle rGoal = new RobotPuzzle(g, 4, 4, 4, 4);

		ArrayList<RobotMove> path = new ArrayList<RobotMove>();

		System.out.println("Depth-First Search");
		Search<RobotPuzzle, RobotMove> RobotSearchD = new Search<RobotPuzzle, RobotMove>(
				1, new RobotPuzzle(rPuzzle), rGoal);
		path = RobotSearchD.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("Breadth-First Search");
		Search<RobotPuzzle, RobotMove> RobotSearchB = new Search<RobotPuzzle, RobotMove>(
				0, new RobotPuzzle(rPuzzle), rGoal);
		path = RobotSearchB.findSolution();
		System.out.println();
		System.out.println(path);
		System.out.println();
		System.out.println("A* Search");
		Search<RobotPuzzle, RobotMove> RobotSearchA = new Search<RobotPuzzle, RobotMove>(
				2, new RobotPuzzle(rPuzzle), rGoal);
		path = RobotSearchA.findSolution();
		System.out.println();
		System.out.println(path);
	}
}