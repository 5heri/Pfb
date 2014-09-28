import java.util.Scanner;

public class GoT1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		
		palinPerm(word);
	}

	private static void palinPerm(String word) {
		int[] charCount = new int[26];

		for (int i = 0; i < word.length(); i++) {
			charCount[((int) word.charAt(i)) - 97]++;
		}

		boolean foundOdd = false;
		for (int i = 0; i < 26; i++) {
			if (charCount[i] % 2 != 0) {
				if (foundOdd) {
					System.out.println("NO");
					return;
				}
				foundOdd = true;
			}
		}
		System.out.println("YES");
	}
}

