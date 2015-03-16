public class ConvertSortedArrayToBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}		

	public TreeNode createTree(int[] array) {
		return createTree(array, 0, array.length - 1);
	}

	private TreeNode createTree(int[] array, int start, int end) {
		if (end < start) return null;

		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = createTree(array, start, mid - 1);
		node.right = createTree(array, mid + 1, end);
		return node;
	}
}
