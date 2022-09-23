class Solution {
    /*public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while(head != null) {
            values.add(head.val);
            head = head.next;
        }
        
        for(int start = 0, end = values.size() - 1; start < end; start++, end--) {
            if(values.get(start) != values.get(end)) {
                return false;
            }
        }
        
        return true;
    }*/  
    
    public boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);
        
        // Reverse second half
        ListNode tail = reverse(middle);
        
        // Compare first half with second half
        boolean isPalindrome = isEqual(tail, head);
        
        // Restore second half
        reverse(tail);
        
        return isPalindrome;
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
        while(head != null) {
            ListNode oldNext = head.next;
            head.next = prev;
            prev = head;
            head = oldNext;
        }
        
        return prev;
    }
    
    private boolean isEqual(ListNode first, ListNode second) {
        while(first != null) {
            if(first.val != second.val) {
                return false;
            }
            
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
    /*public boolean isPalindrome(ListNode head) {
        // Find middle
        ListNode middle = getMiddle(head);
        
        // Reverse second half
        ListNode tail = reverse(middle);

        // Compare seconcd half with first half
        boolean isPalindrome = isEqual(tail, head);
        
        // Resotre second half
        reverse(tail);
        
        return isPalindrome;
    }*/
    
    /*private ListNode getMiddle(ListNode head) {
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
    }*/
}
