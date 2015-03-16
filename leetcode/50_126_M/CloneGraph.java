import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CloneGraph {
	
	class UndirectedGraphNode {
    	int label;
    	List<UndirectedGraphNode> neighbors;
    	UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
    	}
  	}

  	public UndirectedGraphNode clone(UndirectedGraphNode node) {
  		if (node == null) return null;

  		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
  		Map<UndirectedGraphNode, UndirectedGraphNode> map = 
  						new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

  		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

  		queue.add(node);
  		map.put(node, newHead);

  		while (!queue.isEmpty()) {
  			UndirectedGraphNode curr = queue.pop();
  			List<UndirectedGraphNode> currNeighbors = curr.neighbors;

  			for (UndirectedGraphNode n : currNeighbors) {
  				if (!map.containsKey(n)) {
  					UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
  					map.put(n, copy);
  					map.get(curr).neighbors.add(copy);
  					queue.add(n);
  				} else {
  					map.get(curr).neighbors.add(map.get(n));
  				}
  			}
  		}
  		return newHead;
  	}
	
}
