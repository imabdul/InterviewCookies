package Algos.LinkedList;

public class SwapPairsRecursive {

    public ListNode swapPairsRecursive(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode n = head.next;
        head.next = swapPairsRecursive(head.next.next);
        n.next = head;
        return n;
    }




    public static void main(String [] Args){
        ListNode head = new ListNode(1);
        ListNode current = head;
        current.next= new ListNode(2);
        current = current.next;
        current.next= new ListNode(3);
        current = current.next;
        current.next= new ListNode(4);

        SwapPairsRecursive sp = new SwapPairsRecursive();
        ListNode newCurr = sp.swapPairsRecursive(head);
        while (newCurr!=null){
            System.out.println(newCurr.val);
            newCurr=newCurr.next;
        }

        // it should come as 2-->1-->4-->3

    }
}
