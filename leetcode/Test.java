import java.util.*;

public class Test {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");

		System.out.println(ladderLength("hit", "cog", set));
	}

	public static int ladderLength (String start, String end, HashSet<String> dict) {
		if (dict.size() == 0) return 0;
		int result = 0;
		LinkedList<String> wordQueue = new LinkedList <String>();
		LinkedList<Integer> distanceQueue = new LinkedList <Integer>(); 
		wordQueue.add(start);
		distanceQueue.add(1);
		while(!wordQueue .isEmpty()) {
			String currWord = wordQueue.pop() ;
			Integer currDistance = distanceQueue .pop() ;
			//if (currWord.equals(end)) { 
			//	return currDistance ;
			//}
			for(int i=0; i<currWord.length(); i++){
				char[] currCharArr = currWord.toCharArray(); 
				for(char c='a'; c<='z'; c++){
					currCharArr [i] = c;
					String newWord = new String (currCharArr) ;
				//	System.out.println(newWord + " " + currDistance);
					if (end.equals(newWord)) {
						System.out.println(newWord + " " + currDistance);
						System.out.println("YOO");
					}
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance+1);
						dict.remove(newWord); 
					}
				} 
			}
		}
		System.out.println(wordQueue);
		System.out.println(distanceQueue);
		return 0; 
	}
}
		