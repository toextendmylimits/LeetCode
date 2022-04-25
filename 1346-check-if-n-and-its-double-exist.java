class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for(int n : arr) {
            if(seen.contains(n * 2) || (n % 2 == 0 && seen.contains(n / 2))) {
                return true;
            }
            seen.add(n);
        }
        
        return false;
    }
}
