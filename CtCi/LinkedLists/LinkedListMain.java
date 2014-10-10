import java.util.*;

public class LinkedListMain {
	
	public static void main(String[] args) {

		Node<Integer> n1 = new Node<Integer>(new Integer(1));
		Node<Integer> n2 = new Node<Integer>(new Integer(8));
		Node<Integer> n3 = new Node<Integer>(new Integer(11));
		Node<Integer> n4 = new Node<Integer>(new Integer(3));
		Node<Integer> n5 = new Node<Integer>(new Integer(7));
		Node<Integer> n6 = new Node<Integer>(new Integer(2));
		Node<Integer> n7 = new Node<Integer>(new Integer(12));
		Node<Integer> n8 = new Node<Integer>(new Integer(6));
		Node<Integer> n9 = new Node<Integer>(new Integer(4));



		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n9);


		print(n1);

		// delDup(n1); // works
		// delDupNoBuffer(n1); // works

		//System.out.println(kthToLast(2, n1).getValue()); // not checking for NULL here

		//deleteNode(n4);

		Node<Integer> partitioned = partition(n1, 5);
		print(partitioned);
		print(n1);


		Node<Integer> a1 = new Node<Integer>(new Integer(7));
		Node<Integer> a2 = new Node<Integer>(new Integer(1));
		Node<Integer> a3 = new Node<Integer>(new Integer(6));
		a1.setNext(a2);
		a2.setNext(a3);

		Node<Integer> b1 = new Node<Integer>(new Integer(1));
		Node<Integer> b2 = new Node<Integer>(new Integer(7));
		//Node<Integer> b3 = new Node<Integer>(new Integer(7));
		b1.setNext(b2);
		//b2.setNext(b3);

		a3.setNext(b1);

		//print(addLists(a1, b1, 0));

		print(a1);

		System.out.println(isPalindrome(a1));
		
	}


	private static boolean isPalindrome(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.getNext() != null) {
			stack.push(slow.getValue());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		if (fast != null) {
			slow = slow.getNext();
		}

		while (slow != null) {
			if (slow.getValue() != stack.pop().intValue()) {
				return false;
			}
			slow = slow.getNext();
		}
		return true;
	}

	private static Node<Integer> addLists(Node<Integer> firstNode, 
											Node<Integer> secondNode, int carry) {
		if (firstNode == null && secondNode == null && carry == 0) {
			return null;
		}

		int value = carry;
		if (firstNode != null) {
			value += firstNode.getValue();
		}

		if (secondNode != null) {
			value += secondNode.getValue();
		}

		Node<Integer> result = new Node<Integer>(new Integer(0));

		result.setValue(new Integer(value % 10));

		if (firstNode != null || secondNode != null) {
			Node<Integer> next = addLists(firstNode == null ? null : firstNode.getNext(),
				secondNode == null ? null : secondNode.getNext(), value >= 10 ? 1 : 0);
			result.setNext(next);
		}

		return result;
	}

	private static Node<Integer> partition(Node<Integer> curr, int x) {
		Node<Integer> lessThanHead = null;
		Node<Integer> lessThanTail = null;
		Node<Integer> greaterThanHead = null;


		while (curr != null) {
			Node<Integer> next = curr.getNext();
			curr.setNext(null);
			if (curr.getValue() < x) {
				if (lessThanHead == null) {
					lessThanHead = curr;
					lessThanTail = curr;
				} else {
					lessThanTail.setNext(curr);
					lessThanTail = lessThanTail.getNext();
				}
			} else {
				if (greaterThanHead == null) {
					greaterThanHead = curr;
				} else {
					curr.setNext(greaterThanHead.getNext());
					greaterThanHead.setNext(curr);
				}
			}
			curr = next;
		}
		lessThanTail.setNext(greaterThanHead);

		return lessThanHead;
	}

	private static boolean deleteNode(Node<Integer> node) {
		if (node == null || node.getNext() == null) {
			return false;
		}

		node.setValue(node.getNext().getValue());
		node.setNext(node.getNext().getNext());

		return true;
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

	private static Node<Integer> kthToLast(int k, Node<Integer> head) {
		if (k < 0) {
			return null;
		}

		Node<Integer> pointerToEnd = head;
		Node<Integer> pointerToKth = head;

		for (int i = 0; i < k; i++) {
			if (pointerToEnd == null) {
				return null;
			}
			pointerToEnd = pointerToEnd.getNext();
		}

		while (pointerToEnd.getNext() != null) {
			pointerToKth = pointerToKth.getNext();
			pointerToEnd = pointerToEnd.getNext();
		}

		return pointerToKth;
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
