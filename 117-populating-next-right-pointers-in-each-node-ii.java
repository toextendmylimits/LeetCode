class Solution {
    public Node connect(Node root) {
        if(root == null) { return null; }
        
        Node current = root;
        
        while(current != null) {
            Node dummyHead = new Node(0);
            Node prev = dummyHead;
            while(current != null) {
                if(current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }
                
                if(current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }
                
                current = current.next;
            }
            current = dummyHead.next;
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
}
