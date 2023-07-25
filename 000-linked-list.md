# Linked List
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
   
