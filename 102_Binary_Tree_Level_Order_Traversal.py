I use breadth-first search.   
I start from the root and process the tree level by level using a queue.   
For each level, I record all node values, then push their children into the queue.   
Each iteration produces one level of the result.  

from collections import deque

class Solution:
    def levelOrder(self, root):
        if not root:
            return []

        result = []
        queue = deque([root])

        while queue:
            level = []
            size = len(queue)

            for _ in range(size):
                node = queue.popleft()
                level.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(level)

        return result
