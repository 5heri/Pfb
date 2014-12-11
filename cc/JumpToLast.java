public class JumpToLast {
	
	public static boolean reachesEnd(int[] a) {
		int maxJump = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (maxJump < i) {
				return false;
			}
			if (maxJump >= n-1) {
				return true;
			}
			maxJump = Math.max(maxJump, a[i] + i);
		}
		return false;
	}	

	public static void main(String[] args) {
		int[] a = {1,2,0,1,0,1};
		int[] b = {1,2,0,1,1,1};
		int[] c = {0,4,0};
		int[] d = {1,4,0};
		int[] x = {1,1,1,1,1,1,1,1,1,1,2,0,2,0,4,0,0,0,1};
		int[] y = {1,1,1,1,1,1,1,1,1,1,2,0,2,0,4,0,0,0,0,1};
		int[] z = {1,1,1,1,1,1,1,1,1,1,2,0,2,0,4,0,0,0,1,1};

		System.out.println(reachesEnd(a));
		System.out.println(reachesEnd(b));
		System.out.println(reachesEnd(c));
		System.out.println(reachesEnd(d));
		System.out.println(reachesEnd(x));
		System.out.println(reachesEnd(y));
		System.out.println(reachesEnd(z));
	}
}
