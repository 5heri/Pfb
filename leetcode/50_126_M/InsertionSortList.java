public class InsertionSortList {
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

	/*public static ListNode insertionSort(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newHead = new ListNode(head.val);
		ListNode pointer = head.next;
		while (pointer != null) {

			ListNode newListP = newHead;

			if (pointer.val <= newListP.val) {
				ListNode oldHead = newHead;
				newHead = pointer;
				pointer.next = oldHead;
			} else {

				ListNode runnerNewHead = newHead;

				while (runnerNewHead != null) {

				}
			}
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(1);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
 
		n1 = insertionSort(n1);
 
		printList(n1);
	}*/
 
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}
