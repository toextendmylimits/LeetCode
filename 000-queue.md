# Queue
## TO re-visit later
1. [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues)  
    <details>

      ```python
      def push(self, x: int) -> None:
          if not self.mainQueue:
              self.mainQueue.append(x)
              return
  
          while self.mainQueue:
              self.auxQueue.append(self.mainQueue.popleft())
          self.mainQueue.append(x)
          while self.auxQueue:
              self.mainQueue.append(self.auxQueue.popleft())
      ```

     Can also be done using only one queue:
      ```python
      def push(self, x: int) -> None:
          size = len(self.mainQueue)
          self.mainQueue.append(x)
          for _ in range(size):
              self.mainQueue.append(self.mainQueue.popleft())
      ```
    </details>
