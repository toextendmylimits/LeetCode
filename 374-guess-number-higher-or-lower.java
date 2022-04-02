/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            int guessValue = guess(pivot);
            if(guessValue > 0 ) {
                left = pivot + 1;
            }
            else if(guessValue < 0) {
                right = pivot - 1;
            }
            else {
                return pivot;
            }
        }
        
        return -1;
    }
}
