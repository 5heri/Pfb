import java.util.Scanner;

public class Utree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		while (testCases > 0) {
			System.out.println(heightAfterCycles(in.nextInt()));
			testCases--;
		}
	}

	private static int heightAfterCycles(int cycles) {
		int height = 1;

		for (int i = 0; i < cycles; i++) {
			if (i % 2 == 0) {
				height *= 2;
			} else {
				height++;
			}
		}
		return height;
	}
}

