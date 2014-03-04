package jumble;

public class JumbledMove {
	private final int swapA;
	private final int swapB;
	
	public JumbledMove(int A, int B){
		this.swapA = A;
		this.swapB = B;
	}
	
	
	public String toString(){
		return "Swap pos: " + (swapA + 1) + " with pos: " + (swapB + 1);
	}
	
	public int getA(){
		return swapA;
	}
	
	public int getB(){
		return swapB;
	}
}
