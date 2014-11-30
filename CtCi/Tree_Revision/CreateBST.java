public class CreateBST {

	public Node createTree(int[] arr) {
		return createTree(arr, 0 , arr.length - 1);
	}

	private Node createTree(int[] arr, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = start + (end - start)/2;
		Node n = new Node(arr[mid]);
		n.setLeft(createTree(arr, start, mid - 1));
		n.setRight(createTree(arr, mid + 1, end));
		return n;
	}
}

