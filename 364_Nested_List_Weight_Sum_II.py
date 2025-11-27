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

# DFS
class Solution:
    def depthSumInverse(self, nested_list: List[NestedInteger]) -> int:
        max_depth = self.calc_max_depth(nested_list, 1)
        return self.calc_weight_sum(nested_list, 1, max_depth)
    
    def calc_max_depth(self, nested_list, depth):
        max_depth = depth
        for item in nested_list:
            if not item.isInteger():
                max_depth = max(max_depth, self.calc_max_depth(item.getList(), depth + 1))
        return max_depth
    
    def calc_weight_sum(self, nested_list, depth, max_depth):
        total = 0
        for item in nested_list:
            if item.isInteger():
                weight = max_depth - depth + 1
                total += weight * item.getInteger()
            else:
                total += self.calc_weight_sum(item.getList(), depth + 1, max_depth)
        return total
