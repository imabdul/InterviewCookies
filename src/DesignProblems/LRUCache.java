/*

Nice Explanation --> https://www.youtube.com/watch?v=S6IfqDXWa10

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 //capacity // );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */


package DesignProblems;


import java.util.HashMap;

public class LRUCache {
    private class DNode{
        int key;
        int value;
        DNode next, prev;

        public DNode(){};
        public DNode(int key, int value){
            this.key=key;
            this.value=value;
        };

    }

    HashMap<Integer, DNode> map = new HashMap<>();
    private int totalItemsInCache=0;
    private int capacity=0;
    private DNode head, tail;


    public LRUCache(int capacity){
        this.capacity=capacity;

        head=new DNode();
        tail=new DNode();

        head.prev=null;
        tail.next=null;

        head.next=tail;
        tail.prev=head;

    }

    private void addNode(DNode node){
        node.next=head.next;
        node.prev=head;
        head.next.prev= node;
        head.next=node;
    }

    private void removeNode(DNode node){
        DNode refNextNode=node.next;
        DNode refPrevNode=node.prev;

        //rewiring
        refPrevNode.next=refNextNode;
        refNextNode.prev=refPrevNode;

    }

    private void moveToHead(DNode node){
        removeNode(node);
        addNode(node);
    }

    private void removeLRUEntryFromStructure(){
        DNode tail = popTail();
        map.remove(tail.key);
        --totalItemsInCache;

    }

    private DNode popTail(){
        DNode itemBeingRemoved = tail.prev;
        removeNode(tail.prev);
        return itemBeingRemoved;
    }



    public int get(int key){
        if(map.containsKey(key)){
            DNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){


        if(map.containsKey(key)){
            DNode node = map.get(key);
            node.value=value;
            moveToHead(node);
        }
        else {
            DNode node = new DNode(key, value);
            addNode(node);
            map.put(key, node);
            totalItemsInCache++;

            if(totalItemsInCache>capacity) removeLRUEntryFromStructure();
        }


    }


    public static void main(String[] Args){
        LRUCache cache = new LRUCache( 2);
        cache.put(0,2);
        cache.put(1,5);
        cache.put(0,3);
        cache.put(2,0);
        cache.put(3,2);
        int param = cache.get(0);
        System.out.println(param);


    }
}
