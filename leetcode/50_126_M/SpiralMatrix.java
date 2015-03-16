import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<Integer>();
    	int row = matrix.length;
    	int col = matrix[0].length;

    	if (row == 0 || col == 0) return res;

    	for (int r = 0, c = 0; r < (row+1)/2 && c < (col+1)/2; r++, c++) {

    		//top
    		for (int i = c; i < col - c; i++) {
    			res.add(matrix[r][i]);
    		}

    		//right
    		for (int i = r + 1; i < row - r; i++) {
    			res.add(matrix[i][col - c -1]);
    		}

    		//bottom
    		for (int i = col - c - 2; i >= c && row - r - 1 > r; i--) {
    			res.add(matrix[row - r - 1][i]);
    		}

    		//left
    		for (int i = row - r - 2; i > r && col - c - 1 > c; i--) {
    			res.add(matrix[i][c]);
    		}
    	}
    	return res;

    }	

    public static void main(String[] args) {
    	int[][] m = {{1,2,3,4},
    				 {5,6,7,8},
    				 {9,10,11,12},
    				 {13,14,15,16}};
    	System.out.println(spiralOrder(m));
    }
}
