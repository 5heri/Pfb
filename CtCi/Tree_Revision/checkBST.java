public class checkBST {

	public boolean check(Node root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean check(Node n, int min, int max) {
			if (n == null) {
				return true;
			}

			if (n.getValue() <= min || n.getValue() > max) {
				return false;
			}

			if (!check(n.getLeft(), min, n.getValue())
					|| !check(n.getRight(), n.getValue(), max)) {
				return false;
			}
			return true;
	}

}
