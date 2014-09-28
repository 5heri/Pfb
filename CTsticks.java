import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CTsticks {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int length = in.nextInt();

		List<Integer> sticks = new ArrayList<Integer>();

		for (int i = 0; i < length; i++) {
			int stick = in.nextInt();
			sticks.add(stick);
		}

		cutSticks(sticks);
	}

	private static void cutSticks(List<Integer> sticks) {
		
		while (!checkZeros(sticks)) {
			int cuts = 0;
			int min = Integer.MAX_VALUE;
			for (Integer stick : sticks) {
				if (min > stick && stick != 0) {
					min = stick;
				} 
			}

			for (int i = 0; i < sticks.size(); i++) {
				if (sticks.get(i) != 0) {
					int c = sticks.get(i) - min;
					sticks.set(i, c);
					cuts++;
				}
			}
			System.out.println(cuts);
		}
	}

	private static boolean checkZeros(List<Integer> l) {
		for (Integer i : l) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
