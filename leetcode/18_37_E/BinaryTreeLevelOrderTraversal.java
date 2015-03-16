import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<List<TreeNode>> BTLevelTraversalTopDown(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
		List<TreeNode> current = new ArrayList<TreeNode>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(current);

			List<TreeNode> parents = current;
			current = new ArrayList<TreeNode>();

			for (TreeNode p : parents) {
				if (p.left != null) {
					current.add(p.left);
				}
				if (p.right != null) {
					current.add(p.right);
				}
			}
		}
		return result;
	}

	// Same idea, just add the current to start of results instead of end
	public List<List<TreeNode>> BTLevelTraversalBottomUp(TreeNode root) {
		List<List<TreeNode>> result = new LinkedList<List<TreeNode>>();
		List<TreeNode> current = new ArrayList<TreeNode>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			result.add(0, current);

			List<TreeNode> parents = current;
			current = new ArrayList<TreeNode>();

			for (TreeNode p : parents) {
				if (p.left != null) {
					current.add(p.left);
				}
				if (p.right != null) {
					current.add(p.right);
				}
			}
		}
		return result;
	}
	
}
