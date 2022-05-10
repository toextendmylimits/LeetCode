class Solution {
    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);
        
        ListNode first = head;
        ListNode second = reverse(middle);
        
        while(second != null && second.next != null) {
            ListNode nextTempFirstHalf = first.next;
            ListNode nextTempSecondHalf = second.next;
            first.next = second;
            second.next = nextTempFirstHalf;
            first = nextTempFirstHalf;
            second = nextTempSecondHalf;  
        }
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
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}
