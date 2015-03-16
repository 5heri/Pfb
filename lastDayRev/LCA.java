public class LCA {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}	

	private boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p || root == q) return root;

		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);

		if (is_p_on_left != is_q_on_left) return root;

		TreeNode onSide = is_p_on_left ? root.left : root.right;

		return lca(onSide, p, q); 
	}

	public TreeNode lowestCommonAnc(TreeNode root, TreeNode p, TreeNode q) {
		if (!(covers(root, p) && covers(root, q))) return null;
		return lca(root, p, q);
	}

}
