public class MergeTwoSortedLists {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}	

	public ListNode mergeLinkedList(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = l1;
		dummy.next = curr;
		ListNode prev = dummy;

		while (curr != null && l2 != null) {
			if (curr.val < l2.val) {
				prev = curr;
				curr = curr.next;
			} else {
				prev.next = l2;
				l2.next = l2.next;
				prev = prev.next;
				prev.next = curr;
			}
		}
		// because curr == null now and prev points to last node
		if (l2 != null) {
			prev.next = l2;
		}
		return dummy.next;
	}
}
