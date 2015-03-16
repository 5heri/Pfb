import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}	

	public static List<Integer> inorderTraversalITR(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				results.add(node.val);
				node = node.right;
			}
		}

		return results;
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(result, root);
		return result;
	}

	private static void inorderTraversal(List<Integer> l, TreeNode n) {
		if (n != null) {
			inorderTraversal(l, n.left);
			l.add(n.val);
			inorderTraversal(l, n.right);
		}
		
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n1.right = n2;
		n2.left = n3;

		System.out.println(inorderTraversal(n1));
		System.out.println(inorderTraversalITR(n1));
	}
}

