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
1. [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation)  
   If token is operator, pop two elements froms tack, and calculate result, then push result back to stack. If it's not operator, just push to stack. 
    <details>
      
      ```python
       def evalRPN(self, tokens: List[str]) -> int:
           stack = []
           operators = "+-*/"
           for token in tokens:
               if token not in operators:
                   stack.append(int(token))
               else:
                   right = int(stack.pop())
                   left = int(stack.pop())
                   result = None
                   if token == "+":
                       result = left + right
                   elif token == "-":
                       result = left - right
                   elif token == "*":
                       result = left * right
                   else:
                       result = int(left / right)
                   stack.append(result)
           return stack.pop()
      ```
    </details>
## TO re-visit later
1. [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)  
1. [155. Min Stack](https://leetcode.com/problems/min-stack)  

