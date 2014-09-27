import java.util.Scanner;
import java.lang.Math.*;

public class LLMystery {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		while (testcases > 0) {
			System.out.println(opsToPalindrome(in.next()));
			testcases--;
		}
	}

	// abccba - 6
	// abcba  - 5

	private static int opsToPalindrome(String str) {
		int leftPointer = 0;
		int rightPointer = str.length() - 1;

		int operations = 0;

		for (int i = 0; i < str.length() / 2; i++) {
			operations += Math.abs((int)str.charAt(rightPointer) - (int)str.charAt(leftPointer));
			leftPointer++;
			rightPointer--;
		}
		return operations;
	}
}

