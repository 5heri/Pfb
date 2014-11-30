public class Combinations {
	
	public String[] combine(String[][] allWords) {
		return combine(allWords, 0);
	}

	private String[] combine(String[][] allWords, int i) {
		if (i == allWords.length - 1) {
			return allWords[i];
		}
		return combineWords(allWords[i], combine(allWords, i + 1));
	}

	private String[] combineWords(String[] words1, String[] words2) {
		String[] combined = new String[words1.length * words2.length];
		int curr = 0;

		for (int i = 0; i < words1.length; i++) {
			for (int j = 0; j < words2.length; j++) {
				combined[curr] = words1[i] + " " + words2[j];
				curr++;
			}
		}
		return combined;
	}
}
