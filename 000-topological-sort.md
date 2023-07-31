# Topological Sort
1. [207. Course Schedule](https://leetcode.com/problems/course-schedule)  
    <details>

      ```python
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree = [0] * numCourses
        adj = [[] for _ in range(numCourses)]
        for curr, pre in prerequisites:
            adj[pre].append(curr)
            indegree[curr] += 1
        
        queue = deque()
        visited = 0
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        while queue:
            node = queue.popleft()
            visited += 1

            for neighbour in adj[node]:
                indegree[neighbour] -= 1
                if indegree[neighbour] == 0:
                    queue.append(neighbour)
        
        return visited == numCourses      
      ```
    </details>

1. [210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii)  
    <details>

      ```python
        def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
            indegree = [0] * numCourses
            adj = [[] for _ in range(numCourses)]
            for curr, pre in prerequisites:
                adj[pre].append(curr)
                indegree[curr] += 1
    
            queue = deque()
            for i in range(len(indegree)):
                if indegree[i] == 0:
                    queue.append(i)
    
            result = []
            while queue:
                node = queue.popleft()
                result.append(node)
    
                for neighbour in adj[node]:
                    indegree[neighbour] -= 1
                    if indegree[neighbour] == 0:
                        queue.append(neighbour)
    
            return result if len(result) == numCourses else []  
      ```
    </details>
