import java.util.Stack;

public class Traversal {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public void preOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(node);

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				visit(node);
				if (node.right != null) stack.push(node.right);
				node = node.left;
			} else {
				node = stack.pop();
			}
		}
	}

	public void inOrder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(node);

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				visit(node);
				node = node.right;
			}
		}
		
	}
}