import java.util.ArrayList;

public class ParenthesesPermutation {
	
	public ArrayList<String> getPerms(int n) {
		char[] s = new char[n * 2];
		ArrayList<String> p = new ArrayList<String>();
		getPerms(p, n, n, s, 0);
		return p;
	}

	private void getPerms(ArrayList<String> l, int leftRem, int rightRem,
								char[] s, int i) {
		if (leftRem < 0 || rightRem < leftRem) return;

		if (leftRem == 0 && rightRem == 0) {
			l.add(new String(s));
		} else {
			if (leftRem > 0) {
				s[i] = '(';
				getPerms(l, leftRem - 1, rightRem, s, i + 1);
			}
			if (rightRem > 0) {
				s[i] = ')';
				getPerms(l, leftRem, rightRem - 1, s, i + 1);
			}
		}
	}

}
