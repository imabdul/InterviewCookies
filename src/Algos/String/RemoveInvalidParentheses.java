package Algos.String;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 */

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 * Key Points:
 * Generate unique answer once and only once, do not rely on Set.
 * Do not need preprocess.
 * Runtime 3 ms.
 *
 * Explanation:
 * We all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
 * The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.
 *
 * To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix. However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same (). Thus, we restrict ourself to remove the first ) in a series of concecutive )s.
 *
 * After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string. However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
 * For this, we keep tracking the last removal position and only remove ‘)’ after that.
 *
 * Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
 * The answer is: do the same from right to left.
 * However a cleverer idea is: reverse the string and reuse the code!
 * Here is the final implement in Java.
 */

import java.util.*;
public class RemoveInvalidParentheses {
    private List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        remove(s, 0,0,'(',')');
        return result;
    }

    private void remove(String s, int iStart, int jStart, char openParen, char closedParen){
        int numOpenParen =0, numClosedParen=0;
        for(int i = iStart; i<s.length(); i++){
            if(s.charAt(i)==openParen)numOpenParen++;
            if(s.charAt(i)==closedParen)numClosedParen++;
            if(numClosedParen>numOpenParen){
                for(int j=jStart; j<=i;j++){
                    if(s.charAt(j)==closedParen && (j==jStart || s.charAt(j-1)!=closedParen)){
                        remove(s.substring(0,j)+s.substring(j+1),i,j, openParen, closedParen);
                    }
                }
                return;
            }

        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(openParen=='('){
            remove(reverse,0,0,')','(');
        }
        else{
            result.add(reverse);
        }

    }


    public static void main (String[] args){
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        String inp1 = new String("()())()");
        String inp2 = new String("(a)())()");
        String inp3 = new String(")(");

        List<String> out1 = rip.removeInvalidParentheses(inp1);
        List<String> out2 = rip.removeInvalidParentheses(inp2);
        List<String> out3 = rip.removeInvalidParentheses(inp3);

        System.out.println(Arrays.asList(out1));
        System.out.println(Arrays.asList(out2));
        System.out.println(Arrays.asList(out3));

    }
}


