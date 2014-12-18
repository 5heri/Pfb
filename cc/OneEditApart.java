public class OneEditApart {
	
	public static boolean oneEditApart(String s1, String s2) {
		String small = s1.length() <= s2.length() ? s1 : s2;
		String large = s1.length() <= s2.length() ? s2 : s1;


		if (large.length() - small.length() > 1) return false;

		int ops = 0;
		if (large.length() == small.length()) {
			for (int i = 0; i < small.length(); i++) {
				if (small.charAt(i) != large.charAt(i)) {
					ops++;
					if (ops > 1) return false;
				}
			}
		} else {
			int i = 0;
			while (i < small.length()) {
				if (small.charAt(i) != large.charAt(i + ops)) {
					ops++;
					if (ops > 1) return false;
				} else {
					i++;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(oneEditApart("cat", "dog"));   // false
		System.out.println(oneEditApart("cat", "cats"));  // true
		System.out.println(oneEditApart("cat", "cut"));   // true
		System.out.println(oneEditApart("cat", "cast"));  // true
		System.out.println(oneEditApart("cat", "at"));    // true
		System.out.println(oneEditApart("cat", "acts"));  // false
		System.out.println(oneEditApart("cat", "casg"));  // false
	}
}