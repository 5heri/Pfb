import java.lang.StringBuilder;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] words) {
		if (words.length == 0) return "";

		String currLongest = words[0];

		for (int i = 1; i < words.length; i++) {
			System.out.println(currLongest);
			currLongest = longestCommonPrefix(currLongest, words[i]);
		}
		return currLongest;
	}

	private static String longestCommonPrefix(String s1, String s2) {
		int length = s2.length() > s1.length() ? s1.length() : s2.length();

		StringBuilder sb = new StringBuilder();
		int i = 0;

		while(i < length && s1.charAt(i) == s2.charAt(i)) {
			sb.append(s1.charAt(i));
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"abab", "aba" ,"abc"};
		System.out.println(longestCommonPrefix(words));
	}

}

