import java.util.Scanner;

public class SLane {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	

		int length = in.nextInt();
		int testcases = in.nextInt();

		int[] freeway = new int[length];

		for (int i = 0; i < length; i++) {
			freeway[i] = in.nextInt();
		}

		while (testcases > 0) {
			System.out.println(largestVehiclePass(freeway, in.nextInt(), in.nextInt()));
			testcases--;
		}
	}

	private static int largestVehiclePass(int[] freeway, int i, int j) {
		int currentMax = 3;

		while (i <= j) {
			if (freeway[i] < currentMax) {
				currentMax = freeway[i];
			}
			i++;
		}
		return currentMax;
	}
}
