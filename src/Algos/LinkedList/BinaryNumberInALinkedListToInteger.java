package Algos.LinkedList;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */

public class BinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        ListNode currentNode = head;
        ListNode currentNode1 = head;
        int decimalVal=0;
        int len=0;
        while(currentNode!=null){
            len++;
            currentNode=currentNode.next;
        }
        for(int i=len; i>0; i--){
            decimalVal += currentNode1.val*Math.pow(2,i-1);
            currentNode1=currentNode1.next;
        }
        return decimalVal;

    }

    public static void main(String [] Args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(0);
        L1.next.next = new ListNode(1);

        ListNode L2 = new ListNode(0);
        ListNode L3 = new ListNode(1);


        BinaryNumberInALinkedListToInteger bti = new BinaryNumberInALinkedListToInteger();
        System.out.println(bti.getDecimalValue(L1)); // ans --> (101)base2 ---> (5)base10
        System.out.println(bti.getDecimalValue(L2)); // ans (0)base2 --- > (0)base10
        System.out.println(bti.getDecimalValue(L3)); // ans (1)base2 --- > (1)base10
    }
}
