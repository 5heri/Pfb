public class MovingZeros {
	

	public static void main(String[] args) {
		int[] a = {0,1,3,0,7};
		shiftZeros(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void shiftZeros(int[] arr) {

		int w = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[w] = arr[i];
				w++;
			}
		}

		for (int i = w; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

}
