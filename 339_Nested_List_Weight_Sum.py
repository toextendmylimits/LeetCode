# Approach 1: DFS
class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        
        def dfs(nlist, depth):
            total = 0
            for elem in nlist:
                if elem.isInteger():
                    total += elem.getInteger() * depth
                else:
                    total += dfs(elem.getList(), depth + 1)
            return total
        
        return dfs(nestedList, 1)

# Approach 2: BFS
from collections import deque

class Solution:
    def depthSum(self, nestedList: List[NestedInteger]) -> int:
        total = 0
        queue = deque(nestedList)
        depth = 1

        while queue:
            for _ in range(len(queue)):   # fixed level size loop
                elem = queue.popleft()
                if elem.isInteger():
                    total += elem.getInteger() * depth
                else:
                    queue.extend(elem.getList())
            depth += 1

        return total

