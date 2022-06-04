public class Solution {
    /*public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                return true;
            }
        }
        
        return false;
    }*/
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while(head != null) {
            if(!seen.add(head)) {
                return true;
            }

            head = head.next;
        }
        
        return false;
    }    
}
