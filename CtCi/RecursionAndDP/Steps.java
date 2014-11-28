public class Steps {
	

	public int possibleWays(int n) {
		int[] cache = new int[n];

		cache[0] = 1;
		cache[1] = 2;
		cache[2] = cache[0] + cache[1] + 1;

		for (int i = 3; i < n; i++) {
			cache[i] = cache[i-1] + cache[i-2] + cache[i-3];

		}
		return cache[n-1];

	}

	public int countWays(int n) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
}

