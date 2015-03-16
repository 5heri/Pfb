public class MaximumProductSubArray {

	public static int maxProduct(int A[]) {
		int maxPrev = A[0], minPrev = A[0];
		int maxHere = A[0], minHere = A[0];

		int maxProduct = A[0];

		for (int i = 1; i < A.length; i++) {
			maxHere = Math.max(Math.max(maxPrev * A[i], minPrev * A[i]), A[i]);
			minHere = Math.min(Math.min(maxPrev * A[i], minPrev * A[i]), A[i]);

			maxProduct = Math.max(maxHere, maxProduct);

			maxPrev = maxHere;
			minPrev = minHere;
		}
		return maxProduct;
	}	

	public static void main(String[] args) {
		int[] a = {2,3,-2,4};  // 6
		int[] b = {2,3,-2,10};  // 10

		int[] c = {-4, -3}; // 12
		int[] d = {-1, -1}; // 1
		int[] e = {-1, 0 , -2}; // 0

		int[] f = {12, 2, -3, -5, -6, -2}; // 4320


		System.out.println(maxProduct(a));
		System.out.println(maxProduct(b));
		System.out.println(maxProduct(c));
		System.out.println(maxProduct(d));
		System.out.println(maxProduct(e));
		System.out.println(maxProduct(f));

	}
}
