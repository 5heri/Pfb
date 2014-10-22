import java.util.*;

public class PrintTreeByLevel {
	
	public static void main(String[] args) {
		Node root = new Node(5);
		root.setLeft(new Node(2));
		root.setRight(new Node(4));
		root.getLeft().setLeft(new Node(10));
		root.getLeft().setRight(new Node(11));
		root.getRight().setLeft(new Node(7));
		root.getRight().setRight(new Node(3));

		printTreeByLevelOnSameLine(root);
		printTreeByLevelOnDiffLine(root);
	}

	private static void printTreeByLevelOnDiffLine(Node root) {
		if (root == null) {
			return;
		}

		LinkedList<Node> curr = new LinkedList<Node>();
		curr.add(root);

		while (!curr.isEmpty()) {
			printList(curr);
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
	}

	private static void printList(LinkedList<Node> l) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l.size() - 1; i++) {
			sb.append(l.get(i).getValue());
			sb.append(' ');
		}
		sb.append(l.get(l.size() - 1).getValue());
		System.out.println(sb.toString());
	}

	private static void printTreeByLevelOnSameLine(Node root) {
		if (root == null) {
			return;
		}

		LinkedList<Node> nodes = new LinkedList<Node>();

		nodes.add(root);

		while (!nodes.isEmpty()) {
			Node curr = nodes.removeFirst();
			
			if (curr.getLeft() != null) {
				nodes.add(curr.getLeft());
			}
			if (curr.getRight() != null) {
				nodes.add(curr.getRight());
			}
			System.out.print(curr.getValue() + " ");
		}
		System.out.println();
	}
}
