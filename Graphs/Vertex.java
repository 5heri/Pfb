public class Vertex {
	
	private int value;
	private Node adjList;

	public Vertex(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public Node getAdjList() {
		return adjList;
	}

	public void setAdjList(Node adjList) {
		this.adjList = adjList;
	}

}
