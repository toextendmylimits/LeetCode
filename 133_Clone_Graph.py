# Approach 1: DFS
I use DFS with a hashmap to clone the graph.
Since graphs may have cycles, I keep a dictionary mapping each original node to its clone.
In DFS, when I visit a node:

If it’s already in the map, I return the existing clone.

Otherwise, I create a new node, store it in the map, and recursively clone all its neighbors.
This guarantees each node is cloned once and prevents infinite loops.
Finally, I return the clone of the input node.

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        old_to_new = {}

        def dfs(curr):
            if curr in old_to_new:
                return old_to_new[curr]

            copy = Node(curr.val)
            old_to_new[curr] = copy

            for nei in curr.neighbors:
                copy.neighbors.append(dfs(nei))
            
            return copy
        
        return dfs(node)

# Approach 2: BFS

I use BFS along with a hashmap to clone the graph.
First, I create a clone of the starting node and store the mapping from the original to the clone.
Then I run BFS starting from the input node.
For each node we pop from the queue, we visit its neighbors.
If a neighbor hasn't been cloned yet, we create a clone, store it in the map, and push the original neighbor into the queue.
Whether newly created or already cloned, we append the clone of the neighbor to the clone of the current node.
When BFS finishes, every node and edge has been duplicated exactly once.

from collections import deque

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        old_to_new = {node: Node(node.val)}
        queue = deque([node])

        while queue:
            curr = queue.popleft()

            for nei in curr.neighbors:
                if nei not in old_to_new:
                    old_to_new[nei] = Node(nei.val)
                    queue.append(nei)
                
                old_to_new[curr].neighbors.append(old_to_new[nei])
        
        return old_to_new[node]


