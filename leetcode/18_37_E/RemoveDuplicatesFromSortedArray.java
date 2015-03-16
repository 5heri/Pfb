public class RemoveDuplicatesFromSortedArray {

	public int removeDup(int[] A, int n) {
		if (n <= 1) return n;
		
		int curr = 0;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] != A[i+1]) {
				curr++;
				A[curr] = A[i + 1];
			}
		}
		return curr + 1;
	}	
}
