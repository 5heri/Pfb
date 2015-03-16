public class MaximumDepthOfBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) return 0;

		if (root.left == null && root.right == null) return 1;

		int leftD = Integer.MIN_VALUE;
		if (root.left != null) {
			leftD = maxDepth(root.left) + 1;
		}

		int rightD = Integer.MIN_VALUE;
		if (root.right != null) {
			rightD = maxDepth(root.right) + 1;
		}
		return Math.max(leftD, rightD);
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
		System.out.println(maxDepth(r0));

		r5.right = new TreeNode(10);
		System.out.println(maxDepth(r0));




	}
	
}
