class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val != prev.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        
        if(prev != null) {
            prev.next = null;            
        }

       
        return head;
    }
}
