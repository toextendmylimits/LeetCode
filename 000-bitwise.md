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
1. [268. Missing Number](https://leetcode.com/problems/missing-number)  
   t***Approach 1*** check i from 0 to n(inclusive), whether it's in the distinct numbers(using set)
    <details>

        ```python
          def missingNumber(self, nums: List[int]) -> int:
            distinctNums = set(nums)
            for i in range(len(nums) + 1):
                if i not in distinctNums:
                    return i      
        ```
    </details>
