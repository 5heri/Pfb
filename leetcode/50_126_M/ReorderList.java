public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode reorderList(ListNode head) {
		if (head == null || head.next == null) 	return head;

		ListNode mid = findMid(head);
		mid = reverse(mid);
		return merge(head, mid);
	}

	private static ListNode merge(ListNode h1, ListNode h2) {
		ListNode p1 = h1;
		ListNode p2 = h2;
		ListNode p1Next = null;
		ListNode p2Next = null;

		while (p1 != null && p2 != null) {
			p1Next = p1.next;
			p2Next = p2.next;

			p1.next = p2;
			p2.next = p1Next;

			if (p1Next == null) {
				p2.next = p2Next;
			}

			p1 = p1Next;
			p2 = p2Next;
		}
		return h1;
	}

	private static ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (prev != null) {
			prev.next = null;
		}
		return slow;
	}

	private static ListNode reverse(ListNode head) {
		ListNode next = null;
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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

		print(reorderList(n1));
	}

	private static void print(ListNode head) {
		for (ListNode node = head; node != null; node = node.next) {
			System.out.print(node.val + " ");
		}
		System.out.println();
	}
}






