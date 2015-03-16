import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String word : strs) {
            char[] charS = word.toCharArray();
            Arrays.sort(charS);
            String sortedWord = new String(charS);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<String>());
            }
            map.get(sortedWord).add(word);
        }
        
        for (String key : map.keySet()) {
            List<String> anagrams = map.get(key);
            if (anagrams.size() > 1) res.addAll(anagrams);
        }
        return res;
    }
}