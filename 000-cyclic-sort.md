# Cyclic Sort
1. [268. Missing Number](https://leetcode.com/problems/missing-number)  
   The idea is to place an element at the right position
   
   Use for loop
   <details>

      ```python
      def missingNumber(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            rightPos = nums[i]
            while rightPos < len(nums) and rightPos != i:
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
               if rightPos < len(nums) and rightPos != i:
                   nums[i], nums[rightPos] = nums[rightPos], nums[i]
               else:
                   i += 1
           
           for i in range(len(nums)):
               if i != nums[i]:
                   return i
           
           return len(nums) 
      ```
   </details>
