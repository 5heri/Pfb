import java.util.ArrayList;

public class MainSubsets {
	
	public static void main(String[] args) {
		SubSets ss = new SubSets();

		int[] arr = {4,3,2,1};
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			x.add(arr[i]);
		} 
		System.out.println(ss.getSubSets(x));
	}
}
