class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] squares = new int[nums.length];
        for(int i = squares.length - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare > rightSquare) {
                squares[i] = leftSquare;
                left++;
            }
            else {
                squares[i] = rightSquare;
                right--;
            }
        }
        
        return squares;
    }
}
