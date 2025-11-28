We scan the flowerbed from left to right.
Whenever we see a 0, we check its left and right neighbors:

left is empty (or out of bounds), and

right is empty (or out of bounds)

→ we can plant a flower here. Set this position to 1 and reduce n by 1.
If n ever becomes 0, return true.
If we finish scanning and n > 0, return false.

This works in O(N) time and modifies the array in-place.


class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        if n == 0:
            return True
            
        length = len(flowerbed)

        for i in range(length):
            if flowerbed[i] == 0:
                left_empty = (i == 0) or (flowerbed[i - 1] == 0)
                right_empty = (i == length - 1) or (flowerbed[i + 1] == 0)

                if left_empty and right_empty:
                    flowerbed[i] = 1   # plant
                    n -= 1
                    if n == 0:
                        return True

        return n == 0
