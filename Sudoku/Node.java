package Sudoku;

public class Node {
	private int x, y, value;
	
	public Node() {}
	
	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	public Node(Node node) {
		x = node.getX();
		y = node.getY();
		value = node.getValue();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
