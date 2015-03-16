import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (num.length < 3) return res;

		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || num[i] > num[i - 1]) {
				int negate = -num[i];
				int start = i + 1;
				int end = num.length - 1;

				while (start < end) {
					if (num[start] + num[end] == negate) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[start]);
						tmp.add(num[end]);
						res.add(tmp);
						start++;
						end--;
						while (start < end && num[start] == num[start - 1]) {
							start++;
						}
						while (start < end && num[end] == num[end + 1]) {
							end--;
						}
					} else if (num[start] + num[end] < negate) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		return res;
	}
}