public class SortColors {

	public static void sort(int[] colors) {
		int zPointer = 0;
		int tPointer = colors.length - 1;

		for (int i = 0; i <= tPointer; i++) {
			if (colors[i] == 0) {
				swap(colors, zPointer, i);
				zPointer++;
			}
			if (colors[i] == 2) {
				swap(colors, tPointer, i);
				tPointer--;
				i--;
			}
		}
	}

	private static void swap(int[] array, int index1, int index2) {
		int tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}

	public static void sortTwoPass(int[] colors) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;

		for (int i = 0; i < colors.length; i++) {
			switch (colors[i]) {
				case 0 : zeros++;
						 break;
				case 1 : ones++;
						 break;
				case 2 : twos++;
						 break;
				default : break;
			}
		}

		for (int i = 0; i < colors.length; i++) {
			if (zeros > 0) {
				colors[i] = 0;
				zeros--;
			} else if (ones > 0) {
				colors[i] = 1;
				ones--;
			} else if (twos > 0) {
				colors[i] = 2;
				twos--;
			}
		}
	}

	public static void main(String[] args) {
		int[] a1 = {0,2,0,1,0,2};
		int[] a2 = {0,2,0,1,0,2};

		sort(a1);
		sortTwoPass(a2);
		print(a1);
		print(a2);
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
		
}

