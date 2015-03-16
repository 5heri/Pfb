public class MinimumPathSum {
	
	public static int minPathSum(int[][] grid) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) continue;

				if (i == 0) {
					grid[i][j] += grid[i][j - 1];
				} else if (j == 0) {
					grid[i][j] += grid[i - 1][j];
				} else {
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
				}
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] g = {
						{1,2,3},
						{4,2,6},
						{3,6,7}
					};

		System.out.println(minPathSum(g));
	}

}
