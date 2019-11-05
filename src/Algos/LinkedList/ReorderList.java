package Algos.LinkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * Idea:
 * • Bisect the list
 * • Reverse the second half
 * • Join the two semi-lists in intertwining fashion with head of first list being the head of the joined list.
*/

import java.util.List;

public class ReorderList {
    public void reorderList(ListNode head) {

        ListNode firstTail = getMid(head);
        if(firstTail == null) return;
        ListNode head2 = reverse(firstTail.next);
        firstTail.next = null;
        ListNode h1 = head, h2= head2;

        while(h2!=null){
            ListNode next1=h1.next;
            ListNode next2=h2.next;

            h1.next=h2;
            h2.next=next1;
            h1=next1;
            h2=next2;
        }


    }

    private ListNode getMid(ListNode head){
        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null) { //usually the condition is (fast!=null && fast.next!=null) to get the mid but here we want node before to the mid in order to break it into 2 Lists
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null, next=null, curr=head;
        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;
        }
        return prev;
    }


    public static void main(String[] args){
        ListNode L1 = new ListNode(1);
        L1.next=new ListNode(2);
        L1.next.next=new ListNode(3);
        L1.next.next.next=new ListNode(4);
        ReorderList rl = new ReorderList();
        rl.reorderList(L1);

        ListNode curr1 = L1;
        while(curr1.next!=null){
            System.out.print(curr1.val + "->"); //expected 1->4->2->3
            curr1=curr1.next;
        }
        System.out.print(curr1.val);

        System.out.println(" ");
        ListNode L2 = new ListNode(1);
        L2.next=new ListNode(2);
        L2.next.next=new ListNode(3);
        L2.next.next.next=new ListNode(4);
        L2.next.next.next.next=new ListNode(5);
        rl.reorderList(L2);

        ListNode curr2 = L2;
        while(curr2.next!=null){
            System.out.print(curr2.val + "->"); //expected 1->5->2->4->3
            curr2=curr2.next;
        }
        System.out.print(curr2.val);
    }

}
