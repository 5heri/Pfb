import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class WordLadder {
	
	public int ladderLength(String start, String end, Set<String> dict) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		LinkedList<String> q = new LinkedList<String>();

		map.put(start, 1);
		q.add(start);

		while (!q.isEmpty()) {
			String word = q.remove();
			for (int i = 0; i < word.length(); i++) {
				char[] charWord = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					charWord[i] = c;
					String newWord = new String(charWord);
					if (newWord.equals(end)) {
						return map.get(word) + 1;
					}

					if (!map.containskey(newWord) && dict.contains(newWord)) {
						map.put(newWord, map.get(word) + 1);
						q.add(newWord);
					}
				}
			}
		}
		return 0;
	}
}