# Stack
1. [394. Decode String](https://leetcode.com/problems/decode-string/)  
    <details>
      
      ```python
    def decodeString(self, s: str) -> str:
        num_stack = []
        str_stack = []
        num = 0
        result = ""
        for c in s:
            if c.isdigit():
                num = num * 10 + int(c)
            elif c == "[":
                num_stack.append(num)
                num = 0
                str_stack.append(result)
                result = ""
            elif c == "]":
                result = str_stack.pop() + result * num_stack.pop()
            else:
                result += c
        return result
      ```
    </details>  
1. [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum)  
   Key observation:
   1. If a number is greater than all its previous numbers, once this number is in the sliding window, then all previous numbers can never be max number and hence can be safely ignored
   1. When a new number is add to a sliding window's left, then the number on the left should be discarded

   The idea is use a deque which maintains index of potential max number, and these numbers are in decreasing order, and the max number's index is always at the front of the queue. Linear scan the numbers,
   1. If queue is not empty then remove all elements that are less than or equal to the number
   1. Add the number's index to the stack
   1. If front of the queue is outside of the scope of the current sliding window, remove it
   1. If the window has k elements, i.e. index is greater or equal to k - 1, then add front of queue to the result
    <details>
      
      ```python
       def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
           result = []
           queue = deque()
           for i in range(len(nums)):
               while queue and nums[queue[-1]] <= nums[i]:
                   queue.pop()         
               queue.append(i)
   
               if queue[0] == i - k:
                   queue.popleft()
               if i >= k - 1:
                   result.append(nums[queue[0]])
           return result
      ```
    </details>   
1. [636. Exclusive Time of Functions](https://leetcode.com/problems/exclusive-time-of-functions)  
   Key observation:
   1. The goal is to get each fucntion's total execution time, which is the sum of multiple execution of portion of the function.  
   1. Each log entry has functionId, action whether it's start or end, and the time. 
   1. If a function starts execution, the time interval between current time and previous time is part of the execution time for previous function  
   1. If a function ends execution, the time interval between current time and previous time is part of the execution time for previous function

   The idea is use a stack to store ids of function that to execute and depends on the action start/end, update execution time for each function. 
   1. Liner scan the logs,
   1. if a function starts execution, if stack is not null, update execution time of the most recent function in the call stack, by adding the time interval between previous time and current time. Then update previous time.  
   1. Else if a function ends execution, the most recent function in the call stack should be the same function, update its execution time by adding the time interval (curr time  - prev time + 1). Then update previous time  
    <details>
      
      ```python
       def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
           stack = []
           prevTime = 0
           result = [0] * n
           for log in logs:
               parts = log.split(":")
               funcId = int(parts[0])
               action = parts[1]
               time = int(parts[2])
               if action == "start":
                   if stack:
                       result[stack[-1]] += time - prevTime
                   stack.append(funcId)
                   prevTime = time
               elif action == "end":
                   result[stack.pop()] += time - prevTime + 1
                   prevTime = time + 1
           
           return result
      ```
    </details>   
1. [71. Simplify Path](https://leetcode.com/problems/simplify-path)  
   When encountering .., it need to go to upper level, which would be similar to pop operatio in a stack, so the idea is to use a stack.  TC O(N) SC O(N)
    <details>
      
      ```python
       def simplifyPath(self, path: str) -> str:
           stack = []
           for part in path.split("/"):
               if part == "..":
                   if stack:
                       stack.pop()
               elif part and part != ".":
                   stack.append(part)
   
           return "/" + "/".join(stack)
      ```
    </details>
    
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
1.[921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid) 
1. [1249. Minimum Remove to Make Valid Parentheses](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)  
   Have a hash set for indexes to be removed. Use a stack for index of valid brackets.   
   1. If chracter is left bracket, push index into stack  
   1. Else if character is right bracket, if stack is not empty(then it must be index for left bracket), pop otherwise push index to indexes to remove as this means more right brackets 
   1. After the loop, check whether there is any element in stack, then it means the indexes for left brackets, and add them to seet
   1. In the end, find a sub sequence not including the ones which index are in the set for indexes to be removed
    <details>
      
      ```python
       def minRemoveToMakeValid(self, s: str) -> str:
           indexesToRemove = set()
           stack = []
           for i, c in enumerate(s):
               if c == "(":
                   stack.append(i)
               elif c == ")":
                   if stack:
                       stack.pop()
                   else:
                       indexesToRemove.add(i)
           
           while stack:
               indexesToRemove.add(stack.pop())
           
           validChars = []
           for i, c in enumerate(s):
               if not i in indexesToRemove:
                   validChars.append(c)
   
           return "".join(validChars)       
      ```
    </details>

1. [227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii)   
   Key observations:  
   1. If the current operation is addition (+) or subtraction (-), then the expression is evaluated based on the precedence of the next operation.
   1. If the current operator is multiplication (*) or division (/), then the expression is evaluated irrespective of the next operation. This is because in the given set of operations (+,-,*,/), the * and / operations have the highest precedence and therefore must be evaluated first.

   Agorithm:
   Scan the input string s from left to right and evaluate the expressions based on the following rules
   1. If the current character is a digit 0-9 ( operand ), add it to the number currentNumber.  
   1. Otherwise, the current character must be an operation (+,-,*, /). Evaluate the expression based on the type of operation.  
      1. Addition (+) or Subtraction (-): We must evaluate the expression later based on the next operation. So, we must store the currentNumber to be used later. Let's push the currentNumber in the Stack.  
      1. Multiplication (*) or Division (/): Pop the top values from the stack and evaluate the current expression. Push the evaluated value back to the stack.  
   1. Once the string is scanned, pop from the stack and add to the result.  

   Alternative approach:  
   Intuition:  
   In the previous approach, we used a stack to track the values of the evaluated expressions. In the end, we pop all the values from the stack and add to the result. Instead of that, we could add the values to the result beforehand and keep track of the last calculated number, thus eliminating the need for the stack. Let's understand the algorithm in detail.

   Algorithm

   The approach works similar to Approach 1 with the following differences :  
   1. Instead of using a stack, we use a variable lastNumber to track the value of the last evaluated expression.  
   1. If the operation is Addition (+) or Subtraction (-), add the lastNumber to the result instead of pushing it to the stack. The currentNumber would be updated to lastNumber for the next iteration.  
   1. If the operation is Multiplication (*) or Division (/), we must evaluate the expression lastNumber * currentNumber and update the lastNumber with the result of the expression. This would be added to the result after the entire string is scanned.  
   <details>
      
      ```python
       def calculate(self, s: str) -> int:
           currNum = 0
           stack = []
           operator = "+"
           for i, c in enumerate(s):
               if c.isdigit():
                   currNum = currNum * 10 + int(c)
   
               if (not c.isdigit() and not c.isspace()) or i == len(s) - 1:
                   if operator == "+":
                       stack.append(currNum)
                   elif operator == "-":
                       stack.append(-currNum)
                   elif operator == "*":
                       stack.append(stack.pop() * currNum)
                   elif operator == "/":
                       stack.append(int(stack.pop() / currNum))
   
                   operator = c
                   currNum = 0
                   
           total = 0
           while stack:
               total += stack.pop()
           
           return total

      # Without using stack
       def calculate(self, s: str) -> int:
           result = 0
           currNum = 0
           lastNum = 0
           operator = "+"
           for i, c in enumerate(s):
               print(result, lastNum, currNum, i)
               if c.isdigit():
                   currNum = currNum * 10 + int(c)
               
               if (not c.isdigit() and not c.isspace()) or i == len(s) - 1:
                   if operator in "+-":
                       result += lastNum
                       lastNum = currNum if operator == "+" else -currNum
                   elif operator == "*":
                       lastNum = lastNum * currNum
                   elif operator == "/":
                       lastNum = int(lastNum / currNum)
                   operator = c
                   currNum = 0
           result += lastNum
           return result      
      ```
   </details>
    
1. [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation)  
   If token is operator, pop two elements froms tack, and calculate result, then push result back to stack. If it's not operator, just push to stack. 
  
   ***Beware for divide operation, use int(operand1 / operand2) instead of operand1 // operand2 as python's divide with negative number is very different, also before appending letters to stack, convert to int first***

   ***Time complexity, space complexity both are O(N)***  
   We do a linear search to put all numbers on the stack, and process all operators. Processing an operator requires removing 2 numbers off the stack and replacing them with a single number, which is an O(1) operation. Therefore, the total cost is proportional to the length of the input array.

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
           self.minStack = []
           self.stack = []
   
       def push(self, val: int) -> None:
           self.stack.append(val)
           if not self.minStack or val <= self.getMin():
               self.minStack.append(val)
           
       def pop(self) -> None:
           if self.stack.pop() == self.getMin():
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
1. [2034. Stock Price Fluctuation](https://leetcode.com/problems/stock-price-fluctuation)  

# Queue
1.[225. Implement Stack using Queues](https://leetcode.com/problems/implement-queue-using-stacks)  

