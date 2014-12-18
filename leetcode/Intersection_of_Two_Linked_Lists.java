/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int lengthA = 0;
        int lengthB = 0;
        
        while (currA != null || currB != null) {
            if (currA != null) {
                lengthA++;
                currA = currA.next;   
            } else if (currB != null) {
                lengthB++;
                currB = currB.next;
            }
        }
        currA = headA;
        currB = headB;
        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                currA = currA.next;
            }
        } else if (lengthB > lengthA) {
            int diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                currB = currB.next;
            }
        }
        
        while (currA != null) {
            if (currA.val == currB.val) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }
}
