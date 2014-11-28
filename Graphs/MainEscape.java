public class MainEscape {
	
	
	public static void main(String[] args) {
		Escape e = new Escape();
		String[] grid = {".........",
						 ".#######.",
						 ".###X...."};
		String[] gridDefault = {".........",
								".........",
								"........X"};

		System.out.println(e.escapeSteps(gridDefault));
		System.out.println(e.escapeSteps(grid));
	}
}
