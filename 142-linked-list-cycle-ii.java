/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersect(head);
        if(intersect == null) { return null; }

        ListNode p1 = head;
        ListNode p2 = intersect;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
    
    private ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return fast;
            }
        }
        
        return null;
    }
    /*public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while(current != null) {
            if(set.contains(current)) {
                return current;
            }
            
            set.add(current);
            current = current.next;
        }
        
        return null;
    }*/
}
