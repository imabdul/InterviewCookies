package Algos.LinkedList;

class ListNode {
    ListNode next;
    int val;

    public ListNode(int val){
        this.val=val;
    }
}

public class ReverseLinkedList {

    public ListNode ReverseLinkedList(ListNode node){
        ListNode prev=null,next=null, curr = node;
        if(curr ==null || curr.next==null) return curr;


        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static void main(String [] Args){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        System.out.print(head.val + " ");
        System.out.print(head.next.val + " ");
        System.out.print(head.next.next.val + " ");
        System.out.println();
        ReverseLinkedList rev = new ReverseLinkedList();
        ListNode test = rev.ReverseLinkedList(head);
        System.out.print(test.val + " ");
        System.out.print(test.next.val + " ");
        System.out.print(test.next.next.val + " ");



    }


}
