public class Node {

	private int value;
	private Node next;

	public Node(int value) {
		this.value = value;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public void setNext(Node newNext) {
		next = newNext;
	}

	public Node getNext() {
		return next;
	}
}
