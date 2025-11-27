# BFS 
from collections import deque

class Solution:
    def depthSumInverse(self, nestedList: List[NestedInteger]) -> int:
        queue = deque(nestedList)
        runningSum = 0   # cumulative sum of all integers seen so far
        total = 0        # final weighted result

        while queue:
            # Process one depth level at a time
            for _ in range(len(queue)):
                elem = queue.popleft()

                if elem.isInteger():
                    # Add current level's integers into the running cumulative sum
                    runningSum += elem.getInteger()
                else:
                    # Add the nested list into the queue for next level
                    queue.extend(elem.getList())

            # Add the cumulative sum to total → creates reverse weighting
            total += runningSum

        return total
