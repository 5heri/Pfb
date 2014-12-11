import java.util.HashSet;
import java.util.Set;

public class FindMissingNumbers {

	public static Set<Integer> find(int[] arr) {
		Set<Integer> s = new HashSet<Integer>();
		find(arr, s, 0, arr.length - 1);
		return s;
	}

	private static void find(int[] arr, Set<Integer> s, int start, int end) {
		if ((arr[end] - arr[start]) - (end - start) == 0) {
			return;
		}

		if (start + 1 == end) {
			for (int i = arr[start] + 1; i < arr[end]; i++) {
				s.add(i);
			}
			return;
		}

		int mid = (start + end) / 2;
		find(arr, s, start, mid);
		find(arr, s, mid, end);
	}

	public static void main(String[] args) {
		int[] arr = {1,2,4,5,6,8,11};

		System.out.println(find(arr));
	}
}
