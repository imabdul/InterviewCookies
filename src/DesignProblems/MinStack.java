package DesignProblems;
import java.util.Stack;


public class MinStack {
    private int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack= new Stack<>();
    }

    public void push(int x) {
        if (x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min)min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack minstk = new MinStack();
        minstk.push(9);
        System.out.println(minstk.getMin());
        minstk.push(10);
        System.out.println(minstk.getMin());
        minstk.push(8);
        System.out.println(minstk.getMin());
        minstk.pop();
        System.out.println("top --> " + minstk.top());
        System.out.println("min --> " + minstk.getMin());


    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */