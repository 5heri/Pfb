import java.lang.StringBuilder;

public class CountAndSay {

	public static String countAndSay(int n) {
		String s = "1";
		for (int i = 0; i < n; i++) {
			s = countAndSay(s);
		}
		return s;

	}

	private static String countAndSay(String s) {
		StringBuilder sb = new StringBuilder();

		char repeat = s.charAt(0);
		int count = 1;
		s = s.substring(1) + " ";

		for (char actual : s.toCharArray()) {
			if (repeat != actual) {
				sb.append(count + "" + repeat);
				count = 1;
				repeat = actual;
			} else {
				count++;
			}
		}
		return sb.toString();
	}

	private static String compress(String s) {
		if (s.length() <= 2) return s;

		StringBuilder sb = new StringBuilder();

		char repeat = s.charAt(0);
		int count = 1;
		s += " ";

		for (int i = 1; i < s.length(); i++) {
			char actual = s.charAt(i);
			if (actual != repeat) {	
				sb.append(repeat + "" + count);
				if (sb.length() >= s.length()) return s.substring(0, s.length() - 1);
				count = 1;
				repeat = actual;
			} else {
				count++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String zero = countAndSay(0);
		String one = countAndSay(1);
		String two = countAndSay(2);
		String three = countAndSay(3);
		String four = countAndSay(4);
		String five = countAndSay(5);

		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);

		System.out.println(compress("aaabbcccc"));
		System.out.println(compress("abcdefghijk") + "--");
	}
}
