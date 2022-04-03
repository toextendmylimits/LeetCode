class Solution {
  public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
      
        // Flip negtaive numbers up to k times
        for (int i = 0; K > 0 && i < A.length && A[i] < 0; i++, K--) {
            A[i] = -A[i];          
        }

        if(K == 0) {
            return Arrays.stream(A).sum();
        }
      
        // All negative numbers have been flipped
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            result += a;
            min = Math.min(min, a);
        }
        return result - (K % 2) * min * 2;
    }
}
