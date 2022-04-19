class Solution {
    public int[] sumZero(int n) {
        int half = n / 2;
        int[] result = new int[n];
        for(int i = 0; i <= half - 1; i++) {
            int iPlusOne = i + 1;
            result[i] = iPlusOne;
            result[n - 1 - i] = -iPlusOne;
        }
        
        if(n % 2 == 1) {
            result[half] = 0;
        }
        
        return result;
    }
}
