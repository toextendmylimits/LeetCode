# Array
1. [66. Plus One](https://leetcode.com/problems/plus-one)  
    Copy existing array to a new one.   
    1. Starting from the last element of the array, add the digit and 1 or carry.   
    1. If total is less than 10, assign the number to result array and return immeditately
    1. If total is equal or greater than 10, assign 0 to the result, and set carry to 1
    1. In the end, if carry is 1, return 1 + [0] * len
    <details>

      ```python
      def plusOne(self, digits: List[int]) -> List[int]:
          carry = 0
          result = digits[:]
          for i in range(len(digits) - 1, -1, -1):
              total = digits[i] + (1 if i == len(digits) - 1 else carry)
              if total < 10:
                  result[i] = total
                  return result
              else:
                  result[i] = 0
                  carry = 1
  
          if carry == 1:
              return [1] + [0] * len(digits)
      ```
    </details>
