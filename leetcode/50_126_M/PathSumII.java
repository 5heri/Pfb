import java.util.List;
import java.util.ArrayList;

public class PathSumII {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public List<List<Integer>> generateSums(TreeNode root, int sum) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		generateSums(root, sum, path, results);
		return results;
	}

	private void generateSums(TreeNode node, int sum, List<Integer> path, 
									List<List<Integer>> results) {

		if (node == null) return ;

		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				path.add(node.val);
				results.add(path);
			}
			return;
		}

		path.add(node.val);

		if (node.left != null) {
			generateSums(node.left, sum - node.val, path, results);
		} 

		if (node.right != null) {
			generateSums(node.right, sum - node.val, path, results);
		}
	}
}
