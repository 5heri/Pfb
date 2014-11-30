import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class LevelLinkedList {
	
	public List<List<Node>> levelList(Node root) {

		List<List<Node>> results = new ArrayList<List<Node>>();
		List<Node> curr = new LinkedList<Node>();
		if (root != null) {
			curr.add(root);
		}

		while (!curr.isEmpty()) {
			results.add(curr);
			List<Node> parents = curr;
			curr = new LinkedList<Node>();

			for (Node p : parents) {
				if (p.getLeft() != null) {
					curr.add(p.getLeft());
				}
				if (p.getRight() != null) {
					curr.add(p.getRight());
				}
			}
		}
		return results;
	}

}
