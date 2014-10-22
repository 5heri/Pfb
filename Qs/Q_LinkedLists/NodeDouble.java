public class NodeDouble {
	
	private int value;
	private NodeDouble prev;
	private NodeDouble next;

	public NodeDouble(int value) {
		this.value = value;
	}

	public NodeDouble(int value, NodeDouble prev, NodeDouble next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public NodeDouble getPrev() {
		return prev;
	}

	public NodeDouble getNext() {
		return next;
	}

	public void setValue(int newValue) {
		value = newValue;
	}

	public void setPrev(NodeDouble newPrev) {
		prev = newPrev;
	}

	public void setNext(NodeDouble newNext) {
		next = newNext;
	}
}
