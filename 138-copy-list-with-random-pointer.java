/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) { return null; }
        
        Node n1 = head;
        Node n2 = null;
        
        // Clone nodes, and insert it after old node
        while(n1 != null) {
            n2 = new Node(n1.val);
            n2.next = n1.next;
            n1.next = n2;
            
            n1 = n2.next;
        }
        
        // Set cloned nodes' random
        n1 = head;
        while(n1 != null) {
            n2 = n1.next;
            if(n1.random != null) {
                n2.random = n1.random.next;
            }
            
            n1 = n2.next;
        }
        
        // Seaparte old nodes and cloned nodes
        n1 = head;
        Node result = n1.next;
        while(n1 != null) {
            n2 = n1.next;
            n1.next = n2.next;
            if(n2.next != null) {
                n2.next = n2.next.next;
            }
            
            n1 = n1.next;
        }
        
        return result;
    }
    
    /*public Node copyRandomList(Node head) {
        // Map: key is old Node, value is new cloned Node
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        
        // Clone nodes
        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        // Clone edges, i.e. Set cloned nodes's next and random        
        temp = head;
        while(temp != null) {
            Node clonedNode = map.get(temp);
            clonedNode.next = map.get(temp.next);
            clonedNode.random = map.get(temp.random);
            temp = temp.next;
        }
        

        return map.get(head);
    }*/

}
