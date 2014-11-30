import java.util.List;
import java.util.LinkedList;

public class EscapeBFS {
	
	private static final int[][] DIRS = {{-1,0},{0,1},{1,0},{0,-1}};
	
	boolean[][] visited;
	int endX;
	int endY;

	public int escapeStepsBFS(String[] grid) {
		findEnd(grid);
		visited = new boolean[grid.length][grid[0].length()];

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node top = q.remove();
			//System.out.println(top.x + " " + top.y);

			//if (/*inGrid(top.x, top.y, grid) && */!visited[top.y][top.x]
			//		&&  grid[top.y].charAt(top.x) != '#') {
				if (top.x == endX && top.y == endY) {
					return top.steps;
				}

				for (int i = 0; i < DIRS.length; i++) {
					int newX = top.x + DIRS[i][0];
					int newY = top.y + DIRS[i][1];
					if (inGrid(newX, newY, grid) && !visited[newY][newX]
							&& grid[newY].charAt(newX) != '#') {
						q.add(new Node(newX, newY, top.steps + 1));
						visited[newY][newX] = true;
					}

					
					
				}
		//	}

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
