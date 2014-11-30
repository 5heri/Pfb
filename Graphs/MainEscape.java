public class MainEscape {
	
	
	public static void main(String[] args) {
		Escape e = new Escape();
		EscapeBFS eb = new EscapeBFS();
		String[] grid = {".........",
						 ".#######.",
						 ".###X...."};
		String[] gridDefault = {".........",
								".........",
								"........X"};

		System.out.println("dfs: " + e.escapeSteps(gridDefault));
		System.out.println("dfs: " + e.escapeSteps(grid));

		System.out.println("bfs: " + eb.escapeStepsBFS(gridDefault));
		System.out.println("bfs: " + eb.escapeStepsBFS(grid));
	}
}
