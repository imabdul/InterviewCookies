/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


package Algos.LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode L1, ListNode L2){
        if(L1==null) return L2;
        else if (L2==null) return L1;
        else{
            ListNode t1 = L1;
            ListNode t2 = L2;
            ListNode result = new ListNode(-1);
            ListNode dummy = result;
            int sum = 0;
            while(t1 !=null || t2 !=null){
                sum/=10;
                if(t1!=null){
                    sum+=t1.val;
                    t1=t1.next;
                }
                if(t2!=null){
                    sum+=t2.val;
                    t2=t2.next;
                }
                dummy.next=new ListNode(sum%10);
                dummy=dummy.next;
            }
            if (sum/10==1) dummy.next = new ListNode(1);
            return result.next;
        }


    }

    public static void main(String [] Args){
        ListNode L1 = new ListNode(2);
        L1.next=new ListNode(4);
        L1.next.next=new ListNode(3);

        ListNode L2 = new ListNode(5);
        L2.next=new ListNode(6);
        L2.next.next=new ListNode(4);


        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode result = atn.addTwoNumbers(L1,L2);
        ListNode dummy = result;

        while (dummy!=null){
            System.out.print(dummy.val + " ");
            dummy=dummy.next;
        }


    }


}
