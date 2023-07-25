# Linked List
## Easy
1. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)  
    Without using dummy head, the two pointers should be **n step**s apart, and should check whether the **removed node is head**, also the right pointer should be **the last element**
   <details>

       ```
       for i in range(n):
           fast = fast.next
       
       if not fast:
          return head.next
    
       while fast.next:
          fast = fast.next
          slow = slow.next
       ```
       When using dummy head, the two pointers should be **(n + 1) steps** apart, and the **right pointer should be null**
       ```
       for i in range(n + 1):
           fast = fast.next
          
        while fast:
            fast = fast.next
            slow = slow.next
   ```
    </details>
1. [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list)  
    When the list have even number of nodes, return the second middle node
    <details>

    ```python
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:     
        fast = head
        slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        return slow
    ```
    </details>
1. [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle)
    Use fast slow pointers
1. [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list)  
    Have a pointer for previous node, and current node, in each iteration, save old next, then change curr element's next to previous one, then update previous and current  
    Need to memorize this code
    <details>

        ```python
        prev = None
        curr = head
        while curr:
            oldNext = curr.next
            curr.next = prev
            prev = curr
            curr = oldNext

        return prev
        ```
    </details>
1. [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)  
    If A and B are of same length, just compare each node
    If A and B are of different length, A + B = A_diff + share + B_diff + share, B + A = B_diff + share + A_diff + share
    <details>

    ```python
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        currA = headA
        currB = headB
        while currA or currB:
            if currA == currB:
                return currA
            currA = currA.next if currA else headB
            currB = currB.next if currB else headA
    ```
    </details>

## Medium
1. [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii)
   
