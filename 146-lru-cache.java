class LRUCache {
    private int capacity;
    private int count;
    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        
        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private void insertAfterNode(DLinkedNode node, DLinkedNode newNode) {
        DLinkedNode next = node.next;
        
        node.next = newNode;
        newNode.next = next;
        
        newNode.prev = node;    
        next.prev = newNode;      
    }
    
    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        insertAfterNode(head, node);
    }
    
    private DLinkedNode removePreviousOfTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        
        return node;
    }
    
    private void intializeHeadTail() {
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        intializeHeadTail();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) { return -1; }
        
        DLinkedNode node = cache.get(key);
        moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }
        else {
            count++;
            
            DLinkedNode createdNode = new DLinkedNode(key, value);
            cache.put(key, createdNode);
            insertAfterNode(head, createdNode);
            
            if(count > capacity) {
                DLinkedNode tail = this.removePreviousOfTail();
                cache.remove(tail.key);
                count--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
