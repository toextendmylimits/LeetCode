class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        traverse(root, targetSum, result, path);
        
        return result;
    }
    
    /*private void traverse(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if(root == null) { return; }

        path.add(root.val);
        
        if(root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));
        }  
                         
        traverse(root.left, targetSum - root.val, result, path); 
        traverse(root.right, targetSum - root.val, result, path);
        
        path.remove(path.size() - 1);
    }*/
    private void traverse(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if(root == null) { return; }

        path.add(root.val);
        
        if(root.left == null && root.right == null && root.val == targetSum) {
            result.add(new ArrayList<>(path));
            return;
        }  
           
        if(root.left !=  null) {
            traverse(root.left, targetSum - root.val, result, path); 
            path.remove(path.size() - 1);
        }
        
        if(root.right != null) {
           traverse(root.right, targetSum - root.val, result, path); 
            path.remove(path.size() - 1);
        }       
    }    
}
