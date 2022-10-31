class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> numIndexMap;
    Random random;
    public RandomizedSet() {
        nums = new ArrayList<>();
        numIndexMap = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(numIndexMap.containsKey(val)) {
            return false;
        }
        
        numIndexMap.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!numIndexMap.containsKey(val)) {
            return false;
        }
        
        // Overwrite nums's element that equals to target value with last element
        int index = numIndexMap.get(val);
        int lastElement = nums.get(nums.size() - 1);
        nums.set(index, lastElement);    
        numIndexMap.put(lastElement, index);
        
        // Remove last element
        numIndexMap.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
