public class ShiftZerosToEnd {
	
	public static void shift(int[] a) {
		int z = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) 
				a[z++] = a[i];
		}

		for (; z < a.length; z++) {
			a[z] = 0;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,0,1,0,1};
		int[] b = {1,1,1,1,1,1,1,1,1,1,2,0,2,0,4,0,0,0,1};
		shift(a);
		shift(b);
		print(a);
		print(b);
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
