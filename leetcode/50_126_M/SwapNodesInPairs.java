public class SwapNodesInPairs {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}	

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newHead = head.next;
		ListNode tmp = null;
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			if (curr.next != null) {
				tmp = curr.next.next;
				curr.next.next = curr;
				if (prev != null) prev.next = curr.next;
				curr.next = tmp;
				prev = curr;
				curr = tmp;
			} else {
				prev.next = curr;
				curr = null;
			}
		}
		return newHead;

	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = new ListNode(5);

		printList(swapPairs(n1));
	}

	private static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
