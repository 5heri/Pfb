public class Main {
	

	public static void main(String[] args) {

		Graph g = new Graph(5);

		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);

		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(2, 5);
		g.addEdge(5, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		System.out.println(g);

		g.removeEdge(1, 5);

		System.out.println(g);

		g.addEdge(1, 5);

		System.out.println(g);

		g.removeVertex(2);

		System.out.println(g);

	}

}
