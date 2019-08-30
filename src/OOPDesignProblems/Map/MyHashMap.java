package OOPDesignProblems.Map;

/**
 * https://leetcode.com/problems/design-hashmap/
 *
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */

class MyHashMap {

    private ListNode[] list;

    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ListNode[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (list[i] == null)
            list[i] = new ListNode(-1, -1);
        ListNode prev = findKey(list[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode head = list[index];
        if(head==null) return -1;
        else{
            ListNode prev = findKey(head, key);
            return prev.next!=null ? prev.next.val : -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(list[index]==null) return;
        else{
            ListNode head = list[index];
            ListNode prev = findKey(head, key);
            if(prev.next!=null) prev.next=prev.next.next;
        }
    }

    //this is required to find element at O(1) cost
    private int getIndex(int key) {
        return key % 10000;
    }

    //if there are multiple elements on same index due to index collision.
    private ListNode findKey(ListNode head, int key){
        ListNode curr = head, prev=null;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr=curr.next;
        }
        return prev;
    }


}

//Why LisNode?? Ans: to handle collision. It's quite common that 2 elements may get the same indexes. In that case, it will added to the liskedlist. While retrieval, you need to find your desired key at the index by traversing the linkedlist.
class ListNode{
    int key;
    int val;
    ListNode next;
    public ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }
}

class Main{
    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));           // returns -1 (not found)
        hashMap.put(2, 1);                            // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);                        // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */