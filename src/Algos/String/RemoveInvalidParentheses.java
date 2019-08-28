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


