public class MainGraphMatrix {
	
	public static void main(String[] args) {
		GraphMatrix g = new GraphMatrix(5);

		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(2, 5);
		g.addEdge(5, 4);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		System.out.println(g);
		System.out.println(g.display());

		g.removeEdge(1, 5);
		System.out.println(g);
		System.out.println(g.display());

		g.addEdge(1, 5);
		System.out.println(g);
		System.out.println(g.display());
	}
}
