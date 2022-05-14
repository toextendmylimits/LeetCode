class Solution {
    int count = 0;
    Map<Integer, Integer> preSumCount = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        inorder(root, targetSum, 0);
            
        return count;
    } 
    
    private void inorder(TreeNode root, int targetSum, int currentSum) {
        if(root == null) { return; }
        
        currentSum += root.val;
        if(currentSum == targetSum) {
            count++;
        }
        
        count += preSumCount.getOrDefault(currentSum - targetSum, 0);
        
        preSumCount.put(currentSum, preSumCount.getOrDefault(currentSum, 0) + 1);
        
        inorder(root.left, targetSum, currentSum);
        inorder(root.right, targetSum, currentSum);
        
        preSumCount.put(currentSum, preSumCount.get(currentSum) - 1);
    }
    /*public int pathSum(TreeNode root, int targetSum) {
        if(root == null) { return 0; };
            
        return pathSumFrom(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }*/
    
    private int pathSumFrom(TreeNode root, int targetSum) {
        if(root == null) { return 0; }
        
        int result = 0;
        if(targetSum == root.val) {
            result++;
        }
        
        result += pathSumFrom(root.left, targetSum - root.val);
        result += pathSumFrom(root.right, targetSum - root.val);
        
        return result;
    }
    
    /*private int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
            
        return count;
    }
    
    private void traverse(TreeNode root, int targetSum) {
        if(root == null) { return; }
        
        traverseFrom(root, targetSum);

        traverse(root.left, targetSum);          
        traverse(root.right, targetSum);             
    }
    
    private void traverseFrom(TreeNode root, int targetSum) {
        if(root == null) { return; }
        if(root.val == targetSum) {
            count++;
        }
        
        targetSum -= root.val;

        traverseFrom(root.left, targetSum);           
        traverseFrom(root.right, targetSum);      
    }*/
}
