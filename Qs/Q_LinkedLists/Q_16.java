public class Q_16 {
	
	public static void main(String[] args) {

		Node n5 = new Node(5);
		Node n8 = new Node(8);
		Node n3 = new Node(3);
		Node n6 = new Node(6);

		n5.setNext(n8);
		n8.setNext(n3);
		n3.setNext(n6);

		printLL(reverseOnline(n5));
	}

	private static Node reverseLL(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = curr.getNext();

		while (next != null) {
			curr.setNext(prev);
			prev = curr;
			curr = next;
			next = next.getNext();	
		}
		curr.setNext(prev);
		return curr;
	}


	private static void printLL(Node head) {
			Node curr = head;
			while (curr != null) {
				System.out.print(curr.getValue() + " ");
				curr = curr.getNext();
			}
			System.out.println();
	}

	private static Node reverseOnline(Node head) {
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

}
