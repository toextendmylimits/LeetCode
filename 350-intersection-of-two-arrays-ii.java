class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }    
    /*public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : nums1) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i : nums2) {
            if(countMap.getOrDefault(i, 0) > 0) {
                result.add(i);
                countMap.put(i, countMap.get(i) - 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }*/
}
