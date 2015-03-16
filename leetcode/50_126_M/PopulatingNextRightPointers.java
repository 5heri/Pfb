public class PopulatingNextRightPointers {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		TreeNode(int val) {
			this.val = val;
		}
	}	

	public void setNextRightPointers(TreeNode root) {
		if (root == null)	return;

		if (root.left != null && root.right != null) {
			root.left.next = root.right;
		}

		if (root.next != null && root.right != null) {
			root.right.next = root.next.left;
		}

		setNextRightPointers(root.left);
		setNextRightPointers(root.right);
	}
	
}
