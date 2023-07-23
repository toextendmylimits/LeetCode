# Linked List
1. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)  
    Without using dummy head, the two pointers should be **n step**s apart, and should check whether the **removed node is head**, also the right pointer should be **the last element**
   ```
   for i in range(n):
       fast = fast.next
   
   if not fast:
      return head.next

   while fast.next:
      fast = fast.next
      slow = slow.next
   ```
   
