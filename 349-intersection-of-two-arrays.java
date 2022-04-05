class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Get set of nums1
        Set<Integer> set1 = convertToSet(nums1);
        
        // Loop through nums2, find element that exists in set, and return a new set for intersection
        Set<Integer> intersectionSet = getIntersectionSet(nums2, set1);
        
        // Convert set for intersection to an array
        return convertSetToArray(intersectionSet);
    }
    
    private Set<Integer> convertToSet(int[] nums) {
        Set<Integer> result = new HashSet<Integer>();
        for(int n : nums) {
            if(!result.contains(n)) {
                result.add(n);
            }
        }
        
        return result;
    }
    
    private Set<Integer> getIntersectionSet(int[] nums, Set<Integer> set) {
        Set<Integer> result = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) {
                result.add(n);
            }
        }
        
        return result;
    }
    
    private int[] convertSetToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int index = 0;
        for(int element : set) {
            result[index++] = element;
        }
        
        return result;
    }
}
