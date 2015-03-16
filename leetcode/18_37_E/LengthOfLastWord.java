public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		String[] words = s.split(" ");
		if (words.length == 0) return 0;
		return words[words.length - 1].length();
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));                      // 0
		System.out.println(lengthOfLastWord("Hello World"));           // 5
		System.out.println(lengthOfLastWord("Hello World G"));         // 1
		System.out.println(lengthOfLastWord("Hellowaskjf skjdnfs asdfasdf"));  // 8
		System.out.println(lengthOfLastWord("a a a a aa"));            // 2
	}
		
}
