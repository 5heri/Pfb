public class UniquePathsII {

	public int uniquePathsWithObs(int[][] obsGrid) {

		int[][] grid = new int[obsGrid.length][obsGrid[0].length];
		for (int i = 0; i < obsGrid.length; i++) {
			for (int j = 0; j < obsGrid[0].length; j++) {
				if (obsGrid[i][j] == 1) {
					grid[i][j] = 0;
				} else {
					if (i > 0 && j > 0) {
						grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
					} else if (i > 0) {
						grid[i][j] = grid[i - 1][j];
					} else if (j > 0) {	
						grid[i][j] = grid[i][j - 1];
					} else {
						grid[i][j] = 1;
					}
				}
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}	
}
