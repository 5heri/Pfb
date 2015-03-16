public class ClimbingStairs {
	
	public static int climbStairs(int n) {
		if (n <= 3) return n;

		int prevFirst = 2;
		int prevSecond = 3;

		for (int i = 4; i <= n; i++) {
			int tmp = prevFirst + prevSecond;
			prevFirst = prevSecond;
			prevSecond = tmp;
		}
		return prevSecond;
	}

	public static int climbStairsForked(int n) {
		if (n<=3) return n;
		int[] a = {2,3};
		for (int i = 4; i <= n; i++) {
			int tmp = a[0] + a[1];
			a[0] = a[1];
			a[1] = tmp;
		}
		return a[1];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
		System.out.println(climbStairsForked(4));

		System.out.println(climbStairs(6));
		System.out.println(climbStairsForked(6));

		System.out.println(climbStairs(7));
		System.out.println(climbStairsForked(7));

		System.out.println(climbStairs(2));
		System.out.println(climbStairsForked(2));
	}
}
