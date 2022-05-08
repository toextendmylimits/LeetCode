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
    /*public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        ListNode l1 = list1;
        ListNode l2 = list2;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        current.next = l1 == null? l2 : l1;
        
        return dummyHead.next;
    }*/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        else if(list2 == null) {
            return list1;
        }
        else if(list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }    
}
