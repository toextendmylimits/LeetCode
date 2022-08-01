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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode preFirstNodeOfKGroup = dummy;
        while(preFirstNodeOfKGroup != null && preFirstNodeOfKGroup.next != null) {
            ListNode node = preFirstNodeOfKGroup;
            int i = 0;
            while(i < k && node.next != null) {
                node = node.next;
                i++;
            }
            
            // Less than k nodes left
            if(i < k) {
                break;
            }
            
            preFirstNodeOfKGroup = getPreFirstNodeAfterReverse(preFirstNodeOfKGroup, k);
        }
        
        return dummy.next;
    }
    
    private ListNode getPreFirstNodeAfterReverse(ListNode preFirstNode, int k) {
        ListNode prev = null;
        ListNode curr = preFirstNode.next;
        for(int i = 0; i < k; i++) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }

        ListNode tail = preFirstNode.next;
        tail.next = curr;
        preFirstNode.next = prev;
        
        return tail;
    }
}
