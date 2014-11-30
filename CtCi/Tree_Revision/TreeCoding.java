import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class TreeCoding {


	/* 
	 Works using Heaps concept
	 tree is encoded to become a complete tree heap using '#' 
	 where child is null
	
	 tree is decoded with same concept 
	 leftChild = currentIndex * 2 + 1
	 rightChild = currentIndex * 2 + 2
	 if currentIndex results in a null Node
	 just find the next non-null node and swap 
	 it with currentIndex and loop for currentIndex again
	 */
	
	public String encode(Node node) {
		LinkedList<Node> st = new LinkedList<Node>();
		StringBuilder sb = new StringBuilder();
		st.add(node);

		sb.append(node.getValue());

		while (!st.isEmpty()) {
			Node top = st.remove();
			sb.append(' ');
			if (top.getLeft() != null) {
				sb.append(top.getLeft().getValue());
				st.add(top.getLeft());
			} else {
				sb.append('#');
			}
			sb.append(' ');
			
			if (top.getRight() != null) {
				sb.append(top.getRight().getValue());
				st.add(top.getRight());
			} else {
				sb.append('#');
			}
		}
		return sb.toString();
	}


	public Node decode(String str) {
		String[] values = str.split("\\s");
		List<Node> nodes = new ArrayList<Node>();

		for (String value : values) {
			if (!value.equals("#")) {
				nodes.add(new Node(Integer.parseInt(value)));
			} else {
				nodes.add(null);
			}
		}
		for (int i = 0; 2 * i + 2 < nodes.size(); i++) {
			Node n = nodes.get(i);
			if (n != null) {
				n.setLeft(nodes.get(2 * i + 1));
				n.setRight(nodes.get(2 * i + 2));
			} else {
				int c = i;
				while (n == null) {
					c++;
					n = nodes.get(c);
				}
				nodes.set(i, n);
				nodes.set(c, null);
				i--;
			}
		}
		return nodes.get(0);
	}

}
