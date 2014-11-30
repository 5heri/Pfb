import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

public class GroupShifty {

	public List<List<String>> groupTogether(String[] words) {

		Map<String, List<String>> m = new HashMap<String, List<String>>();

		for (String w : words) {
			String key = getNormalized(w);

			if (!m.containsKey(key)) {
				m.put(key, new ArrayList<String>());
			}
			m.get(key).add(w);
		} 

		List<List<String>> result = new ArrayList<List<String>>();
		for (String k : m.keySet()) {
			List<String> l = new ArrayList<String>();
			for (String v : m.get(k)) {
				l.add(v);
			}
			result.add(l);
		}
		return result;

	}

	private String getNormalized(String s) {
		StringBuilder sb = new StringBuilder();
		int diff = s.charAt(0) - 'A';
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) - diff);
		}
		return sb.toString();
	}
}
