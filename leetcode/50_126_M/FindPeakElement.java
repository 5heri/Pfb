public class FindPeakElement {


	public int findPeak(int[] array) {
		int low = 0;
		int high = array.length - 1;
		int mid = 0;

		while (low < high) {
			mid = low + (high - low) / 2;

			if ((mid == 0 || array[mid] > array[mid - 1]) 
				&& (mid == array.length - 1 || array[mid] > array[mid + 1])) {
				return mid;
			}

			if (mid > 0 && array[mid - 1] > array[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}	
}
