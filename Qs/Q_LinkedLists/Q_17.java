public class Q_17 {
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n2);

		System.out.println(startOfLoop(n1).getValue());
	}

	private static Node startOfLoop(Node head) {
		Node slow = head;
		Node fast = head;

		// Find meeting point
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			if (slow.equals(fast)) {
				break;
			}
		}

		// No loop as fast hit end of LL
		if (fast == null || fast.getNext() == null) {
			return null;
		}

		slow = head;

		while (!slow.equals(fast)) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return fast;
	}

}
