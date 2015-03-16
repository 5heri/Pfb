public class MinimumDepthOfBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static int minDepth(TreeNode root) {
		if (root == null) return 0;

		if (root.left == null && root.right == null) return 1;

		int leftDepth = Integer.MAX_VALUE;
		if (root.left != null) {
			leftDepth = minDepth(root.left) + 1;
		}
		int rightDepth = Integer.MAX_VALUE;
		if (root.right != null) {
			rightDepth = minDepth(root.right) + 1;
		}

		return Math.min(leftDepth, rightDepth);
	}

	public static void main(String[] args) {
		TreeNode r0 = new TreeNode(1);

		TreeNode r1 = new TreeNode(5);
		TreeNode r2 = new TreeNode(6);
		TreeNode r3 = new TreeNode(29);
		TreeNode r4 = new TreeNode(2);
		TreeNode r5 = new TreeNode(3);

		r3.left = r4;
		r4.left = r5;
		r2.right = r3;
		r2.left = r1;
		r0.left = r2;
		System.out.println(minDepth(r0));

		r0.right = new TreeNode(10);
		System.out.println(minDepth(r0));
	}

}

