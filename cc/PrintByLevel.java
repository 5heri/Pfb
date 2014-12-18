import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class PrintByLevel {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void printByLevelDiffLine(Node root) {
		if (root == null) return;

		List<Node> curr = new ArrayList<Node>();
		curr.add(root);

		while (!curr.isEmpty()) {
			printList(curr);
			List<Node> parents = curr;
			curr = new ArrayList<Node>();

			for (Node parent : parents) {

				if (parent.left != null) {
					curr.add(parent.left);
				} 
				if (parent.right != null) {
					curr.add(parent.right);
				}
			}
		}
	}

	private static void printList(List<Node> l) {
		if (l.isEmpty()) {
			System.out.println("");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(l.get(0).data);
		for (int i = 1; i < l.size(); i++) {
			sb.append(" " + l.get(i).data);
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(10);
		root.left.right = new Node(11);
		root.right.left = new Node(7);
		root.right.right = new Node(3);

		printByLevelDiffLine(root);
	}
	
}
