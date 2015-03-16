public class BinaryTreeUpsideDown {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}	

	public TreeNode upsideDownifyTree(TreeNode root) {
		TreeNode dummy = new TreeNode(0);
		TreeNode head = dummy;
		TreeNode left = null;
		TreeNode right = null;

		while (root != null) {
			left = root.right;
			right = root;
			root = root.left;

			right.left = head.left;
			right.right = head.right;

			dummy.right = right;
			dummy.left = left;

			head = dummy;
		}
		return head.right;
	}
}
