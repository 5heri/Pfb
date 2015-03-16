public class RemoveDuplicatesFromSortedArrayII {
	
	public int removeDups(int A[], int n) {
		if (n <= 2) return n;

		int pos = 0;
		int cnt = 1;

		for (int i = 1; i < n; i++) {
			if (A[i] == A[pos]) {
				cnt++;
				if (cnt == 2) {
					A[++pos] = A[i];
				}
			} else {
				cnt = 1;
				A[++pos] = A[i];
			}
		}
		return pos+1;
	}
}
