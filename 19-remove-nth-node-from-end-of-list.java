class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode p1 = dummyHead;
        for(int i = 1; i <= n + 1; i++) {
            p1 = p1.next;
        }
        
        ListNode prev = dummyHead;
        while(p1 != null) {
            p1 = p1.next;
            prev = prev.next;
        }
        
        prev.next = prev.next.next;
   
        return dummyHead.next;
    }
}
