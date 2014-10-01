public class Unique {

	public static void main(String[] args) {
		String s = "abhcdefgh";
		if (uniqueOne(s)) {
			System.out.println("Is Unique");
		} else {
			System.out.println("Not Unique");
		}

		if (uniqueTwo(s)) {
			System.out.println("Is Unique");
		} else {
			System.out.println("Not Unique");
		}
	}

	// could also use boolean[] instead of int[]
	private static boolean uniqueOne(String str) {
		int[] charSet = new int[255];

		for (int i = 0; i < str.length(); i++) {
			if (charSet[(int) (str.charAt(i))] == 1) {	
				return false;	
			} else {
				charSet[(int) (str.charAt(i))]++;
			}
		}
		return true;
	}

	// not optimal
	private static boolean uniqueTwo(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
}