from typing import List # Only need because method signature used List, not needed in real job interview
from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        nextCourses = defaultdict(list)
        dependCoursesCount = [0] * numCourses
        for currCourse, prevCourse in prerequisites:
            nextCourses[prevCourse].append(currCourse)
            dependCoursesCount[currCourse] += 1
        
        queue = deque([i for i in range(len(dependCoursesCount)) if dependCoursesCount[i] == 0])
        coursesTaken = 0
        while queue:
            courseToTake = queue.popleft()
            coursesTaken += 1

            for nextCourse in nextCourses[courseToTake]:
                dependCoursesCount[nextCourse] -= 1
                if dependCoursesCount[nextCourse] == 0:
                    queue.append(nextCourse)
        
        return coursesTaken == numCourses
solution = Solution()
print(solution.canFinish(2,[[1,0]]))
