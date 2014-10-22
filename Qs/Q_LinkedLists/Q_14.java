public class Q_14 {
	
	public static void main(String[] args) {
		Node l11 = new Node(1);
		Node l13 = new Node(3);
		Node l15 = new Node(5);
		l11.setNext(l13);
		l13.setNext(l15);

		Node l22 = new Node(2);
		Node l24 = new Node(4);
		Node l26 = new Node(6);
		l22.setNext(l24);
		l24.setNext(l26);

		//printLL(mergeLListsREC(l11, l22));  // works
		printLL(mergeLListsITR(l11, l22));    // works

	}

	private static Node mergeLListsITR(Node l1, Node l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		Node head;
		if (l1.getValue() < l2.getValue()) {
			head = l1;
		} else {
			head = l2;
			l2 = l1;
			l1 = head;
		}

		while (l1.getNext() != null && l2 != null) {
			if (l1.getNext().getValue() > l2.getValue()) {
				Node tmp = l1.getNext();
				l1.setNext(l2);
				l2 = tmp;
			}
			l1 = l1.getNext();
		}

		if (l1.getNext() == null) {
			l1.setNext(l2);
		}
		return head;
	}

	private static Node mergeLListsREC(Node l1, Node l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		if (l1.getValue() < l2.getValue()) {
			l1.setNext(mergeLListsREC(l1.getNext(), l2));
			return l1;
		} else {
			l2.setNext(mergeLListsREC(l2.getNext(), l1));
			return l2;
		}
	}

	private static void printLL(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.getValue() + " ");
			curr = curr.getNext();
		}
		System.out.println();
	}
}
