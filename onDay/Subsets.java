import java.util.List;
import java.util.ArrayList;

public class Subsets {

	public List<List<Integer>> subsets(int[] arr) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			List<List<Integer>> tmp = ArrayList<List<Integer>>();

			for (List<Integer> eachResList : res) {
				tmp.add(new ArrayList<Integer>(eachResList));
			}

			for (List<Integer> eachTmpList : tmp) {
				eachTmpList.add(arr[i]);
			}

			List<Integer> single = new ArrayList<Integer>();
			single.add(arr[i]);
			tmp.add(single);

			res.addAll(tmp);
		}
		res.add(new ArrayList<Integer>());
		return res;
	}	
}
