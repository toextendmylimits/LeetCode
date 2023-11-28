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
   Key observation is that the first missing number must be from 1 to len(nums) + 1. If from 1 to len, any number is missing, then it is less than len + 1. Or no number is missing from 1 to len, then len + 1 is the missing one.  
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

1. [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)    
   The idea is to place an element at the right position nums[i] - 1, and then if i != nums[i] - 1, nums[i] is duplicate, and in the end return -1

   TC O(N), SC O(1)
   
   Use for loop
   <details>

      ```python
       def findDuplicate(self, nums: List[int]) -> int:
           i = 0
           while i < len(nums):
               rightPos = nums[i] - 1
               if nums[rightPos] != nums[i]:
                   nums[rightPos], nums[i] = nums[i], nums[rightPos]
               else:
                   i += 1
           
           for i in range(len(nums)):
               if i != nums[i] - 1:
                   return nums[i]
           
           return -1

      ```
   </details>

1. [645. Set Mismatch](https://leetcode.com/problems/set-mismatch)      
   The idea is to place an element at the right position nums[i] - 1, and then if i != nums[i] - 1, then duplicate one is nums[i], and missing one is i + 1

   TC O(N), SC O(1)
   
   Use for loop
   <details>

      ```python
       def findErrorNums(self, nums: List[int]) -> List[int]:
           i = 0
           while i < len(nums):
               rightPos = nums[i] - 1
               if nums[rightPos] != nums[i]:
                   nums[rightPos], nums[i] = nums[i], nums[rightPos]
               else: 
                   i += 1
           
           for i in range(len(nums)):
               if i != nums[i] - 1:
                   return [nums[i], i + 1]
                   
           return [-1, -1]
      ```
   </details>

1. [448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array)       
   The idea is to place an element at the right position nums[i] - 1, and then if i != nums[i] - 1, then i + 1 must be missing

   TC O(N), SC O(1)
   
   Use for loop
   <details>

      ```python
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        i = 0
        while i < len(nums):
            rightPos = nums[i] - 1
            if nums[rightPos] != nums[i]:
                nums[rightPos], nums[i] = nums[i], nums[rightPos]
            else:
                i += 1
        result = []
        for i in range(len(nums)):
            if i != nums[i] - 1:
                result.append(i + 1)
        
        return result
      ```
   </details>
   
## To revisit
1. Many other different ways of solving [287. Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number)
