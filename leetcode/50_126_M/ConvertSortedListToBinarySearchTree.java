public class ConvertSortedListToBinarySearchTree {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		for (ListNode p = head; p != null; p = p.next) {
			length++;
		}
		return sortedListToBST(0, length - 1, head);
	}

	private TreeNode sortedListToBST(int low, int high, ListNode node) {
		if (low > high || node == null)  return null;

		int mid = low + (high - low)/2;

		TreeNode leftChild = sortedListToBST(low, mid - 1, node);
		TreeNode currNode = new TreeNode(node.val);
		currNode.left = leftChild;
		node = node.next;
		TreeNode rightChild = sortedListToBST(mid + 1, high, node);
		currNode.right = rightChild;

		return currNode;
	}
}
