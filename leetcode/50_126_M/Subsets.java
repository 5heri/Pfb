import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public List<List<Integer>> subsets(int[] S) {
    	return subsets(S, 0);
    }

    private List<List<Integer>> subsets(int[] array, int index) {
    	List<List<Integer>> allSubsets;

    	if (array.length == index) {
    		allSubsets = new ArrayList<List<Integer>>();
    		allSubsets.add(new ArrayList<Integer>());
    	} else {
    		allSubsets = subsets(array, index + 1);
    		int item = array[index];

    		List<List<Integer>> moreSubsets = new ArrayList<List<Integer>>();

    		for (List<Integer> subset : allSubsets) {
    			List<Integer> newsubset = new ArrayList<Integer>();
    			newsubset.addAll(subset);
    			newsubset.add(item);
    			moreSubsets.add(newsubset);
    		}
    		allSubsets.addAll(moreSubsets);
    	}
    	return allSubsets;
    }
}
