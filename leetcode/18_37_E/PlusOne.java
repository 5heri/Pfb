public class PlusOne {

	public static int[] plusOne(int[] A) {
		int carry = 1;

		for (int i = A.length - 1; i >= 0; i--) {
			int value = A[i] + carry;
			A[i] = value % 10;
			carry = value/10;
		}
		if (carry != 0) {
			int[] B = new int[A.length + 1];
			B[0] = carry;
			for (int i = 1; i < A.length; i++) {
				B[i] = A[i - 1];
			}
			return B;
		} else {
			return A;
		}
	}

	public static void main(String[] args) {
		int[] a1 = {9,9,9};
		int[] a2 = {2,7,9};
		int[] a3 = {2,7,0};

		printArray(plusOne(a1));
		printArray(plusOne(a2));
		printArray(plusOne(a3));
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
