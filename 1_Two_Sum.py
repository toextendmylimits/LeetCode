I scan the array once while storing each number's index in a hash map.
For each number, I compute its complement (target - value).
If the complement already exists in the map, I return the two indices immediately.
This gives O(n) time and O(n) space.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        value_to_index = {}

        for index, value in enumerate(nums):
            complement = target - value
            if complement in value_to_index:
                return [value_to_index[complement], index]

            value_to_index[value] = index
        
        return [-1, -1]
