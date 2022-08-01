/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        
        ListNode middle = getMiddle(head);
        reorder(head, reverse(middle));
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private void reorder(ListNode first, ListNode second) {
        while(second != null && second.next != null) {
            ListNode oldNextOfFirst = first.next;
            ListNode oldNextOfSecond = second.next;
            first.next = second;
            second.next = oldNextOfFirst;
            first = oldNextOfFirst;
            second = oldNextOfSecond; 
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }
        
        return prev;
    }
    
}
