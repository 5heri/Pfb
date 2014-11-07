public class LectureOne {
	
	public static void main(String[] args) {
		System.out.println(fibRec(1));
		System.out.println(fibRec(2));
		System.out.println(fibRec(3));
		System.out.println(fibRec(4));
		System.out.println(fibRec(5));
		System.out.println(fibRec(6));
		System.out.println(fibRec(7));
		System.out.println(fibRec(8));
		System.out.println(fibRec(9));
		System.out.println(fibRec(10));

	}

	// Time: O(n)
	// Space: O(n)
	private static int fibItr(int n) {
		int[] f = new int[n+1];

		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}

		return f[n];
	}

	// Time: O(n)
	// Space: O(1)
	private static int fibItrBetter(int n) {
		int a = 0;
		int b = 1;

		int c = 0;

		for (int i = 0; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}


	// Bad 
	/*
		T(n) = T(n-1) + T(n-2) + Q(1)
		T(n) >= 2T(n-2)
		      = Q(2^(n/2))
	*/
	private static int fibRec(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibRec(n - 1) + fibRec(n - 2); 
		}
	}
}
