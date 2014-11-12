public class Main {
	
	public static void main(String[] args) {
		int[] arrayM = {1,5,3,8,7,4,9};
		int[] arrayQ = {1,5,3,8,7,4,9};
		Sort.mergeSort(arrayM);
		Sort.quickSort(arrayQ);
		display(arrayM);
		display(arrayQ);
	}

	private static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
