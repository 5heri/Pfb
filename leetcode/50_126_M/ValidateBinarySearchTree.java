public class ValidateBinarySearchTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}	

	public boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST(TreeNode node, int min, int max) {
		if (node == null) return true;

		if (node.val <= min || node.val > max) {
			return false;
		}

		if (!checkBST(node.left, min, node.val) || !checkBST(node.right, node.val, max)) {
			return false;
		}
		return true;
	}
}
