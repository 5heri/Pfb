public class MaxSubarray {

	public int maxSubArray(int[] A) {
		int maxSum = A[0];
		int currSum = A[0] > 0 ? A[0] : 0;

		for (int i = 1; i < A.length; i++) {
			currSum += A[i];
			maxSum = Math.max(maxSum, currSum);
			currSum = Math.max(0, currSum);
		}
		return maxSum;
	} 	
}
