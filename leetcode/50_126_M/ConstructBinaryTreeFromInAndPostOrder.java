import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromInAndPostOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		} 

		@Override
		public String toString() {
			return "" + val;
		}
	}	

	public static TreeNode construct(int[] preorder, int[] inorder) {
		return construct(0, arrayToList(preorder), arrayToList(inorder));
	}

	private static TreeNode construct(int index, List<Integer> preorder, List<Integer> inorder) {
		if (preorder.size() <= 0 || inorder.size() <= 0) return null;

		TreeNode root = new TreeNode(preorder.get(index));
		if (inorder.size() == 1) {
			return root;
		}

		int i = 0;
		while(i < inorder.size()) {
			if (preorder.get(index) == inorder.get(i)) break;
			i++;
		}
		if (i == inorder.size()) return null;

		if (index + 1 >= preorder.size()) return root;

		List<Integer> subLeft = subArray(inorder, 0, i - 1);
		if (subLeft.size() > 0) {
			index++;
			root.left = construct(index, preorder, subLeft);
		}


		List<Integer> subRight = subArray(inorder, i + 1, inorder.size() - 1);
		if (subRight.size() > 0) {
			index++;
			root.right = construct(index, preorder, subRight);
		}
		return root;
	}

	private static List<Integer> subArray(List<Integer> array, int from, int to) {
		List<Integer> list = new ArrayList<Integer>();
 
		for (int i = from; i <= to; i++) {
			list.add(array.get(i));
		}
		return list;
	}

	private static List<Integer> arrayToList(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	private static List<List<TreeNode>> BTLevelTraversalTopDown(TreeNode root) {
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

	public static void main(String[] args) {
		int pre_order[]={'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H'};
    	int  in_order[]={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    	List<List<TreeNode>> r = BTLevelTraversalTopDown(construct(pre_order, in_order));
    	System.out.println(r);
	}

	private static void printList(List<TreeNode> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i).val + " ");
		}
		System.out.println();
	}
}
