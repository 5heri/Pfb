import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static List<Integer> preOrderTraversalITR(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				result.add(node.val);
				if (node.right != null) stack.push(node.right);
				node = node.left;
			} else {
				node = stack.pop();
			}
		}
		return result;
	}	

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n1.right = n2;
		n2.left = n3;

		System.out.println(preOrderTraversalITR(n1));
	}
}
