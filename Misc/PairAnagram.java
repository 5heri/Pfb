// assuming all lowercase

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class PairAnagram {
	

	public static void pairAnagramTogether(String[] words) {
		int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,
			                 43,47,53,59,61,67,71,73,79,83,89,97,101};

	 	Map<Integer, List<String>> m = new HashMap<Integer, List<String>>();

	 	for (int i = 0; i < words.length; i++) {
	 		String s = words[i];
	 		int hash = hashString(s, primes);
	 		if (m.keySet().contains(hash)) {
	 			m.get(hash).add(s);
	 		} else {
	 			List<String> anagrams = new ArrayList<String>();
	 			anagrams.add(s); 
	 			m.put(hash, anagrams);
	 		}
	 	}

	 	Set<Integer> hashes = m.keySet();
	 	int count = 0;
	 	for (Integer h : hashes) {
	 		List<String> hashAnagrams = m.get(h);
	 		for (int i = 0; i < hashAnagrams.size(); i++) {
	 			words[count] = hashAnagrams.get(i);
	 			count++;
	 		}
	 	}

	}

	private static int hashString(String word, int[] primes) {
		int hash = 1;
		for (int i = 0; i < word.length(); i++) {
			hash *= primes[word.charAt(i) - 97];
		}
		return hash;
	}

/*
	private static boolean areAnagrams(String firstWord, String secondWord) {
		if (firstWord.length() != secondWord.length()) return false;

		int[] charCount = new int[firstWord.length()];

		for (int i = 0; i < firstWord.length(); i++) {
			charCount[firstWord.charAt(i)]++;
			charCount[secondWord.charAt(i)]--;
		}
		for (int i = 0; i < charCount.length; i++) {
			if (charCount[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private static class AnagramHashed {
		private String s;
		private int[] primes;

		public AnagramHashed (String str, int[] primes) {
			s = str;
			primes = primes;
		}

		public String getString() {
			return s;
		}

		public void setString(String str) {
			s = str;
		}

		@Override
		public boolean equals(Object o) {
			AnagramHashed comparedTo = (AnagramHashed) o;
			return s.equals(comparedTo.getString());
		}

		@Override
		public int hashCode() {
			int hash = 1;
			for (int i = 0; i < s.length(); i++) {
				hash *= primes[s.charAt(i) - 97];
			}
			return hash;
		}

	*/

}
