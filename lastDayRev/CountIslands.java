public class CountIslands {

	private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	private static boolean[][] visited;

	public static int getCount(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		visited = new boolean[m][n];

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					search(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void search(int[][] grid, int row, int col) {
		if (visited[row][col]) return;

		visited[row][col] = true;

		for (int i = 0; i < DIRS.length; i++) {
			int nextR = row + DIRS[i][0];
			int nextC = col + DIRS[i][1];

			if (inGrid(nextR, nextC, grid.length, grid[0].length)
				&& !visited[nextR][nextC]
				&& grid[row][col] == grid[nextR][nextC]) {
				search(grid, nextR, nextC);
			}
		}
	}

	private static boolean inGrid(int row, int col, int m, int n) {
		return row >= 0 && row < m && col >= 0 && col < n;
	}

	public static void main(String[] args) {
		int[][] grid = {{1,1,0,0,1},
						{1,0,0,0,1},
						{0,1,1,0,1},
						{0,0,0,0,0},
						{0,0,1,1,0}};

		System.out.println(getCount(grid));
	}
		
}
