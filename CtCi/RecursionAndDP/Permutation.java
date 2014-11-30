import java.util.ArrayList;

public class Permutation {

	public ArrayList<String> getPerms(String s) {
		if (s == null) return null;

		ArrayList<String> permutations = new ArrayList<String>();
		if (s.length() == 0) {
			permutations.add("");     // add returns boolean! 
			return permutations;
		} 

		char first = s.charAt(0);  // insert this char everywhere
		String remainder = s.substring(1); // remainder to recurse on

		ArrayList<String> words = getPerms(remainder);
		for (String w : words) {
			for (int i = 0; i <= w.length(); i++) {
				permutations.add(insertCharAt(w, first, i));
			}
		}
		return permutations;
	}	

	private String insertCharAt(String word, char c, int i) {
		return word.substring(0,i) + c + word.substring(i);
	}
}
