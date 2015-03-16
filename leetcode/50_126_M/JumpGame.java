public class JumpGame {
	
	public boolean canReachEnd(int[] A) {
		if (A.length <= 0) return false;

		int coveredPositions = 0;

		for (int i = 0; i < A.length && i < coveredPositions; i++) {
			if (coveredPositions < A[i] + i) {
				coveredPositions = A[i] + i;
			}
			if (coveredPositions >= A.length - 1) return true;
		}
		return false;
	}

}