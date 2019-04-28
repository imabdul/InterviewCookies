package DataStructures.LinkedLists.Singly.Implementation;

class Main {
    public static void main(String[] Args){
        LinkedList list = new LinkedList();
        list.insertAtFirst(1);
        list.insertAtFirst(2);
        list.insertAtFirst(3);
        ListNode test = list.getHead();
        System.out.println(test.val);
        System.out.println(test.next.val);
        System.out.println(test.next.next.val);
        list.insertAtIndex(5, 1);
        System.out.println("-------------");
        while(test!=null){
            System.out.println(test.val);
            test=test.next;
        }
        list.insertAtFirst(9);
        System.out.println("-------------");
        test = list.getHead();
        while(test!=null){
            System.out.println(test.val);
            test=test.next;
        }
        list.insertAtIndex(13, 4);
        System.out.println("-------------");
        test = list.getHead();
        while(test!=null){
            System.out.println(test.val);
            test=test.next;
        }

        list.insertAtLast(11);
        System.out.println("-------------");
        list.printListIterative();
        list.printListRecursive();
        list.printListReverse();
        list.removeLast();
        list.printListReverse();
        //list.reverse();
        //list.printListIterative();
        //System.out.println(test.val);
        //System.out.println(test.next.val);



    }
}
