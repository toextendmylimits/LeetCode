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
    <details>

        ```python
        def shuffle(self) -> List[int]:
            for i in range(len(self.currNums)):
                randIdx = random.randint(i, len(self.currNums) - 1)
                self.currNums[i], self.currNums[randIdx] = self.currNums[randIdx], self.currNums[i]
            
            return self.currNums
        ```
    </details>
