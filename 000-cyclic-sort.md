# Cyclic Sort
1. [268. Missing Number](https://leetcode.com/problems/missing-number)  
   The idea is to place an element at the right position
   
   Use for loop
   <details>

      ```python
      def missingNumber(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            rightPos = nums[i]
            while rightPos < len(nums) and nums[rightPos] != nums[i]:
                nums[i], nums[rightPos] = nums[rightPos], nums[i]
                rightPos = nums[i]

        for i in range(len(nums)):
            if nums[i] != i:
                return i
        
        return len(nums)    
      ```
   </details>

   Use while loop
   <details>

      ```python
       def missingNumber(self, nums: List[int]) -> int:
           i = 0
           while i < len(nums):
               rightPos = nums[i]
               if rightPos < len(nums) and nums[rightPos] != nums[i]:
                   nums[i], nums[rightPos] = nums[rightPos], nums[i]
               else:
                   i += 1
           
           for i in range(len(nums)):
               if i != nums[i]:
                   return i
           
           return len(nums) 
      ```
   </details>

1. [41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)  
   The idea is to place an element at the right position nums[i] - 1, and then if i != nums[i] - 1, i + 1 is missing, and in the end return len(nums) + 1

   TC O(N), SC O(1)
   
   Use for loop
   <details>

      ```python
       def firstMissingPositive(self, nums: List[int]) -> int:
           i = 0
           while i < len(nums):
               rightPos = nums[i] - 1
               if 0 <= rightPos < len(nums) and nums[rightPos] != nums[i]:
                   nums[i], nums[rightPos] = nums[rightPos], nums[i]
               else:
                   i += 1
           
           for i in range(len(nums)):
               if i != nums[i] - 1:
                   return i + 1
           
           return len(nums) + 1  
      ```
   </details>

