import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Permutations {
	
	public static List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	/*res.add(new ArrayList<Integer>(Arrays.asList(num)));

    	if (num.length < 2) {
    		return res;
    	}

    	int pos = 0;
    	while (pos < num.length - 1) {
    		int size = res.size();
    		for (int i = 0; i < size; i++) {
    			for (int j = pos + 1; j < res.get(i).size(); j++) {
    				List<Integer> copied = res.get(i).clone();
    				int t = copied.get(j);
    				copied.set(j, copied.get(pos));
    				copied.set(pos, t);
    				res.add(copied);
    			}
    		}
    		pos++;
    	}*/
    	return res;
    }

    public static void main(String[] args) {
    	int[] a = {1,2,3};
    	System.out.println(permute(a));
    }
}