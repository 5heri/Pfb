public class LinkedListIandII {
	
	class ListNode {
		int val;
		ListNode next;
	}

	public ListNode findCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null & fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.val == fast.val) {
				break;
			}
		}

		// no cycle
		if (fast == null || fast.next == null) {
			return null;	
		}

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
