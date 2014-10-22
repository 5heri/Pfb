/*
* Implement a function OneEditApart with the following signature: 
* bool OneEditApart(string s1, string s2) 
* 
* OneEditApart("cat", "dog") = false 
* OneEditApart("cat", "cats") = true 
* OneEditApart("cat", "cut") = true 
* OneEditApart("cat", "cast") = true 
* OneEditApart("cat", "at") = true 
* OneEditApart("cat", "acts") = false 
* Edit is: insertion, removal, replacement 
*/

public class OneEditApart {
	

	public static void main(String[] args) {

		System.out.println(oneEditApart("cat", "dog"));
		System.out.println(oneEditApart("cat", "cats"));
		System.out.println(oneEditApart("cat", "cut"));
		System.out.println(oneEditApart("cat", "cast"));
		System.out.println(oneEditApart("cat", "at"));
		System.out.println(oneEditApart("cat", "acts"));
		System.out.println(oneEditApart("cat", "casg"));
	}

	private static boolean oneEditApart(String s1, String s2) {
		String small = s1.length() <= s2.length() ? s1 : s2;
		String large = s1.length() <= s2.length() ? s2 : s1;

		int ops = 0;
		if (large.length() - small.length() > 1) {
			return false;
		} else if (large.length() == small.length()) {
			for (int i = 0; i < small.length(); i++) {
				if (small.charAt(i) != large.charAt(i)) {
					ops++;
					if (ops > 1) {
						return false;
					}
				}
			}
		} else {
			int i = 0;
			while (i < small.length()) {
				if (small.charAt(i) != large.charAt(i + ops)) {
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
}

