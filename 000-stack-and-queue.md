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
   ***Beware for divide operation, use int(operand1 / operand2) instead of operand1 // operand2 as python's divide with negative number is very different, also before appending letters to stack, convert to int first***
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
1. [155. Min Stack](https://leetcode.com/problems/min-stack)  
   Keep two stacks, one stack to keep all values, the other to keep minimum values
    <details>
      
      ```python
       def __init__(self):
           self.stack = []
           self.minStack = []
   
       def push(self, val: int) -> None:
           self.stack.append(val)
           if not self.minStack or val <= self.minStack[-1]:
               self.minStack.append(val)
           
       def pop(self) -> None:
           if self.stack.pop() <= self.minStack[-1]:
               self.minStack.pop()
   
       def top(self) -> int:
           return self.stack[-1]
   
       def getMin(self) -> int:
           return self.minStack[-1]
      ```
    </details>
1. [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)  
   Thinking process:
   Imagine there is queue 1, 2, 3, Then in stack from bottom to top, it would be 3, 2, 1   
   Now if 4 is added, the expected stack would be 4, 3, 2, 1  
   So if revese it, it would be 1, 2, 3, 4 which is popping stack 3, 2, 1 and then pushing 4  
   So the idea is to pop 3, 2, 1 to a auxiliary stack to get 1, 2, 3, then add 4, to get 1, 2, 3, 4 then pop to get 4, 3, 2, 1 

   Maintain two stacks, main stack has the earliest element on top, auxiliary stack is empty 
   When a new element is pushed to the queue,
   1. If main stack is empty, simply push that element into stack
   1. Otherwise if main stack is not empty, move all the elments to auxiliary stack, and push the element to main stack, then move the elements from auxiliary stack to main stack  
   ***For push operation, time complexity is O(N), and space complexity is also O(N)***
    <details>
      
      ```python
       def __init__(self):
           self.mainStack = []
           self.auxStack = []
           
   
       def push(self, x: int) -> None:
           if not self.mainStack:
               self.mainStack.append(x)
           else:
               while self.mainStack:
                   self.auxStack.append(self.mainStack.pop())
               self.mainStack.append(x)
               while self.auxStack:
                   self.mainStack.append(self.auxStack.pop())
       def pop(self) -> int:
           return self.mainStack.pop()
   
       def peek(self) -> int:
           return self.mainStack[-1]
           
   
       def empty(self) -> bool:
           return not self.mainStack
      ```
    </details>
## TO re-visit later
1. [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)  
1. [155. Min Stack](https://leetcode.com/problems/min-stack)  

# Queue
1.[225. Implement Stack using Queues](https://leetcode.com/problems/implement-queue-using-stacks)  
