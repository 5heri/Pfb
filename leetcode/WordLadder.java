import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");

		System.out.println(ladderLength("hit", "cog", set));
		System.out.println(ladderLength("hit", "pot", set));
		System.out.println(ladderLength("hit", "asd", set));
	}

	public static int ladderLength(String start, String end, Set<String> dict) {
		Map<String, Integer> distMap = new HashMap<String, Integer>();
		LinkedList<String> q = new LinkedList<String>();

		distMap.put(start, 1);
		q.add(start);

		while(!q.isEmpty()) {
			String word = q.remove();

			for (int i = 0; i < word.length(); i++) {
				char[] currWord = word.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currWord[i] = c;
					String newWord = new String(currWord);
					if (end.equals(newWord)) {
						return distMap.get(word) + 1;
					}

					if (!distMap.containsKey(newWord) && dict.contains(newWord)) {
						distMap.put(newWord, distMap.get(word) + 1);
						q.add(newWord);
					}
				}
			}
		}
		return 0;
	}
}
