import java.util.List;
import java.util.ArrayList;

public class SubSets {

	public ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set) {
		return getSubSets(set, 0);
	}	

	private ArrayList<ArrayList<Integer>> getSubSets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubSets;

		if (set.size() == index) {
			allSubSets = new ArrayList<ArrayList<Integer>>();
			allSubSets.add(new ArrayList<Integer>());
		} else {
			allSubSets = getSubSets(set, index + 1);
			int item = set.get(index);

			ArrayList<ArrayList<Integer>> moreSubSets = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> subSet : allSubSets) {
				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
				newSubSet.addAll(subSet);
				newSubSet.add(item);
				moreSubSets.add(newSubSet);
			}
			allSubSets.addAll(moreSubSets);
		}
		return allSubSets;
	}
}
