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
   ***Approach 1*** check i from 0 to n(inclusive), whether it's in the distinct numbers(using set)
    <details>

      ```python
        def missingNumber(self, nums: List[int]) -> int:
            distinctNums = set(nums)
            for i in range(len(nums) + 1):
                if i not in distinctNums:
                    return i         
      ```
    </details>
    
   ***Approach 2*** bitwise exclusive OR  
    <details>

      ```python
        def missingNumber(self, nums: List[int]) -> int:
            result = len(nums)
            for i, n in enumerate(nums):
                result ^= i ^ n
            
            return result        
      ```
    </details>
1. [190. Reverse Bits](https://leetcode.com/problems/reverse-bits)  
   ***Approach 1*** Use multiply, divide and modulo
    <details>

      ```python
        def reverseBits(self, n: int) -> int:
            result = 0
            for _ in range(32):
                result = result * 2 + n % 2
                n //= 2
            
            return result         
      ```
    </details>
    
   ***Approach 2*** Convert above to bitwise operations: left shift equal to multiply, right shift equal to divide, & 1 equal to modulo 2
    <details>

      ```python
        def reverseBits(self, n: int) -> int:
            result = 0
            for _ in range(32):
                result = (result << 1) + (n & 1)
                n >>= 1
            
            return result      
      ```
    </details>

1. [191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits)  
   ***Approach 1*** Use multiply, divide and modulo
    <details>

      ```python
        def hammingWeight(self, n: int) -> int:
            result = 0
            while n != 0:
                result += n % 2
                n //= 2
            
            return result        
      ```
    </details>
    
   ***Approach 2*** Convert above to bitwise operations: left shift equal to multiply, right shift equal to divide, & 1 equal to modulo 2, remember to have the bitwise operation in a bracket
    <details>

      ```python
            result = 0
            while n != 0:
                result += (n & 1)
                n >>= 1
            
            return result    
      ```
    </details>
1. [461. Hamming Distance](https://leetcode.com/problems/hamming-distance)  
    Bitwise exclusive OR outputs 1 if and only if the input bits are different. So we can first do x XOR y operation, then we simply count the number of bit 1 in the result of XOR operation.  
    Use & 1 to get rightmost bit  
    <details>

      ```python
        def hammingDistance(self, x: int, y: int) -> int:
            xOry = x ^ y
            count = 0
            while xOry != 0:
                if xOry & 1:
                    count += 1
                xOry >>= 1
            return count  
      ```
    </details> 
