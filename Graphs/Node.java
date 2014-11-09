public class Node {
	
	private int value;
	private Node next;

	public Node(int value) {
		this.value = value;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

	public void setNext(Node node) {
		next = node;
	}

	public int getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}
}
