import java.util.*;

public class LinkedListMain {
	
	public static void main(String[] args) {

		Node<Integer> n1 = new Node<Integer>(new Integer(5));
		Node<Integer> n2 = new Node<Integer>(new Integer(2));
		Node<Integer> n3 = new Node<Integer>(new Integer(2));
		Node<Integer> n4 = new Node<Integer>(new Integer(6));
		Node<Integer> n5 = new Node<Integer>(new Integer(9));
		Node<Integer> n6 = new Node<Integer>(new Integer(9));


		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);

		print(n1);

		// delDup(n1); // works
		delDupNoBuffer(n1);

		print(n1);
	}


	private static void delDup(Node<Integer> head) {
		Set<Integer> buffer = new HashSet<Integer>();
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		while (curr != null) {
			if (buffer.contains(curr.getValue())) {
				prev.setNext(curr.getNext());
			} else {
				buffer.add(curr.getValue());
				prev = curr;
			}
			curr = curr.getNext();
		}
	}

	private static void delDupNoBuffer(Node<Integer> head) {
		if (head == null) {
			return;
		}

		Node<Integer> curr = head;

		while (curr != null) {
			Node<Integer> pointer = curr.getNext();
			while (pointer != null) {
				if (curr.getValue().equals(pointer.getValue())) {  // Integer Objects
					curr.setNext(pointer.getNext());			  
				}
				pointer = pointer.getNext();
			}
			curr = curr.getNext();
		}
	}

	private static void print(Node<Integer> n) {
		Node<Integer> pointer = n;
		while (pointer != null) {
			System.out.print(pointer.getValue() + " ");
			pointer = pointer.getNext();
		}
		System.out.println();
	}
}
