public class Q_18 {
	
	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		//n4.setNext(n5);

		System.out.println(middleOfLL(n1).getValue());
	}

	private static Node middleOfLL(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		// if clause not really required
		// only there as a check if even or odd
		// returns same value anyway
		if (fast != null) {
			return slow;   // middle as list is odd length
		} else {
			// middle not exactly known as list is even length
			return slow; 
		}

	}
}
