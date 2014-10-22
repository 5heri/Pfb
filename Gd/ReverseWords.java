/* Code a function that receives a string composed
 by words separated by spaces and returns a string 
 where words appear in the same order but than the 
 original string, but every word is inverted. 
Example, for this input string


@"the boy ran"
the output would be


@"eht yob nar"


also    "good morning -> morning good"
*/

import java.util.*;

public class ReverseWords {
	
	public static void main(String[] args) {
		String s1 = "the boy ran";
		String s2 = "good morning";
		System.out.println(reverseWords(s1));
		System.out.println(reverseSentence(s2));
	}

	private static String reverseSentence(String s) {
		return reverseWords(reverse(s));
	}

	private static String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < words.length - 1; i++) {
			result.append(reverse(words[i]));
			result.append(' ');
		}
		result.append(reverse(words[words.length - 1]));
		return result.toString();
	}

	private static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}

