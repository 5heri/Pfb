import java.util.List;
import java.util.ArrayList;

public class Triangle {

	public static int triangleMinPath(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) return -1;

		int[] prevSum = new int[triangle.size()];
		int[] currSum = new int[triangle.size()];
		prevSum[0] = triangle.get(0).get(0);

		for (int i = 1; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					currSum[j] = prevSum[j] + triangle.get(i).get(j);
				} else if (j == triangle.get(i).size() - 1) {
					currSum[j] = prevSum[j-1] + triangle.get(i).get(j);
				} else {
					currSum[j] = triangle.get(i).get(j) 
									+ Math.min(prevSum[j-1], prevSum[j]);
				}
			}
			prevSum = currSum;
			currSum = new int[triangle.size()];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prevSum.length; i++) {
			min = Math.min(min, prevSum[i]);
		}
		return min;
	}

	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		List<Integer> t0 = new ArrayList<Integer>();
		List<Integer> t1 = new ArrayList<Integer>();
		List<Integer> t2 = new ArrayList<Integer>();
		List<Integer> t3 = new ArrayList<Integer>();

		t0.add(2);

		t1.add(3);
		t1.add(4);

		t2.add(6);
		t2.add(5);
		t2.add(7);

		t3.add(4);
		t3.add(1);
		t3.add(8);
		t3.add(3);

		t.add(t0);
		t.add(t1);
		t.add(t2);
		t.add(t3);

		System.out.println(triangleMinPath(t));

	}	

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
