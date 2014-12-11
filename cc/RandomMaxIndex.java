import java.util.Random;

public class RandomMaxIndex {

	public static int getMaxRandomIndex(int[] a) {
		int max = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				count = 1;
			} else if (a[i] == max) {
				count++;
			} 
		}

		Random rand = new Random();
		int randomNth = rand.nextInt(count) + 1;

		count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == max) {
				count++;
			}
			if (count == randomNth) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = {1,6,3,4,6,4,5,6,2,6};

		for (int i = 0; i < 15; i++) {
			System.out.println(getMaxRandomIndex(a));
		}
	}
}
