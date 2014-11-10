import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class GraphMatrix {
	
	private int n;
	private boolean[][] adjMatrix;

	public GraphMatrix(int n) {
		this.n = n;
		adjMatrix = new boolean[n][n];
	}

	public void addEdge(int from, int to) {
		adjMatrix[from - 1][to - 1] = true;
		adjMatrix[to - 1][from - 1] = true;
	}

	public void removeEdge(int from, int to) {
		adjMatrix[from - 1][to - 1] = false;
		adjMatrix[to - 1][from - 1] = false;
	}

	public boolean hasEdge(int from, int to) {
		return adjMatrix[from - 1][to - 1];
	}

	public List<Integer> connectedTo(int v) {
	 	List<Integer> connections = new ArrayList<Integer>();
		for (int j = 0; j < n; j++) {
			if (adjMatrix[v - 1][j]) {
				connections.add(j + 1);	
			}
		}
		return connections;
	} 

	public String display() {
		StringBuilder sb = new StringBuilder();

		for (int v = 1; v <= n; v++) {
			sb.append(v + ": ");
			List<Integer> connections = connectedTo(v);

			for (Integer c : connections) {
				sb.append(c + " ");
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("# ");
		for (int i = 0; i < n; i++) {
			sb.append(i + 1 + " ");
		}
		sb.append('\n');

		for (int row = 0; row < n; row++) {
			sb.append(row + 1 + " ");
			for (int col = 0; col < n; col++) {
				if (adjMatrix[row][col]) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append(" ");
			}
			sb.append('\n');
		}
		return sb.toString();
	}

}
