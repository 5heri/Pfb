import java.lang.StringBuilder;

public class DeleteDuplicatesSortedLinkedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;

		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				curr.next = curr.next.next;
				continue;
			}
			curr = curr.next;

		}
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);

		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		printLL(n1);

		ListNode newNode = deleteDuplicates(n1);
		printLL(newNode);
	}

	private static void printLL(ListNode node) {
		if (node == null) {
			return;
		}
		ListNode curr = node;

		StringBuilder sb = new StringBuilder();

		sb.append(curr.val);
		curr = curr.next;

		while (curr != null) {
			sb.append("->");
			sb.append(curr.val);
			curr = curr.next;
		}
		System.out.println(sb.toString());

	}
		
}
