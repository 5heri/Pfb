import java.util.Arrays;

public class LongestUniqueSubString {

	public static int lengthOfLongestUniqueSubString(String s) {
		if (s.length() == 0) return 0;

		int[] char_index = new int[256];
		Arrays.fill(char_index, -1);

		int maxLength = 0;
		int lastRepeatedIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (char_index[s.charAt(i)] != -1 
			        && lastRepeatedIndex < char_index[s.charAt(i)]) {
				lastRepeatedIndex = char_index[s.charAt(i)];
			}

			if (i - lastRepeatedIndex > maxLength) {
				maxLength = i - lastRepeatedIndex;
			}

			char_index[s.charAt(i)] = i;
		}
		return maxLength;
	}		

	public static String longestUniqueSubString(String s) {
		if (s.length() == 0) return "";

		int[] char_index = new int[256];
		Arrays.fill(char_index, -1);

		int start = 0;
		int end = 0;
		int lastRepeatedIndex = -1;
		for (int i = 0; i < s.length(); i++) {
			if (char_index[s.charAt(i)] != -1 
			        && lastRepeatedIndex < char_index[s.charAt(i)]) {
				lastRepeatedIndex = char_index[s.charAt(i)];
			}

			if (i - lastRepeatedIndex > end - start) {
				start = lastRepeatedIndex;
				end = i;
			}

			char_index[s.charAt(i)] = i;
		}
		return s.substring(start + 1, end + 1);
	}	

	public static void main(String[] args) {
		System.out.println(lengthOfLongestUniqueSubString("abcabbdb"));
		System.out.println(longestUniqueSubString("abcabbdb"));

		System.out.println(lengthOfLongestUniqueSubString("abcabcdb"));
		System.out.println(longestUniqueSubString("abcabcdb"));

		System.out.println(lengthOfLongestUniqueSubString("bbbb"));
		System.out.println(longestUniqueSubString("bbbb"));

		System.out.println(lengthOfLongestUniqueSubString(""));
		System.out.println(longestUniqueSubString(""));
	}


}
