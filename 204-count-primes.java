class Solution {
    // Time complexity: O(nlog(logn))
    public int countPrimes(int n) {
        int count = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            if(notPrime[i] == false) {
                count++;
                for(int j = i * 2; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        
        return count;
    }
    
    // Time: O(n sqrt(n))
    /*public int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    public boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }*/
}
