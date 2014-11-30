public class Node {

	private Node left;
	private Node right;

	private int value;

	public Node(int value) {
		this.value = value;
	}

	public Node (int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;

	}

	public void setValue(int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public void setLeft(Node newLeft) {
		left = newLeft;
	}

	public Node getLeft() {
		return left;
	}

	public void setRight(Node newRight) {
		right = newRight;
	} 

	public Node getRight() {
		return right;
	}

}
