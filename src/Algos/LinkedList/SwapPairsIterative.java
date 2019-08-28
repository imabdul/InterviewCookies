package Algos.LinkedList;

public class SwapPairsIterative {
    public ListNode swapPairsIterative(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode curr = dummy;
        while(curr.next!=null && curr.next.next!=null){
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next=second.next;
            second.next=first;

            curr.next=second;
            curr=first;
        }
        return dummy.next;
    }
    public static void main(String [] Args){
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next= new ListNode(2);
        current = current.next;
        current.next= new ListNode(3);
        current = current.next;
        current.next= new ListNode(4);

        SwapPairsIterative sp = new SwapPairsIterative();
        ListNode newCurr = sp.swapPairsIterative(head);
        while (newCurr!=null){
            System.out.println(newCurr.val);
            newCurr=newCurr.next;
        }

        // it should come as 2-->1-->4-->3

    }
}
