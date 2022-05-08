public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
            pA = pA == null? headB : pA.next;
            pB = pB == null? headA : pB.next;
        }
        
        return pA;
    }    
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeInA = new HashSet<>();
        
        while(headA != null) {
            nodeInA.add(headA);
            headA = headA.next;            
        }
        
        while(headB != null) {
            if(nodeInA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        
        return null;
    }*/
}
