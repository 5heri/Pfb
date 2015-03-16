/*

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode r = slow.next;
		slow.next = null;
		ListNode l = head;

		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);

		return merge(h1, h2);
    }
    
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode pl = l;
        ListNode pr = r;
        
        while (pl != null || pr != null) {
            if (pl == null) {
                p.next = pr;
                break;
            } else if (pr == null) {
                p.next = pl;
                break;
            } else {
                if (pl.val <= pr.val) {
                    p.next = pl;
                    pl = pl.next;
                    p = p.next;
                } else {
                    p.next = pr;
                    pr = pr.next;
                    p = p.next;
                }
            }
        }
        return dummy.next;
    }
}

*/


public class SortList {


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

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode r = slow.next;
		slow.next = null;
		ListNode l = head;

		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);

		return merge(h1, h2);
	}

	private static ListNode merge(ListNode l, ListNode r) {
		ListNode pLeft = l;
		ListNode pRight = r;

		ListNode dummyHead = new ListNode(-1);
		ListNode pNew = dummyHead;

		while (pLeft != null || pRight != null) {
			if (pLeft == null) {
				pNew.next = new ListNode(pRight.val);
				pNew = pNew.next;
				pRight = pRight.next;
			} else if (pRight == null) {
				pNew.next = new ListNode(pLeft.val);
				pNew.next = pNew.next;
				pLeft = pLeft.next;
			} else {
				if (pLeft.val < pRight.val) {
					pNew.next = new ListNode(pLeft.val);
					pNew = pNew.next;
					pLeft = pLeft.next;
				} else if (pLeft.val == pRight.val) {
					pNew.next = new ListNode(pLeft.val);
					pNew = pNew.next;
					pLeft = pLeft.next;
					pNew.next = new ListNode(pRight.val);
					pNew = pNew.next;
					pRight = pRight.next;
				} else {
					pNew.next = new ListNode(pRight.val);
					pNew = pNew.next;
					pRight = pRight.next;
				}
			}
		}
		return dummyHead.next;
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
 
		n1 = sortList(n1);
 
		printList(n1);
	}
 
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
