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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyBeforeHead = new ListNode(-1, head);
        ListNode current = dummyBeforeHead;
        
        while(current.next != null && current.next.next != null) {
            ListNode firstNext = current.next;
            ListNode thirdNext = current.next.next.next;
            
            current.next = current.next.next;
            current.next.next = firstNext;
            current.next.next.next = thirdNext;
            
            current = current.next.next;           
        }
        
        return dummyBeforeHead.next;
    }
}
