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
