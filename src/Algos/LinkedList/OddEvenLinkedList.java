/*
LeetCode Medium Problem (Odd Even Linked List)
----------------------------------------------
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...

 */


/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */

package Algos.LinkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head){
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;  //this would be required later to be added to the tail of odd list.
        while (even!=null && even.next!=null ){
            odd.next= odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] Args){
        ListNode head1 = new ListNode(1);
        head1.next= new ListNode(2);
        head1.next.next=new ListNode(3);
        head1.next.next.next=new ListNode(4);
        head1.next.next.next.next=new ListNode(5);
        OddEvenLinkedList oe = new OddEvenLinkedList();
        ListNode test = oe.oddEvenList(head1);
        System.out.print(test.val + " ");
        System.out.print(test.next.val + " ");
        System.out.print(test.next.next.val + " ");
        System.out.print(test.next.next.next.val + " ");
        System.out.print(test.next.next.next.next.val + " ");
    }
}
