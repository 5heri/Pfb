import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {

	public List<Integer> twoSum(int[] numbers, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (m.containsKey(numbers[i])) {
				result.add(m.get(numbers[i] + 1));
				result.add(i + 1);
				break;
			} else {
				m.put(target - numbers[i], i);
			}
		}
		return result;
	}

}
