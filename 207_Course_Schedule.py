I treat each course as a node and prerequisites as directed edges.
I compute the indegree (number of prerequisites) of each course.
All courses with indegree 0 can be taken immediately — I push them into a queue.
While the queue is not empty, I pop a course, mark it as taken, and reduce the indegree of the courses depending on it.
If a neighbor’s indegree becomes 0, I add it to the queue.
At the end, if I have taken all courses, there’s no cycle. Otherwise a cycle exists.
  
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        indegree = [0] * numCourses

        # Build adjacency list and indegree count
        for course, prereq in prerequisites:
            graph[prereq].append(course)
            indegree[course] += 1

        # Queue starts with all courses that have no prerequisites
        queue = deque([i for i in range(numCourses) if indegree[i] == 0])
        taken = 0

        while queue:
            curr = queue.popleft()
            taken += 1

            # Reduce indegree of neighbors
            for next_course in graph[curr]:
                indegree[next_course] -= 1
                # If indegree becomes zero, you can now take it
                if indegree[next_course] == 0:
                    queue.append(next_course)

        # If we were able to "take" all courses → no cycle
        return taken == numCourses
