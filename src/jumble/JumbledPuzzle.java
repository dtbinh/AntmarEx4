package jumble;

import interfaces.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import jumble.JumbledMove;
import jumble.JumbledPuzzle;
import util.SearchNode;

public class JumbledPuzzle implements Puzzle<JumbledPuzzle, JumbledMove> {

	private final int wordLength;
	private final String initial;
	private final char[] word;
	private final ArrayList<JumbledMove> moves = new ArrayList<JumbledMove>();

	public JumbledPuzzle(String word) {
		this.word = word.toCharArray();
		this.initial = word;
		this.wordLength = word.length();
		setPossibleMoves();
	}

	public JumbledPuzzle(JumbledPuzzle j) {
		word = new char[j.word.length];
		for (int i = 0; i < word.length; i++) {
			word[i] = j.word[i];
		}
		this.initial = j.initial;
		this.wordLength = j.word.length;
		setPossibleMoves();
	}

	public static JumbledPuzzle randomJumbledPuzzle(String word) {
		return randomJumbledPuzzle(word, word.length());
	}

	public static JumbledPuzzle randomJumbledPuzzle(String word, int swaps) {
		JumbledPuzzle j = new JumbledPuzzle(word);
		for (int i = 0; i < swaps; i++) {
			j.randomMove();
		}
		j.setPossibleMoves();
		return j;

	}

	public void setPossibleMoves() {
		for (int i = 0; i < wordLength - 1; i++) {
			for (int j = i + 1; j < wordLength; j++) {
				moves.add(new JumbledMove(i, j));
			}
		}
	}

	public void randomMove() {
		int swapA = new Random().nextInt(wordLength);
		int swapB = (new Random().nextInt(wordLength - 1) + 1 + swapA)
				% wordLength;
		performAction(new JumbledMove(swapA, swapB));
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < word.length; i++) {
			s += word[i];
		}
		return s;
	}

	@Override
	public boolean equals(Object _that) {
		if (_that instanceof JumbledPuzzle) {
			JumbledPuzzle that = (JumbledPuzzle) _that;
			return Arrays.equals(that.word, this.word);
		}

		return false;

	}

	public int getWordLength() {
		return this.wordLength;
	}

	@Override
	public int h() {
		int h = 0;
		for (int i = 0; i < initial.length(); i++) {
			if (initial.charAt(i) != word[i])
				h++;
		}

		return 0;
	}

	@Override
	public boolean performAction(JumbledMove action) {
		if (isPossibleMove(action)) {
			int swapA = action.getA();
			int swapB = action.getB();

			char temp = word[swapA];
			word[swapA] = word[swapB];
			word[swapB] = temp;
			return true;
		}
		return false;
	}

	@Override
	public boolean isGoal(JumbledPuzzle goal) {

		return equals(goal);
	}

	@Override
	public List<SearchNode<JumbledPuzzle, JumbledMove>> getSuccessors(
			SearchNode<JumbledPuzzle, JumbledMove> s) {
		ArrayList<SearchNode<JumbledPuzzle, JumbledMove>> successors = new ArrayList<SearchNode<JumbledPuzzle, JumbledMove>>();
		for (JumbledMove m : moves) {
			JumbledPuzzle successor = new JumbledPuzzle(this);
			successor.performAction(m);

			successors.add(new SearchNode<JumbledPuzzle, JumbledMove>(s, m,
					successor));
		}
		return successors;
	}

	@Override
	public boolean isPossibleMove(JumbledMove action) {
		return action.getA() < word.length && action.getB() < word.length;
	}

}
