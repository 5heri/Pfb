public class ReverseSentence {
	
	public static String reverse(char[] sentence) {

		int start = 0;
		int end = sentence.length - 1;

		while (sentence[start] == ' ' || sentence[end] == ' ') {
			if (sentence[start] == ' ') start++;
			if (sentence[end] == ' ') end--;
		}

		for (int i = start; i <= end; i++) {
			if (sentence[i] == ' ' || i == end) {
				reverse(sentence, start, i == end ? i : i - 1);
				start = i + 1;
			}
		}
		reverse(sentence, 0, sentence.length - 1);
		return new String(sentence);
	}

	private static void reverse(char[] s, int low, int high) {
		/*System.out.println("start:" + start + " end:" + end);
		for (int i = start; i < (start + (end - start)/2); i++) {
			char tmp = s[i];
			s[i] = s[end - i];
			s[end - i] = tmp;
		}

		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();*/

		while (low < high) {
			char tmp = s[low];
			s[low] = s[high];
			s[high] = tmp;
			low++; high--; 
		}
	}

	public static void main(String[] args) {
		System.out.println("-" + reverse("  The boy ran   ".toCharArray()) + "-");
	}
}