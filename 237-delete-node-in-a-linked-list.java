class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while(curr.next != null) {
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
    }
}
