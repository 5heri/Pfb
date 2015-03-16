public class PartitionList {

	class ListNode {
		int val;
		ListNode next;
	}	

	public ListNode partition(ListNode head, int x) {
    	ListNode beforeStart = null;
    	ListNode beforeEnd = null;

    	ListNode afterStart = null;
    	ListNode afterEnd = null;

    	while (head != null) {
    		ListNode next = head.next;
    		head.next = null;
    		if (head.val < x) {
    			if (beforeStart == null) {
    				beforeStart = head;
    				beforeEnd = beforeStart;
    			} else {
    				beforeEnd.next = head;
    				beforeEnd = beforeEnd.next;
    			}
    		} else {
    			if (afterStart == null) {
    				afterStart = head;
    				afterEnd = beforeStart;
    			} else {
    				afterEnd.next = head;
    				afterEnd = afterEnd.next;
    			}
    		}
    		head = next;
    	}

    	if (beforeStart == null) return afterStart;

    	beforeEnd.next = afterStart;
    	return beforeStart;
    }
}
