class Solution {
    public Node connect(Node root) {
        if(root == null) { return null; }   
        
        Node leftMost = root;
        while(leftMost.left != null) {
            Node head = leftMost;
            
            while(head != null) {
                head.left.next = head.right;
                
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                
                head = head.next;
            }
            
            leftMost = leftMost.left;
        }
        
        return root;
    }
    
    /*public Node connect(Node root) {
        if(root == null) { return null; }   
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
  
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                
                if(i < size - 1) {
                    node.next = queue.peek();
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }*/
    
    /*public Node connect(Node root) {
        if(root == null) { return null; }   
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node current = queue.poll();
                current.next = prev;
                prev = current;
                
                if(current.right != null) {
                    queue.offer(current.right);
                }
                if(current.left != null) {
                    queue.offer(current.left);
                }
            }
        }
        
        return root;
    }*/
}
