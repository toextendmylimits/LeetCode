# Bitwise operations
1. [136. Single Number](https://leetcode.com/problems/single-number)  
    Use bitwise exclusive OR(Results bit 1,if any of the operand bit is 1 but not both, otherwise results bit 0.)
    <details>

      ```python
      def singleNumber(self, nums: List[int]) -> int:
          result = 0
          for n in nums:
              result ^= n
          return result      
      ```
    </details>
