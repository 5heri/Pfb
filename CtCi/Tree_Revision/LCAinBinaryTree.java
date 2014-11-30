public class LCAinBinaryTree {
	
	
	public Node lowestCommonAncester(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}

		return LCAhelper(root, p, q);
	}

	private Node LCAhelper(Node root, Node p, Node q) {
		if (root == null) return null;
		if (root == p || root == q) return root;

		boolean pLeft = covers(root.getLeft(), p);
		boolean qLeft = covers(root.getLeft(), q);

		if (pLeft != qLeft) return root;

		Node onSide = pLeft ? root.getLeft() : root.getRight();
		return LCAhelper(onSide, p, q);
	}

	private boolean covers(Node root, Node p) {
		if (root == null) return false;
		if (root == p) return true;

		return covers(root.getLeft(), p) || covers(root.getRight(), p);
	}
	
} 
