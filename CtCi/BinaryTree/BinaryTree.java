public class BinaryTree {
	
	private Node root;

	public boolean isEmpty() {
		return root == null;
	}

	public Node getRoot() {
		return root;
	}

	public int getRootValue() {
		return root.getValue();
	}

	public void insert(int value) {
		insert(root, value);
	}

	private Node insert(Node node, int value) {
		if (node == null) {
			node = new Node(value);
		} else if (node.getValue() >= value) {
			node.setLeft(insert(node.getLeft(), value));
		} else if (node.getValue() < value) {
			node.setRight(insert(node.getRight(), value));
		}
		return node;
	}

	public void preOrderPrint() {
		preOrderPrint(root);
		System.out.println();
	}

	public void inOrderPrint() {
		inOrderPrint(root);
		System.out.println();
	}

	public void postOrderPrint() {
		postOrderPrint(root);
		System.out.println();
	}

	private void preOrderPrint(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			preOrderPrint(node.getLeft());
			preOrderPrint(node.getRight());
		}
	}

	private void inOrderPrint(Node node) {
		if (node != null) {
			inOrderPrint(node.getLeft());
			System.out.print(node.getValue() + " ");
			inOrderPrint(node.getRight());
		}
	}

	private void postOrderPrint(Node node) {
		if (node != null) {
			postOrderPrint(node.getLeft());
			postOrderPrint(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}
}
