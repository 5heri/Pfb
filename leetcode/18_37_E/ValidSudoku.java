public class ValidSudoku {

	public boolean isValid(char[][] board) {
		int count = 9;
		boolean[][] rowCheck = new boolean[count][count];
		boolean[][] colCheck = new boolean[count][count];	
		boolean[][] boxCheck = new boolean[count][count];

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] >= 1 && board[r][c] <= 9) {
					int value = Character.getNumericValue(board[r][c]) - 1;

					if (rowCheck[r][value]) return false;
					rowCheck[r][value] = true;

					if (colCheck[c][value]) return false;
					colCheck[c][value] = true;

					int b = (r/3) * 3 + c/3;
					if (boxCheck[b][value])	return false;
					boxCheck[b][value] = true;
				}
			}
		}
		return true;
	}	
}
