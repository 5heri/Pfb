import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
	// should work, logic checks out
	public static void flatten(TreeNode root) {
		if (root == null) return;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode prev = null;
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (prev == null) prev = curr;

			if (curr.right != null) stack.push(curr.right);
			if (curr.left != null) stack.push(curr.left);

			//if (prev != null) {
				prev.left = null;
				prev.right = curr;
				prev = prev.right;
			//} else {
			//	prev = curr;
			//}
		}
		//prev.right = null;
	}	

	public static void main(String[] args) {

	}
}
