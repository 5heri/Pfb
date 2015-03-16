public class ReverseLinkedListII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;
		int pos = 1;


		while (pos < m && curr != null) {
			prev = curr;
			curr = curr.next;
			pos++;
		}

		while (pos < n && curr != null) {
			ListNode nextToNext = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nextToNext;
			pos++;
		}

		return dummy.next;
	}	

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		print(reverseBetween(n1, 2, 4));
	}

	private static void print(ListNode node) {
		for (ListNode curr = node; curr != null; curr = curr.next) {
			System.out.print(curr.val + " ");
		}
		System.out.println();
	}
}
