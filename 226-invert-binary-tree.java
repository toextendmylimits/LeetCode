class Solution {
    // Pre-order Iteration
    /*public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }  
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if(node.right != null) {
                stack.push(node.right);
            }
            
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        
        return root;
    }*/
    
    // Level traverse
    public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }  
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }    
    
    // Pre-order
    /*public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }  
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }*/
    
    // In-order
    /*public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }  
        
        TreeNode left = invertTree(root.left);
        
        TreeNode right = root.right;        
        root.right = left;
        root.left = right;
        
        invertTree(root.left);
              
        return root;
    }*/   
    
    // Post-order
    /*public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }  
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        
        return root;
    } */    
}
