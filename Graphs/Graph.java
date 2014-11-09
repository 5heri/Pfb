import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class Graph {
	
	private List<Vertex> adjacentLists;

	public Graph(int capacity) {
		adjacentLists = new ArrayList<Vertex>(capacity);
	}

	public void addVertex(int value) {
		Vertex v = new Vertex(value);
		adjacentLists.add(value - 1, v);
	}

	// Assuming a vertex can be connected to another vertex only once
	public void removeVertex(int toRemove) {
		for (Vertex v : adjacentLists) {
			remove(v, toRemove);
		}
		adjacentLists.set(toRemove - 1, null);
	} 

	public void addEdge(int from, int to) {

		Node newEdge = new Node(to);
		Vertex fromV = adjacentLists.get(from - 1);

		if (fromV.getAdjList() == null) {
			fromV.setAdjList(newEdge);
		} else {
			newEdge.setNext(fromV.getAdjList());
			fromV.setAdjList(newEdge);
		}

		newEdge = new Node(from);
		Vertex toV = adjacentLists.get(to - 1);

		if (toV.getAdjList() == null) {
			toV.setAdjList(newEdge);
		} else {
			newEdge.setNext(toV.getAdjList());
			toV.setAdjList(newEdge);
		}
	}

	// Assume Vertex -from- and Vertex -to- are in the Graph
	public void removeEdge(int from, int to) {

		Vertex fromV = adjacentLists.get(from - 1);
		remove(fromV, to);

		// Since edges may be in both directions

		Vertex toV = adjacentLists.get(to - 1);
		remove(toV, from);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Vertex v : adjacentLists) {
			if (v != null) {
				sb.append(v.getValue() + ":  ");

				Node curr = v.getAdjList();
				while (curr != null && curr.getNext() != null) {
					sb.append(curr.getValue() + "->");
					curr = curr.getNext();
				}
				if (curr != null) {
					sb.append(curr.getValue());	
				}
				sb.append('\n');
			}	
		}
		return sb.toString();
	}

	// Remove -value- from the adjancency list of -v-
	private void remove(Vertex v, int value) {
		Node vHead = v.getAdjList();
		if (vHead.getValue() == value) {
			vHead = vHead.getNext();
			v.setAdjList(vHead);
		} else {
			Node prev = findPrev(vHead, value);
			if (prev.getNext() == null) {
				return; // there is no edge
			}
			prev.setNext(prev.getNext().getNext());
		}
	}

	private Node findPrev(Node head, int value) {
		Node prev = head;

		while (prev.getNext() != null
			&& prev.getNext().getValue() != value) {
			prev = prev.getNext();
		}
		return prev;
	}

}
