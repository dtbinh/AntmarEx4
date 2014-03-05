package Test;

import java.util.ArrayList;

import jumble.JumbledMove;
import jumble.JumbledPuzzle;

import org.testng.annotations.Test;

import robot.Graph;
import robot.RobotMove;
import robot.RobotPuzzle;
import util.SearchNode;
import static org.testng.AssertJUnit.assertEquals;
import eight.EightPuzzle;
import eight.EightPuzzle.PuzzleMove;

public class Testing {
	@Test
	public void testEight() {
		EightPuzzle e1 = new EightPuzzle(
				new int[] { 1, 2, 3, 4, 0, 6, 7, 8, 5 }, 4);
		e1.performAction(PuzzleMove.UP);
		assertEquals(
				new EightPuzzle(new int[] { 1, 0, 3, 4, 2, 6, 7, 8, 5 }, 1), e1);
		e1.performAction(PuzzleMove.LEFT);
		assertEquals(
				new EightPuzzle(new int[] { 0, 1, 3, 4, 2, 6, 7, 8, 5 }, 0), e1);
		e1.performAction(PuzzleMove.DOWN);
		assertEquals(
				new EightPuzzle(new int[] { 4, 1, 3, 0, 2, 6, 7, 8, 5 }, 3), e1);
		assertEquals(false, e1.performAction(PuzzleMove.LEFT));
		e1.performAction(PuzzleMove.RIGHT);
		assertEquals(
				new EightPuzzle(new int[] { 4, 1, 3, 2, 0, 6, 7, 8, 5 }, 4), e1);

	}

	@Test
	public void testEightSuccessor() {
		EightPuzzle e1 = new EightPuzzle(
				new int[] { 1, 2, 3, 4, 0, 6, 7, 8, 5 }, 4);
		ArrayList<SearchNode<EightPuzzle, PuzzleMove>> successors = (ArrayList<SearchNode<EightPuzzle, PuzzleMove>>) e1
				.getSuccessors(new SearchNode<EightPuzzle, PuzzleMove>(null,
						null, e1));
		assertEquals(4, successors.size());
		assertEquals(
				new EightPuzzle(new int[] { 1, 0, 3, 4, 2, 6, 7, 8, 5 }, 1),
				successors.get(0).getState());
		assertEquals(
				new EightPuzzle(new int[] { 1, 2, 3, 4, 8, 6, 7, 0, 5 }, 7),
				successors.get(1).getState());
		assertEquals(
				new EightPuzzle(new int[] { 1, 2, 3, 0, 4, 6, 7, 8, 5 }, 3),
				successors.get(2).getState());
		assertEquals(
				new EightPuzzle(new int[] { 1, 2, 3, 4, 6, 0, 7, 8, 5 }, 5),
				successors.get(3).getState());
	}

	@Test
	public void testJumbled() {
		JumbledPuzzle j1 = new JumbledPuzzle("AntMar");
		j1.performAction(new JumbledMove(0, 1));
		assertEquals(new JumbledPuzzle("nAtMar"), j1);
		j1.performAction(new JumbledMove(2, 1));
		assertEquals(new JumbledPuzzle("ntAMar"), j1);
		assertEquals(false, j1.performAction(new JumbledMove(0, 6)));
		assertEquals(new JumbledPuzzle("ntAMar"), j1);

	}

	@Test
	public void testJumbledSuccessors() {
		JumbledPuzzle j1 = new JumbledPuzzle("AntMar");
		ArrayList<SearchNode<JumbledPuzzle, JumbledMove>> successors = (ArrayList<SearchNode<JumbledPuzzle, JumbledMove>>) j1
				.getSuccessors(new SearchNode<JumbledPuzzle, JumbledMove>(null,
						null, j1));
		assertEquals(15, successors.size());
		assertEquals(new JumbledPuzzle("nAtMar"), successors.get(0).getState());
		assertEquals(new JumbledPuzzle("tnAMar"), successors.get(1).getState());
		assertEquals(new JumbledPuzzle("AntMra"),
				successors.get(successors.size() - 1).getState());

	}

	@Test
	public void testGraph() {
		Graph g = new Graph(5, 5);
		g.createBlockage(0, 0, 1, 0);
		assertEquals(null, g.getNode(0, 0).getEast());
		assertEquals(null, g.getNode(1, 0).getWest());

		assertEquals(g.getNode(2, 2).getNorth(), g.getNode(2, 0).getSouth());

	}

	@Test
	public void testRobot() {
		Graph g = new Graph(5, 5);
		RobotPuzzle r = new RobotPuzzle(g, 0, 0, 1, 1);
		g.createBlockage(0, 0, 1, 0);
		assertEquals(false, r.performAction(new RobotMove(1)));
		r.performAction(new RobotMove(2));
		assertEquals(new RobotPuzzle(g, 0, 1, 1, 1), r);
		r.performAction(new RobotMove(1));
		assertEquals(true, r.isGoal(new RobotPuzzle(g, 1, 1, 0, 0)));
	}

	@Test
	public void testRobotSuccessors() {
		Graph g = new Graph(5, 5);
		RobotPuzzle r = new RobotPuzzle(g, 0, 0, 1, 1);

		ArrayList<SearchNode<RobotPuzzle, RobotMove>> successors = (ArrayList<SearchNode<RobotPuzzle, RobotMove>>) r
				.getSuccessors(new SearchNode<RobotPuzzle, RobotMove>(null,
						null, r));
		assertEquals(2, successors.size());
		assertEquals(new RobotPuzzle(g, 1, 0, 1, 1), successors.get(0)
				.getState());
		assertEquals(new RobotPuzzle(g, 0, 1, 1, 1), successors.get(1)
				.getState());
	}
}
