/********************************************************************************** 
 * 
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
 * return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
 * return ["2", "4->49", "51->74", "76->99"]. 
 * 
 **********************************************************************************/
import java.util.List;
import java.util.ArrayList;
	
public class MissingRanges {

	public static List<String> getMissingRanges(int[] array, int lower, int upper) {
		List<String> results = new ArrayList<String>();
		if (array.length == 0) return results;

		if (lower < array[0]) {
			results.add(rangeToString(lower, array[0] - 1 < upper ? array[0] - 1 : upper));
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				results.add(rangeToString(array[i] + 1, array[i + 1] - 1));
			}
		}

		if (upper > array[array.length - 1]) {
			results.add(rangeToString(array[array.length - 1] + 1, upper));
		}
		return results;
	}

	private static String rangeToString(int low, int high) {
		return low == high ? low + "" : low + "->" + high;
	}

	public static void main(String[] args) {
		int[] A = {0,1,3,50,75};
		System.out.println(getMissingRanges(A, 0, 99));
	}

}

