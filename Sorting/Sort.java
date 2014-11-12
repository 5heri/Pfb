public class Sort {
	
	public static void mergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergeSort(array, helper, 0, array.length -1);
	}	

	private static void mergeSort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			// prevent overflow
			int mid = low + ((high - low)/2);
			mergeSort(array, helper, low, mid);
			mergeSort(array, helper, mid + 1, high);
			merge(array, helper, low, mid, high);
		}
	}

	private static void merge(int[] array, int[] helper, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = mid + 1;
		int current = low;

		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		/* Only need to add remaining from left
		 * because for loop at start means that the 
		 * values for the right are already there 
		 */

		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if (left < index - 1) {
			quickSort(array, left, index - 1);
		}
		if (right > index) {
			quickSort(array, index, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		// prevent overflow
		int pivot = array[left + (right - left) / 2];

		while (left <= right) {
			while (array[left] < pivot) left++;
			while (array[right] > pivot) right--;

			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}	
		return left;
	}

	private static void swap(int[] array, int from, int to) {
		int tmp = array[to];
		array[to] = array[from];
		array[from] = tmp;
	}

}
