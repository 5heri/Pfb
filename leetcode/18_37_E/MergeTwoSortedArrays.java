public class MergeTwoSortedArrays {

	public static void merge(int[] A, int a, int B[], int b) {
		int indexA = a - 1;
		int indexB = b - 1;
		int curr = a + b - 1;

		while (indexA >= 0 && indexB >= 0) {
			if (A[indexA] > B[indexB]) {
				A[curr] = A[indexA--];
			} else {
				A[curr] = B[indexB--];
			}
			curr--;
		}

		while (indexB >= 0) {
			A[curr] = B[indexB--];
			curr--;
		}
	}

	public static void main(String[] args) {
		int[] a = {2,4,6,8,10,0,0,0};
		int[] b = {1,3,5};
		merge(a, 5, b, 3);
		printArray(a);

		int[] a1 = {2,4,0,0,0};
		int[] b1 = {3,5,7};
		merge(a1, 2, b1, 3);
		printArray(a1);

		int[] a2 = {12,14,16,18,20,0,0,0};
		int[] b2 = {1,3,5};
		merge(a2, 5, b2, 3);
		printArray(a2);

	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}

