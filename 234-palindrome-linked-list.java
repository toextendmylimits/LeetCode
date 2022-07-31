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
    /*public boolean isPalindrome(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
        }
        
        for(int start = 0, end = nodes.size() - 1; start < end; start++, end--) {
            if(nodes.get(start).val != nodes.get(end).val) {
                return false;
            }
        }
        
        return true;
    }*/
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
               
        ListNode endOfFirstHalf = geEndOfFirstHalf(head);
        ListNode startOfSecondHalf = endOfFirstHalf.next;
            
        boolean isPalindrome = arePalindromeHalfs(head, reverse(startOfSecondHalf));       
        endOfFirstHalf.next = reverse(startOfSecondHalf);
        
        return isPalindrome;
    }  
    
    private ListNode geEndOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private boolean arePalindromeHalfs(ListNode firstHalf, ListNode secondHalf) {
        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val) {
                return false;
            }
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
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
