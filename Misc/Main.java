public class Main {

	public static void main(String[] args) {
		String[] words = { "abcd", "race", "bdac", "cera", 
						     "bana", "jana", "naab", "naaj", "erac" };

		PairAnagram.pairAnagramTogether(words);

		for (int i = 0; i < words.length; i++) {
			System.out.print(words[i] + " ");
		}
		System.out.println();
	}	
}
