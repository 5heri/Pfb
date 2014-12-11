public class isPalindrome {

	public static boolean check(char[] s) {
		int start = 0;
		int end = s.length - 1;

		while (start < end) {
			if (!isAlpha(s[start])) {
				start++;
			} else if (!isAlpha(s[end])) {
				end--;
			} else {
				if (s[start] == s[end] || sameLetter(s[start], s[end])) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean sameLetter(char c1, char c2) {
		return Math.abs(c1 - c2) == 'a' - 'A';
	}

	private static boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
	} 	

	public static void main(String[] args) {
		String a = "A man, a plan, a a4923479832canal -- Panama!";
		String b = "A man, a plan, a 973583740593canal -- Panama!";
		String c = "A man, a plan, a canal -- Panama!";

		System.out.println(check(a.toCharArray()));
		System.out.println(check(b.toCharArray()));
		System.out.println(check(c.toCharArray()));
	}
}

