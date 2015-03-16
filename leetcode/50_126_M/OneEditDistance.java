// Given two strings S and T, determine if they are both one edit distance apart.

public class OneEditDistance {

	public static boolean oneEditApart(String s, String  t) {
		String small = s.length() <= t.length() ? s : t;
		String large = s.length() <= t.length() ? t : s;

		int ops = 0;
		if (large.length() - small.length() > 1) {      // more than 1 ops
			return false;
		} else if (large.length() == small.length()) {  // length equal
			for (int i = 0; i < small.length(); i++) {
				if (small.charAt(i) != large.charAt(i)) {
					ops++;
					if (ops > 1) {
						return false;
					}
				}
			}
		} else {										// length differs by 1
			int i = 0;
			while (i < small.length()) {
				if (small.charAt(i) != large.charAt(ops + i)) {
					ops++;
					if (ops > 1) {
						return false;
					}
				} else {
					i++;
				}
			}
		}
		return true;
	}	

	public static void main(String[] args) {
		System.out.println(oneEditApart("cat", "dog"));
		System.out.println(oneEditApart("cat", "cats"));
		System.out.println(oneEditApart("cat", "cut"));
		System.out.println(oneEditApart("cat", "cast"));
		System.out.println(oneEditApart("cat", "at"));
		System.out.println(oneEditApart("cat", "acts"));
		System.out.println(oneEditApart("cat", "casg"));
	}
}
