import java.util.Stack;

public class Escape {

	private static final int[][] DIRS = {{-1,0},{0,1},{1,0},{0,-1}};
	
	boolean[][] visited;
	int endX;
	int endY;

	public int escapeSteps(String[] grid) {
		findEnd(grid);
		visited = new boolean[grid.length][grid[0].length()];

		Stack<Node> s = new Stack<Node>();
		s.push(new Node(0,0,0));

		while(!s.isEmpty()) {
			Node top = s.pop();
			//System.out.println(top.x + " " + top.y);
			if (inGrid(top.x, top.y, grid) && !visited[top.y][top.x]
					&& grid[top.y].charAt(top.x) != '#') {
				if (top.x == endX && top.y == endY) {
					return top.steps;
				}
				visited[top.y][top.x] = true;

				for (int i = 0; i < DIRS.length; i++) {
					s.push(new Node(top.x + DIRS[i][0], 
									top.y + DIRS[i][1],
									top.steps + 1));
				}

			}
			

		}
		return -1;

	}

	private void findEnd(String[] grid) {
		endX = grid[0].length()-1;
		endY = grid.length-1;
		for (int j = 0; j < grid.length; j++) {
			for (int i = 0; i < grid[0].length(); i++) {
				if (grid[j].charAt(i) == 'X') {
					endX = i;
					endY = j;
					return;
				}
			}
		}
	}

	private boolean inGrid(int x, int y, String[] grid) {
		return x >= 0 && x < grid[0].length()
			&& y >= 0 && y < grid.length;
	}

	class Node {
		int x, y, steps;

		public Node(int x, int y, int steps) {
			this.x = x;
			this.y = y;
			this.steps = steps;
		}

	}

}

