public class BinaryTreeMain {
	
	public static void main(String[] args) {
		Node n12 = new Node(12);
		Node n3 = new Node(3);
		Node n6 = new Node(6);
		Node n11 = new Node(11);
		Node n4 = new Node(4);

		n11.setLeft(n12);
		n4.setRight(n6);

		Node n2 = new Node(2, n3, n11);
		Node n5 = new Node(5, n2, n4);

		//n12.setLeft(new Node(2)); // remove to balance

		if (isBalanced(n5)) {
			System.out.println("Balanced!");
		} else {
			System.out.println("Not Balanced!");
		}
	}

	private static Node minBST(int[] array) {
		return minBST(array, 0, array.length - 1);
	}

	private static Node minBST(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		Node n = new Node(array[mid]);
		n.setLeft(minBST(array, start, mid - 1));
		n.setRight(minBST(array, mid + 1, end));
		return n;
	}


	private static boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}

		int heightDiff = Math.abs(getHeight(root.getLeft()) 
										- getHeight(root.getRight()));

		if (heightDiff > 1) {
			return false;
		} else {
			return isBalanced(root.getLeft()) && isBalanced(root.getRight());
		}
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.getLeft()), 
								getHeight(root.getRight()));  
	}


}
