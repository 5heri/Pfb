public class LCA {
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.setLeft(new Node(2));
		root.setRight(new Node(4));
		root.getLeft().setLeft(new Node(10));
		root.getLeft().setRight(new Node(11));
		root.getRight().setLeft(new Node(7));
		root.getRight().setRight(new Node(3));

		Node result = lowestCommonAnces(root, new Node(11), new Node(7));

		System.out.println(result.getValue());
	}

	private static Node lowestCommonAnces(Node root, Node n1, Node n2) {
		if (!contains(root, n1) || !contains(root, n2)) {
			return null;
		}
		return lowestCommonAncesHelper(root, n1, n2);
	}

	private static Node lowestCommonAncesHelper(Node root, Node n1, Node n2) {
		if (root == null) {
			return null;
		}

		if (root.equals(n1) || root.equals(n2)) {
			return root;
		}

		boolean n1OnLeft = contains(root.getLeft(), n1);
		boolean n2OnLeft = contains(root.getLeft(), n2);

		if (n1OnLeft != n2OnLeft) {
			return root;
		}

		Node bothOnSide = n1OnLeft ? root.getLeft() : root.getRight();

		return lowestCommonAncesHelper(bothOnSide, n1, n2);
	}

	private static boolean contains(Node root, Node node) {
		if (root == null) {
			return false;
		}

		if (root.equals(node)) {
			return true;
		}

		return contains(root.getLeft(), node) 
				|| contains(root.getRight(), node);
	}
}

