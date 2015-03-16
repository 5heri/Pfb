
/*
{
{'.','.','.','.','.','.'}
{'.','#','#','.','.','.'}
{'.','.','#','#','.','#'}
{'.','#','.','.','.','#'}
{'.','.','.','#','.','X'}
};

*/

import java.util.LinkedList;

public class Escape {

	private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


	public static int getStepsBFS(String[] grid) {
		
		int m = grid.length;
		int n = grid[0].length();
		boolean[][] visited = new boolean[m][n];

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0));
		//visited[0][0] = true;

		while (!q.isEmpty()) {
			Node top = q.remove();

			if (!visited[top.row][top.col] && grid[top.row].charAt(top.col) == 'X') {
				/*for (int i = 0; i < visited.length; i++) {
					for (int j = 0; j < visited[0].length; j++) {
						if (visited[i][j]) {
							System.out.print(1);
						} else {
							System.out.print(0);
						}
					}
					System.out.println();
				}*/
				return top.steps;
			}

			visited[top.row][top.col] = true;

			for (int i = 0; i < DIRS.length; i++) {
				int nextR = top.row + DIRS[i][0];
				int nextC = top.col + DIRS[i][1];

				if (inGrid(nextR, nextC, m, n) && !visited[nextR][nextC]
					&& grid[nextR].charAt(nextC) != '#') {
					q.add(new Node(nextR, nextC, top.steps + 1));
				}
			}
		}

		return -1;
	}

	private static boolean inGrid(int row, int col, int m, int n) {
		return row >= 0 && row < m && col >= 0 && col < n;
	}

	private static class Node {
		int row;
		int col;
		int steps;

		Node(int r, int c, int s) {
			row = r; col = c; steps = s;
		}
	}

	public static void main(String[] args) {
		String[] g = {
						"......",
						".##...",
						"..##.#",
						".#...#",
						"...#.X",
					};	
		System.out.println(getStepsBFS(g));
	}
	
}
