
I use binary search to find the rotation point. If the current window is already sorted, 
the leftmost value is the minimum. Otherwise I check whether the left half is sorted: 
if nums[mid] >= nums[left], then the left side is sorted and the minimum must be in the right half; 
otherwise the right side is sorted and the rotation point is in the left half. 
I update the minimum along the way and keep searching in O(log n).

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        minimum_value = nums[0]

        while left <= right:
            # If current segment is sorted, leftmost is the min
            if nums[left] < nums[right]:
                minimum_value = min(minimum_value, nums[left])
                break

            mid = left + (right - left) // 2
            minimum_value = min(minimum_value, nums[mid])

            # Left half is sorted → minimum must be on the right side
            if nums[mid] >= nums[left]:
                left = mid + 1
            else:
                # Right half is sorted → minimum must be on the left side
                right = mid - 1

        return minimum_value
