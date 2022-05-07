class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        
        while(p1 != null || p2 != null) {
            int val1 = p1 == null? 0 : p1.val;
            int val2 = p2 == null? 0 : p2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        
            if(p1 != null) { p1 = p1.next; }           
            if(p2 != null) { p2 = p2.next;}
        }
        
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}
