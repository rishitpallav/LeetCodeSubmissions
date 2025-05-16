class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode() {}

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    HashMap<Integer, ListNode> cache = new HashMap<>();
    ListNode mostRecent = new ListNode(-1,-1);
    ListNode leastRecent = new ListNode(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mostRecent.next = leastRecent;
        leastRecent.next = mostRecent;
    }

    public void addNode(ListNode newNode) {
        ListNode temp = mostRecent.next;
        
        newNode.next = temp;
        newNode.prev = mostRecent;
        
        mostRecent.next = newNode;
        temp.prev = newNode;
    }

    public void deleteNode(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {

            ListNode resNode = cache.get(key);
            int result = resNode.value;

            cache.remove(key);
            deleteNode(resNode);
            addNode(resNode);

            cache.put(key, mostRecent.next);

            return result;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode current = cache.get(key);
            cache.remove(key);
            deleteNode(current);
        }

        if (cache.size() == capacity) {
            cache.remove(leastRecent.prev.key);
            deleteNode(leastRecent.prev);
        }

        addNode(new ListNode(key, value));
        cache.put(key, mostRecent.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */