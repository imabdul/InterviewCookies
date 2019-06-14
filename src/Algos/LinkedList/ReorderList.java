package Algos.LinkedList;

/*
Idea:
• Bisect the list
• Reverse the second half
• Join the two semi-lists in intertwining fashion with head of first list being the head of the joined list.
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
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;

            //You want a node before to the mid, so that you can break it and mark it's next to null.
            if (fast.next == null || fast.next.next == null) return slow;
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

        ListNode curr = L1;
        while(curr.next!=null){
            System.out.print(curr.val + "->"); //expected 1->4->2->3
            curr=curr.next;
        }
        System.out.print(curr.val);
    }

}
