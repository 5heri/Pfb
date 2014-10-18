public class NodeWithParent {

	private NodeWithParent parent;
	private NodeWithParent left;
	private NodeWithParent right;

	private int value;

	public NodeWithParent(int value) {
		this.value = value;
	}

	public NodeWithParent (int value, NodeWithParent parent,
			NodeWithParent left, NodeWithParent right) {
		this.value  = value;
		this.parent = parent;
		this.left   = left;
		this.right  = right;

	}

	public void setValue(int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public void setParent(NodeWithParent newParent) {
		parent = newParent;
	}

	public NodeWithParent getParent() {
		return parent;
	}

	public void setLeft(NodeWithParent newLeft) {
		left = newLeft;
	}

	public NodeWithParent getLeft() {
		return left;
	}

	public void setRight(NodeWithParent newRight) {
		right = newRight;
	} 

	public NodeWithParent getRight() {
		return right;
	}
}
