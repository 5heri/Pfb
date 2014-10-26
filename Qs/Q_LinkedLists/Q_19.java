public class Q_19 {
	
	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		Node n4 = new Node(9);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);

		printLL(addOneToLL(n1));
	}

	private static Node addOneToLL(Node head) {
		if (head == null) return null;

		Node n = reverseLL(head);
		int carry = 1;    	// simulate adding 1 value

		Node resultingList = null; 
		Node finalList = resultingList;

		while (n != null && carry != 0) {
			int value = carry + n.getValue();
			carry = 0;
			if (value >= 10) {
				carry = 1;
			}
			if (resultingList == null) {
				resultingList = new Node(value % 10);
				finalList = resultingList;
			} else {
				resultingList.setNext(new Node(value % 10));
				resultingList = resultingList.getNext();
			}
			n = n.getNext();
		}

		if (n == null && carry != 0) {
			resultingList.setNext(new Node(carry));
		}
		return reverseLL(finalList);
	}

	private static Node reverseLL(Node head) {
		Node prev = null;
		Node next = null;
		Node curr = head;

		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
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
