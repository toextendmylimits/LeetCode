# Topological Sort
1. [207. Course Schedule](https://leetcode.com/problems/course-schedule)  
    Time compexlity O(V+E)  
    Space complexity O(V+E) O(V) for queue, O(E) for building the initial graph
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
1. [1136. Parallel Courses](https://leetcode.com/problems/parallel-courses)  
1. [269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary)  
    The key is to find lexical order of two letters. This can be done by comparing letters two adjacent words, if for same postion, there is a mismatch, then the lexical order is determined for these two letters.  
    Beware the edge case that a words contains its next, then should return immediately such as "abc" "ab"
     
    ***Time Complexity***: Let N be the total number of strings in the input list, C be the total length of all the words in the input list, added together, and U be the total number of unique letters in the alien alphabet.  
Time is spent in identifying all the relations, putting them into an adjacency list, and then converting it into a valid alphabet ordering.
    O(C) for identifying all the relations, putting them into an adjacency list  
    O(V+E)=O(U+min(U^2,N)) If U^2 < N, then it < O(U+N) < O(C); else U^2 > N, =O(U+N) < O(C)  
    Together it's O(C)  
   ***Space Complexity***: O(V+E)=O(U+min(U^2,N))
    <details>

      ```python
    def alienOrder(self, words: List[str]) -> str:
        # initialize graph
        indegree = Counter()
        adj = {}
        for word in words:
            for ch in word:
                indegree[ch] = 0
                if not ch in adj:
                    adj[ch] = []

        # build graph with dependancy
        for i in range(len(words) - 1):
            currWord = words[i]
            nextWord = words[i + 1]

            for j in range(min(len(currWord), len(nextWord))):
                if currWord[j] != nextWord[j]:
                    adj[currWord[j]].append(nextWord[j])
                    indegree[nextWord[j]] += 1
                    break
                elif j == len(nextWord) - 1 and len(nextWord) < len(currWord):
                    return ""

        queue = deque([c for c in indegree if indegree[c] == 0])

        result = []
        while queue:
            letter = queue.popleft()
            result.append(letter)
            
            for neighbour in adj[letter]:
                indegree[neighbour] -= 1
                if indegree[neighbour] == 0:
                    queue.append(neighbour)

        return "".join(result) if len(result) == len(indegree) else ""
      ```
    </details>
