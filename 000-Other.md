# These don't fall into any category
1. [169. Majority Element](https://leetcode.com/problems/majority-element)  
1. [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)  
    <details>
      
    ```python
    def maxSubArray(self, nums: List[int]) -> int:
        currSum = nums[0] # represent the largest sum of subarray ending index i
        result = currSum

        for i in range(1, len(nums)):
            currSum = max(nums[i], currSum + nums[i])
            result = max(currSum, result)
        
        return result
      
    ```
    </details>
1. [384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array)  
    The idea is to pick a random card from all cards, and then swap this card with first card  
    Then pick a random card from remaining cards, and then swap this card with second card
   ***User random.randint or random.randrange(end exclusive) to generate random number***  
    <details>

        ```python
        def shuffle(self) -> List[int]:
            for i in range(len(self.currNums)):
                randIdx = random.randint(i, len(self.currNums) - 1)
                self.currNums[i], self.currNums[randIdx] = self.currNums[randIdx], self.currNums[i]
            
            return self.currNums
        ```
    </details>
1. [118. Pascal's Triangle](https://leetcode.com/problems/pascals-triangle)  
    row in range 1 and numRows(exclusive)  
    col in range 1 and row(exclusive)  
    ***Time complexity is O(N^2) while space complexity is O(1)***    
    <details>

        ```python
        def generate(self, numRows: int) -> List[List[int]]:
            result = []
            result.append([1])
            if numRows == 1:
                return result
            
            for row in range(1, numRows):
                level = []
                level.append(1) # First
    
                for col in range(1, row):
                    prevLevel = result[-1]
                    level.append(prevLevel[col - 1] + prevLevel[col])
                
                level.append(1) # Last
                result.append(level)
            
            return result
        ```
    </details>
