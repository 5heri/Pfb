public class SingleNumberIandII {

	public int singleNumberTwice(int[] A) {
		int val = 0;
		for (int i = 0; i < A.length; i++) {
			val ^= A[i];
		}
		return val;
	}

	public int singleNumberThrice(int[] A) {
		return -1;
	}
}
