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
