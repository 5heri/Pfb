public class WordSearch {

	private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	private boolean[][] visited;

	public boolean exists(char[][] board, String word) {
		if (word.length() == 0) return true;

		int m = board.length;
		int n = board[0].length;

		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (search(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}	

	private boolean search(char[][] board, String word, int curr, int i, int j) {
		if (word.length() == curr) return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
		if (visited[i][j]) return false;
		if (word.charAt(curr) != board[i][j]) return false;

		visited[i][j] = true;

		
		boolean result = false;
		for (int k = 0; k < DIRS.length; k++) {
			int nextR = k + DIRS[k][0];
			int nextC = k + DIRS[k][1];

			result = result || search(board, word, curr + 1, nextR, nextC);
		}

		visited[i][j] = false;

		return result;
	}
}
