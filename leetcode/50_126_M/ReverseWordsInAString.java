public class ReverseWordsInAString {
	
	public static String reverseWords(String s) {

		String reversedAll = reverse(s);

		String[] words = reversedAll.split(" ");
		StringBuilder sb = new StringBuilder();

		if (words.length == 0) return "";

		sb.append(reverse(words[0]));
		for (int i = 1; i < words.length; i++) {
			sb.append(" ");
			sb.append(reverse(words[i]));
		}
		return sb.toString();
	}	

	private static String reverse(String s) {
		char[] str = s.toCharArray();

		for (int i = 0; i < str.length/2; i++) {
			char tmp = str[i];
			str[i] = str[str.length - i - 1];
			str[str.length - i - 1] = tmp;
		}
		return new String(str);
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println("[" + reverseWords(s) + "]");
	}

}
