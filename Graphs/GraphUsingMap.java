import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;

public class GraphUsingMap {

	private Map<Integer, Set<Integer>> adjacencyList;

	public GraphUsingMap() {
		this.adjacencyList = new HashMap<Integer, Set<Integer>>();
	}

	public void addVertex(int vertex) {
		adjacencyList.put(new Integer(vertex), new HashSet<Integer>());
	}

	public void removeVertex(int toRemove) {
		adjacencyList.remove(toRemove);
		Set<Integer> vertexs = adjacencyList.keySet();

		for (Integer v : vertexs) {
			adjacencyList.get(v).remove(toRemove);
		}
	}

	public void addEdge(int from, int to) {
		adjacencyList.get(from).add(new Integer(to));
		adjacencyList.get(to).add(new Integer(from));
	}

	public void removeEdge(int from, int to) {
		adjacencyList.get(from).remove(to);
		adjacencyList.get(to).remove(from);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Set<Integer> vertexs = adjacencyList.keySet();

		for (Integer vertex : vertexs) {
			Set<Integer> connectedTo = adjacencyList.get(vertex);

			sb.append(vertex + ":  ");
			for (Integer connection : connectedTo) {
				sb.append(connection + " ");
			}
			sb.append('\n');
		}
		return sb.toString();

	}
}
