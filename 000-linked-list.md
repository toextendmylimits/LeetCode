# Linked List
## Easy
1. [1650. Lowest Common Ancestor of a Binary Tree III](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii)   
    Treat this issue as a problem to find whether two linked lists intersect. Appraoch 1: TC O(H),SC O(H), Approach 2: TC O(H), SC O(1)  
    <details>

        ```python
        def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
            ancestorsOfP = set()
            while p:
                ancestorsOfP.add(p)
                p = p.parent
            
            while q:
                if q in ancestorsOfP:
                    return q
                q = q.parent
            
            return None

        # Approach 2
        def lowestCommonAncestor(self, p: 'Node', q: 'Node') -> 'Node':
            first = p
            second = q
            while first != second:
                first = first.parent if first else q
                second = second.parent if second else p    

        return first    
        ```
    </details>
    
1. [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)  
    1. First we set up a dummy head that allows us retrieve the head of the merged list later. And We also maintain a prev pointer connect merged list with the other lists
    1. Then, we do the following until l1 or l2 is null:
        1. if the value at l1 is less than or equal to the value at l2, then we connect l1 to the previous node and increment l1.
        1. Otherwise, we connect l2 to the previous node and increment l2. 
        1. Then, regardless of which list we connecte we increment prev of merged list.
    1. Findally we connect the merged list with the list that is not null
    <details>

    ```python
        def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
            preHead = ListNode()
            prev = preHead
            while list1 and list2:
                if list1.val < list2.val:
                    prev.next = list1
                    list1 = list1.next
                else:
                    prev.next = list2
                    list2 = list2.next
    
                prev = prev.next
    
            prev.next = list1 or list2
    
            return preHead.next
    ```
    </details>

1. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)  
    Without using dummy head, the two pointers should be **n step**s apart, and should check whether the **removed node is head**, also the right pointer should be **the last element**
        <details>
    
           ```python
               for i in range(n):
                   fast = fast.next
               
               if not fast:
                  return head.next
            
               while fast.next:
                  fast = fast.next
                  slow = slow.next
              
               #When using dummy head, the two pointers are also ** n steps** apart, and the **right pointer should be last item**
               
               for i in range(n):
                   fast = fast.next
                  
                while fast.next:
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
1. [142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii)  
    Inutitive to use set. However, very difficult to achieve O(1) space complexity
    <details>

        ```python
            def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
                seen = set()
                while head:
                    if head in seen:
                        return head
                    else:
                        seen.add(head)
                        head = head.next
                
                return None
        ```
    </details>
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
    ***Approach 1 - Two pointer***
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
    
    ***Approach 2 - Hash table***
    Create a set, and put linker list 1 into set  
    Scan list 2, if any element in set, then found intersection, otherwise continue  
    <details>

    ```python
        def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
            seen = set()
            while headA:
                seen.add(headA)
                headA = headA.next
            
            while headB:
                if headB in seen:
                    return headB
                headB = headB.next
            
            return None
    ```
    </details>

    ***Approach 3 - Brutal force***
    Scan list 1, and for each node, check whether it exits in list2
    <details>

    ```python
        def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
            while headA:
                pB = headB
                while pB:
                    if pB == headA:
                        return headA
                    pB = pB.next
                headA = headA.next
            return None
    ```
    </details>
1. [203. Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements)  
    Create a dummy node to allow retrieving head later, and initialize pointer prev with dummy node, and current pointer point to head  
    If curr is not null, repeat following steps:  
    1. if value of curr equals to val, connect prev to curr.next
    1. otherwise advance prev to be curr
    1. In the end, always advance curr to its next 
    <details>

    ```python
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        prev = dummy
        curr = head
        while curr:
            if curr.val == val:
                prev.next = curr.next
            else:
                prev = curr
            curr = curr.next

        return dummy.next
    ```
    </details>
1. [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers)  
    Create dummy head to allow retrieving head easily  
    Iterate if either l1 or l2 is not null, add val1 + val2 + carry  
    In the end if carry is 1, add to end of list  
    ***Time complexity is O(max(M, N)), space complexity is O(1)***
    <details>

    ```python
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummy = ListNode()
        curr = dummy
        while l1 or l2:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            total = val1 + val2 + carry
            curr.next = ListNode(total % 10)
            carry = total // 10

            curr = curr.next 
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        if carry == 1:
            curr.next = ListNode(1)
        
        return dummy.next
    ```
    </details>
    
## Medium
1. [146. LRU Cache](https://leetcode.com/problems/lru-cache)
   Intuition:  
    Need to support get and put, so naturally to use hash map. Also need to maintain order of items based on its most recent use time, so could use a double linked list, the front of the list is most recent visited item, and the end of the list the least recent useed item.  

    The idea is:  
    Use a hash map, key is key, and while is a Node, which has attributes, key, value, prev and next node. Use a double linked list to maintian order of nodes.  
    1. In LRUCache constructor, create a map and a dummy head and tial node  
    1. In get method, if key not exists, return -1; Otherwise, remove the node, add to head, and then return value. So need to implement method add and remove   
    1. In put method, if key exists, remove node, add to head, and update value; Otherwise check if capacity has been reached, if so remove least recently used node(tail.prev), delete from map. Then create a new node, add to head, put to map  
    TC O(1) for put and get, SC O(capacity)      
    <details>

    ```python
        class Node:
            def __init__(self, key, val):
                self.key = key
                self.val = val
                self.prev = None
                self.next = None

        class LRUCache:
            def __init__(self, capacity):
                self.capacity = capacity
                self.keyNodeMap = {}
                self.head = Node(-1, -1)
                self.tail = Node(-1, -1)
                self.head.next = self.tail
                self.tail.prev = self.head
            
            def get(self, key):
                if not key in self.keyNodeMap:
                    return -1
                
                node = self.keyNodeMap[key]
                self._remove(node)
                self._add(node)
                return node.val
            
            def _remove(self, node):
                node.prev.next = node.next
                node.next.prev = node.prev
            
            def _add(self, node):
                currFirst = self.head.next
                self.head.next = node
                node.prev = self.head
                node.next = currFirst
                currFirst.prev = node
            
            def put(self, key, val):
                if key in self.keyNodeMap:
                    node = self.keyNodeMap[key]
                    self._remove(node)
                    self._add(node)
                    node.val = val
                else:
                    if self.capacity == len(self.keyNodeMap):
                        lruNode = self.tail.prev
                        self._remove(lruNode)
                        del self.keyNodeMap[lruNode.key]
        
                    newNode = Node(key, val)
                    self._add(newNode)
                    self.keyNodeMap[key] = newNode
    ```
    </details>
    
1. [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list)  
    1. if head is null or head.next is null, just return head  
    1. Maintian evenHead which is head.next   
    1. Iterate when even and even.next is not null, in each itertation, connect odd with even.next, and advance odd; connect even with odd.next, and advance even
    1. Connect odd with evenHead  
    <details>

    ```python
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        odd = head
        even = head.next
        evenHead = even
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        
        odd.next = evenHead
        return head
    ```
    </details>
## Difficult and to visit later if have time
1. [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii)
1. [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list)  
    Difficult to achieve O(1) space complexity
1. [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list)
1. [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs)  
1. [61. Rotate List](https://leetcode.com/problems/rotate-list)
1. [707. Design Linked List](https://leetcode.com/problems/design-linked-list)  
1. [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group)  
   
