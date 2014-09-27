import java.util.Scanner;

public class MaxXor {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        System.out.println(maxXor(in.nextInt(), in.nextInt()));
	}

	private static int maxXor(int l, int r) {
		int currentMax = 0;
		int operations = 0;

		for (int i = l; i <= r; i++) {
			for (int j = i; j <= r; j++) {
				int xor = i ^ j;
				if (currentMax < xor) {
					currentMax = xor;
				}
			}
		}
		return currentMax;
	}
}

