import java.util.*;

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

		//ArrayList<LinkedList<Node>> lists = createListAtLevelBFS(n5);
		ArrayList<LinkedList<Node>> lists = createListAtLevelRec(n5);

	/*	for (LinkedList<Node> list : lists) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).getValue() + " ");
			}
			System.out.println();
		}*/


		/*
		Node t1 = new Node(1);
		Node t2 = new Node(1);

		System.out.println("t1 == t2 : " + (t1 == t2));
		System.out.println("t1.equals(t2) : " + t1.equals(t2));
		*/

		int[] array = {2,2,3,4,5,6,7};
		Node newRoot = minBST(array);

		lists = createListAtLevelBFS(newRoot);

		/*for (LinkedList<Node> list : lists) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).getValue() + " ");
			}
			System.out.println();
		}*/


		newRoot.getLeft().getLeft().setLeft(new Node(-4));
		newRoot.getRight().getRight().setRight(new Node(-13));
		newRoot.getRight().getRight().setLeft(new Node(1));
		newRoot.getRight().getRight().getLeft().setLeft(new Node(-14));
		newRoot.getRight().getLeft().setRight(new Node(-2));
		newRoot.getRight().getLeft().getRight().setLeft(new Node(-3));
		newRoot.getRight().getLeft().getRight().getLeft().setLeft(new Node(9));

		findSum(newRoot, 4);
	}

	private static void findSum(Node node, int sum) {
		int[] path = new int[depth(node)];
		findSum(node, sum, path, 0);
	}

	private static void findSum(Node node, int sum, int[] path, int level) {
		if (node == null) {
			return;
		}

		path[level] = node.getValue();

		int currentSum = 0;
		for (int i = level; i >= 0; i--) {
			currentSum += path[i];
			if (currentSum == sum) {
				printRange(path, i, level);
			}
		}

		findSum(node.getLeft(), sum, path, level + 1);
		findSum(node.getRight(), sum, path, level + 1);
	}


	private static void printRange(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	private static int depth(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
		}
	}


	private static Node commonAnces(Node root, Node first, Node second) {
		if (!contains(root, first) || !contains(root, second)) {
			return null;
		}
		return commonAncesHelper(root, first, second);
	}

	private static Node commonAncesHelper(Node root, Node first, Node second) {
		if (root == null) {
			return null;
		}

		if (root.equals(first) || root.equals(second)) {
			return root;
		}

		boolean firstOnLeft  = contains(root.getLeft(), first);
		boolean secondOnLeft = contains(root.getRight(), second);

		if (firstOnLeft != secondOnLeft) {
			return root;
		}

		Node onSide = firstOnLeft ? root.getLeft() : root.getRight();

		return commonAncesHelper(onSide, first, second);
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

	private static NodeWithParent getSucc(NodeWithParent node) {
		if (node == null) {
			return null;
		}

		if (node.getRight() != null) {
			return leftMost(node.getRight());
		} else {
			NodeWithParent curr = node;
			NodeWithParent parent = curr.getParent();

			while (parent != null && parent.getLeft() != curr) {
				curr = parent;
				parent = parent.getParent();
			}

			return parent;
		}
	}

	private static NodeWithParent leftMost(NodeWithParent node) {
		if (node == null) {
			return null;
		}

		while (node.getLeft() != null) {
			node = node.getLeft();
		}

		return node;
	}

	private static boolean isBST(Node node) {
		return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.getValue() <= min || node.getValue() > max) {
			return false;
		}

		if (!isBST(node.getLeft(), min, node.getValue()) 
				|| !isBST(node.getRight(), node.getValue(), max)) {
			return false;
		}

		return true;
	}

	private static ArrayList<LinkedList<Node>> createListAtLevelRec(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createListAtLevelRec(root, lists, 0);
		return lists;
	}

	private static void createListAtLevelRec(Node node,
		ArrayList<LinkedList<Node>> lists, int level) {

		if (node == null) {
			return;
		}

		LinkedList<Node> list = null;

		if (lists.size() == level) {
			list = new LinkedList<Node>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}

		list.add(node);
		createListAtLevelRec(node.getLeft(), lists, level + 1);
		createListAtLevelRec(node.getRight(), lists, level + 1);
	}

	private static ArrayList<LinkedList<Node>> createListAtLevelBFS(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

		LinkedList<Node> curr = new LinkedList<Node>();

		if (root != null) {
			curr.add(root);
		}

		while (curr.size() > 0) {
			lists.add(curr);
			LinkedList<Node> parents = curr;
			curr = new LinkedList<Node>();

			for (Node parent : parents) {
				if (parent.getLeft() != null) {
					curr.add(parent.getLeft());
				}

				if (parent.getRight() != null) {
					curr.add(parent.getRight());
				}
			}
		}
		return lists;
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
