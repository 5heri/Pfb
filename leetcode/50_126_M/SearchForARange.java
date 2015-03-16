public class SearchForARange {
	

	public static int[] searchRange(int[] array, int target) {
		int index = binarysearch(array, 0, array.length - 1, target);

		int low = -1;
		int high = -1;
		int[] res = new int[2];

		if (index >= 0) {
			low = index;
			high = index;

			int l = low;
			while (l >= 0) {
				low = l;
				l = binarysearch(array, 0, low - 1, target);
			}

			int h = high;
			while (h >= 0) {
				high = h;
				h = binarysearch(array, high + 1, array.length - 1, target);
			}
		}

		res[0] = low;
		res[1] = high;

		return res;
	}


	private static int binarysearch(int[] array, int low, int high, int target) {
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = {5,7,7,8,8,10};
		int[] res = searchRange(a, 8);

		System.out.println(res[0] + " " + res[1]);

		int[] b = {5,5,5,5,5};
		res = searchRange(b, 5);
		System.out.println(res[0] + " " + res[1]);
	}
}
