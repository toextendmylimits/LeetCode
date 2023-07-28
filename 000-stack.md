# Stack
1. [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses)  
   Time complexity O(N) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.  
   Space complexity O(N) as we push all opening brackets onto the stack in the worst case
    <details>
      
      ```python
      def isValid(self, s: str) -> bool:
          closeOpenMap = { ")" : "(", "}" : "{", "]" : "["}
          stack = []
          for ch in s:
              if ch in closeOpenMap:
                  if not stack or stack[-1] != closeOpenMap[ch]:
                      return False
                  else:
                      stack.pop()
              else:
                  stack.append(ch)
          return not stack
      ```
    </details>

## TO re-visit later
1. [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)  

