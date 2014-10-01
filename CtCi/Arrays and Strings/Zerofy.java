public class Zerofy {

	public static void main(String[] args) {
		int[][] matrix = { {1,4,2,6}, 
					       {2,2,6,7}, 
					       {3,4,2,6}, 
					       {0,6,4,0} 
					     };

		zerofyRowsCols(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void zerofyRowsCols(int[][] matrix) {

		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (rows[row] || cols[col]) {
					matrix[row][col] = 0;
				}
			}
		}
	} 
}