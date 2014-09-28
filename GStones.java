import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class GStones {
	
	public static void main(String[] args) {
		System.out.println(gems());
	}

	private static int gems() {
		Scanner in = new Scanner(System.in);
		int rockCount = in.nextInt();

		Set<Character> baseSet = new HashSet<Character>();
		Set<Character> currSet = new HashSet<Character>();

		for (char c = 'a'; c <= 'z'; c++) {
			baseSet.add(c);
		}

		while (rockCount > 0) {
			currSet.clear();

			String rock = in.next();
			for (int i = 0; i < rock.length(); i++) {
				currSet.add(rock.charAt(i));
			}

			baseSet.retainAll(currSet);

			rockCount--;
		}
		return baseSet.size();
	}
}

