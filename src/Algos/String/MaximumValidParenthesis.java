package Algos.String;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 *
 */

public class MaximumValidParenthesis {
    int totalCount;
    public int maxValidParentheses(String s) {
        int index=0;
        totalCount=0;
        if(s.length()<=1) return totalCount;
        maxValidParenthesesHelper(s, index);
        return totalCount;
    }

    private void maxValidParenthesesHelper(String s, int index){
        if(index<s.length()-1){
            while(s.charAt(index)!='('&& index<s.length())index++;
            int count=0;
            for(int i=index;i<s.length();i++){
                //System.out.println(i);
                char c = s.charAt(i);
                if(c=='(')count++;
                if(c==')')count--;
                if(count==0){
                    //System.out.println(count);
                    totalCount++;
                    //System.out.println(totalCount);
                    index=i+1;
                    break;
                }
                //System.out.println(count);
                index++;
            }
            maxValidParenthesesHelper(s, index);
            return;
        }
    }

    public static void main(String[] args){
        MaximumValidParenthesis mvp = new MaximumValidParenthesis();
        String s1=")(()"; //1
        String s2 ="(((())))()(())"; //3
        String s3 =")(((()))))()(())"; //3
        String s4 =")("; //0
        System.out.println(mvp.maxValidParentheses(s1));
        //System.out.println(mvp.maxValidParentheses(s2));
        //System.out.println(mvp.maxValidParentheses(s3));
        //System.out.println(mvp.maxValidParentheses(s4));

    }
}
