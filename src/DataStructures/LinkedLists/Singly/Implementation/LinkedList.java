package DataStructures.LinkedLists.Singly.Implementation;

class LinkedList {

    private ListNode head;    //Reference to the first node (called as head in LinkedList). Through head only, LinkedList can be traversed

    public ListNode  getHead(){     // to get the head
        return head;
    }

    public void insertAtFirst(int val){
        ListNode first = new ListNode(val);
        first.next=head;
        head=first;
    }

    public void insertAtIndex(int val, int index){  // method to insert a ListNode at a given index
        if (index == 0) {
            ListNode first = new ListNode(val);
            first.next=head;
            head=first;
        }
        else{
            int counter=0;
            ListNode curr=head;
            while (counter!=index-1) {
                curr = curr.next;
                counter++;
            }
            if(counter==index-1){
                ListNode indexNode = new ListNode(val);
                //ListNode cache = move.next;
                indexNode.next=curr.next;
                curr.next = indexNode;
            }

        }
    }

    public void insertAtLast(int val){
        ListNode last = new ListNode(val);
        if(head==null){
            head =last;
        }
        ListNode curr = head;
        while (curr.next!=null){
            curr = curr.next;
        }
        curr.next=last;

    }





}
