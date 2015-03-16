public class RotateList {

	class ListNode {
		int val;
		ListNode next;
	}

	public ListNode rotate(ListNode head, int k) {
		int len = 1;
		ListNode p = head;

		while (p.next != null) {
			len++;
			p = p.next;
		}

		p.next = head;
		k = len - k % len;
		for (int i = 0; i < k; i++) {
			p = p.next;
		}

		head = p.next;
		p.next = null;
		return head;
	} 
}
