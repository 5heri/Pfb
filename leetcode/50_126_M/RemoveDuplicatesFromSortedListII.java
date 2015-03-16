public class RemoveDuplicatesFromSortedListII {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode removeDups(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		ListNode rem = null;

		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val || (rem != null && curr.val == rem.val)) {
				prev.next = curr.next;
				rem = curr;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		print(removeDups(n1));
	}

	private static void print(ListNode head) {
		for (ListNode n = head; n != null; n = n.next) {
			System.out.print(n.val + " ");
		}
		System.out.println();
	}
}
