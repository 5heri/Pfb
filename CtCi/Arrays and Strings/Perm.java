public class Perm {

	public static void main(String[] args) {
		if (isPermutation("zxcvbnm", "mbnavcz")) {
			System.out.println("Is Permutation");
		} else {
			System.out.println("Not Permutation");
		}
	}

	private static boolean isPermutation(String strFirst, String strSecond) {
		if (strFirst.length() != strSecond.length()) {
			return false;
		}

		int[] charCounter = new int[255];

		for (int i = 0; i < strFirst.length(); i++) {
			charCounter[(int) strFirst.charAt(i)]++;
			charCounter[(int) strSecond.charAt(i)]--;
		}

		for (int n : charCounter) {
			if (n != 0) {
				return false; 
			}
		}
		return true;
	}
}
