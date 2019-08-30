package OOPDesignProblems.Collection;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
    ListNode<T> head, tail;

    public void add(T data) {
        ListNode<T> node = new ListNode<T>(data, null);
        if (head == null) head  = tail = node;
        else {
            tail.setNext(node);
            tail = node;
        }
    }

    public ListNode<T> getHead() {
        return head;
    }

    public ListNode<T> getTail() {
        return tail;
    }

    //return Iterator instance
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    ListNode<T> current;

    public ListIterator(List<T> list) {
        current=list.getHead();
    }

    public boolean hasNext() {
        return current!=null;
    }

    public T next() {
        T data = current.data;
        current=current.getNext();
        return data;
    }

    public void skip() {
        current.next= current.next.next;
        current=current.getNext();
    }

}

class ListNode<T>{
    ListNode<T> next;
    T data;

    public ListNode(T data, ListNode<T> next){
        this.data=data;
        this.next=next;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data=data;
    }

    public ListNode<T> getNext(){
        return next;
    }
    public void setNext(ListNode<T> next){
        this.next=next;
    }

}

class Main {
    public static void main(String[] args)
    {
        // Create Linked List
        List<String> myList = new List<>();

        // Add Elements
        myList.add("abc");
        myList.add("mno");
        myList.add("pqr");
        myList.add("xyz");

        //Iterator iter = myList.iterator();

        Iterator iter  = myList.iterator();

        String str = "asfaf";
        String[] a = str.split("#");


        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
