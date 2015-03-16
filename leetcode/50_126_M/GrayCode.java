import java.util.List;
import java.util.ArrayList;

public class GrayCode {

	public static List<Integer> codes(int n) {
		List<Integer> res = new ArrayList<Integer>();

		int size = 1 << n;
		for (int i = 0; i < size; i++) {
			res.add((i >> 1) ^ i);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(codes(2));
		System.out.println(codes(3));
	}	
}
