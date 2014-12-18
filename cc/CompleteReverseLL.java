
/**
 * Reverse a singly linked list, and reverse the
 * array contained in each node
 *
 * Example:
 *   Input list:
 *     +-----+   +---------+   +-+
 *     |1|2|3|-->|4|3|1|5|6|-->|7|
 *     +-----+   +---------+   +-+
 *
 *   Output list:
 *     +-+   +---------+   +-----+
 *     |7|-->|6|5|1|3|4|-->|3|2|1|
 *     +-+   +---------+   +-----+
 *
 * @return a reference to the start of the reversed list
 */
import java.lang.StringBuilder;

public class CompleteReverseLL {
	
	public static Node reverse(Node head) {
		Node prev = null;
		Node next = null;
		Node curr = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			reverse(curr.data);
			prev = curr;
			curr = next;
		}
		return prev;
	} 

	private static void reverse(int[] a) {
		for (int i = 0; i < a.length/2; i++) {
			int tmp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = tmp;
		}
	}


	static class Node {
		int[] data;
		Node next;

		Node(int[] data) {
			this.data = data;
		}

		@Override
		public String toString() {
			if (data.length == 0) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			sb.append(data[0]);

			for (int i = 1; i < data.length; i++) {
				sb.append(' ');
				sb.append(data[i]);
			}
			return sb.toString();
		}
	}	

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {4,3,1,5,6};
		int[] c = {7};

		Node a1 = new Node(a);
		Node b1 = new Node(b);
		Node c1 = new Node(c);

		a1.next = b1;
		b1.next = c1;

		Node newHead = reverse(a1);

		while (newHead != null) {
			System.out.println(newHead);
			newHead = newHead.next;
		}
	}


}

