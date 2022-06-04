class Solution {
     public boolean isPalindrome(ListNode head) {       
        List<ListNode> nodes = new ArrayList<>();
         ListNode curr = head;
         while(curr != null) {
             nodes.add(curr);
             curr = curr.next;
         }
         
         for(int i = 0, j = nodes.size() - 1; i < j; i++, j--) {
             if(nodes.get(i).val != nodes.get(j).val) {
                 return false;
             }
         }
         
         return true;
    }   
    /*public boolean isPalindrome(ListNode head) {
        if(head == null) { return true; }
        
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        
        boolean result = true;
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while(result && p2 != null) {
            if(p1.val != p2.val) { result = false; }
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        firstHalfEnd.next = reverse(secondHalfStart);
        return result;
    }*/
    
    private ListNode getFirstHalfEnd(ListNode head) {
       ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
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
     
    public boolean isPalindrome(ListNode head) {
        // Find middle
        ListNode middle = getMiddle(head);
        
        // Reverse second half
        ListNode tail = reverse(middle);

        // Compare seconcd half with first half
        boolean isPalindrome = isEqual(tail, head);
        
        // Resotre second half
        reverse(tail);
        
        return isPalindrome;
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private boolean isEqual(ListNode shorterHalf, ListNode longerHalf) {
        while(shorterHalf != null) {
            if(shorterHalf.val != longerHalf.val) {
                return false;
            }
            shorterHalf = shorterHalf.next;
            longerHalf = longerHalf.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
