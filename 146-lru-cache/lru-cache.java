class LRUCache {
    Map<Integer, Node> map;

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    private final int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    void deleteNode(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    void insertAfterHead(Node temp) {
        Node headAfterNode = head.next;
        temp.next = headAfterNode;
        headAfterNode.prev = temp;
        head.next = temp;
        temp.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node data = map.get(key);
        deleteNode(data);
        insertAfterHead(data);
        return data.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }
        if (map.size() == capacity) {
            Node node = tail.prev;
            map.remove(node.key);
            deleteNode(node);
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAfterHead(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */