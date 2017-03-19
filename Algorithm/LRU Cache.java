/*

Total Accepted: 115973
Total Submissions: 696272
Difficulty: Hard
Contributors: Admin
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
Show Company Tags
Show Tags
Show Similar Problems

*/

public class LRUCache {
    
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            Node prev = null;
            Node next = null;
        }
    }
    
    private Node head = new Node(-1, -1);
    
    private Node tail = new Node(-1, -1);
    
    private Map<Integer, Node> map = new HashMap<>();
    
    private int capacity;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head.next = tail;
        tail.prev = head;
    }
    
    private void moveTail(Node curr){
        
        Node prev = tail.prev;
        tail.prev = curr;
        curr.prev = prev;
        prev.next = curr;
        curr.next = tail; 
     
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node temp = map.get(key);
            
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            
            moveTail(temp);
            
            return temp.value;
        }
        
        
    }
    
    public void put(int key, int value) {
        
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        if(map.size() == capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node node = new Node(key, value);
        
        map.put(key, node);
        moveTail(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
