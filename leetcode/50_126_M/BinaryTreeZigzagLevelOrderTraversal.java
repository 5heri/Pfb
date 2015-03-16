import java.util.List;
import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {


	/* THIS IS CORRECT 
 
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();  
        Stack<TreeNode> nextLevel = new Stack<TreeNode>(); 
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;
        
        while (!currLevel.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<Integer>();
            
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                
                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            res.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }
        return res;
    }
}



	*/

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}	

	public static List<List<TreeNode>> zigzagLevelOrderTraversal(TreeNode root) {
		List<List<TreeNode>> results = new ArrayList<List<TreeNode>>();
		if (root == null) return results;
		
		
		// 2 lists
		// 1 for keep actual pattern to look up from
		// 1 for zigzag pattern to return 
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<TreeNode> getCurrent = new ArrayList<TreeNode>();

		getCurrent.add(root);
		current.add(root);
		int currentLevel = 1;

		while (!getCurrent.isEmpty()) {
			results.add(current);

			List<TreeNode> parents = getCurrent;
			getCurrent = new ArrayList<TreeNode>();
			current = new ArrayList<TreeNode>();

			for (TreeNode p : parents) {
				if (currentLevel % 2 == 0) {
					if (p.left != null) {
						current.add(p.left);
					}
					if (p.right != null) {
						current.add(p.right);
					}
				} else {
					if (p.right != null) {
						current.add(p.right);
					}
					if (p.left != null) {
						current.add(p.left);
					}
				}
				if (p.left != null) {
					getCurrent.add(p.left);
				}
				if (p.right != null) {
					getCurrent.add(p.right);
				}
			}
			currentLevel++;
		}
		return results;
	}

	public static void main(String[] args) {
		//int[] array = {1,2,3,4,5,6,7,8,9};
		/*TreeNode n3 = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);

		n3.left = n9;
		n3.right = n20;
		n20.left = n15;
		n20.right = n7;
		System.out.println(zigzagLevelOrderTraversal(n3)); */

		TreeNode n5 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n7 = new TreeNode(7);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n8 = new TreeNode(8);
		TreeNode n17 = new TreeNode(17);
		TreeNode n15 = new TreeNode(15);
		TreeNode n4 = new TreeNode(4);
		TreeNode n9 = new TreeNode(9);

		n5.left = n2;
		n5.right = n7;
		n2.left = n1;
		n2.right = n3;
		n7.left = n6;
		n7.right = n8;
		n3.left = n17;
		n6.left = n15;
		n8.right = n9;

		System.out.println(zigzagLevelOrderTraversal(n5));


	}

	private static TreeNode createTree(int[] array) {
		return createTree(array, 0, array.length - 1);
	}

	private static TreeNode createTree(int[] array, int start, int end) {
		if (end < start) return null;

		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = createTree(array, start, mid - 1);
		node.right = createTree(array, mid + 1, end);
		return node;
	}
}
