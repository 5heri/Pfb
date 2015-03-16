public class RemoveElement {

	public static int removeElement(int A[], int n, int elem) {
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if (A[end] == elem) {
				end--;
			} else {
				if (A[start] == elem) {
					A[start] = A[end];
					end--;
				}
				start++;
			}
		}
		return start == 0 ? 0 : start + 1;
	}	

	public static void main(String[] args) {
		int[] a = {3,2,4,6,7,2};
		System.out.println(removeElement(a, 6, 2));
		printArray(a);

		int[] a2 = {2,2,2,2,2,2};
		System.out.println(removeElement(a2, 6, 2));
		printArray(a2);

		int[] a3 = {2,2,4,6,7,2};
		System.out.println(removeElement(a3, 6, 2));
		printArray(a3);
	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
		
}
