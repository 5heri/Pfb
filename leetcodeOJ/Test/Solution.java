

public class Solution {
    

    public static boolean searchMatrix(int[][] matrix, int target) {
        int index = verticalBinarySearch(matrix, target);
        if (index < 0) return false;

        index = binarySearch(matrix[index], target);
        return index < 0 ? false : true;
    }

    private static int verticalBinarySearch(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // System.out.println(low);
        // System.out.println(high);
        return low - 1;
    }

    private static int binarySearch(int[] a, int target) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // System.out.println(low);
        // System.out.println(high);
        return -1;

    }

    public static void main(String[] args) {
        int[][] a = {
                        {10,20,30,40},
                        {50,60,70,80},
                        {90,100,110,120}
                    };
        verticalBinarySearch(a, 35);

        int[][] b = {
                        {1,3,5,7},
                        {10,11,16,20},
                        {23,30,34,50},
                    };
        int[][] c = {{1}};
        System.out.println(searchMatrix(c, 1));

    }


    
}

