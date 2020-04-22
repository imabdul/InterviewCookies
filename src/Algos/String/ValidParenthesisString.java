package Algos.String;

/**
 * Created by abdul on 4/20/20.
 */

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 An empty string is also valid.
 Example 1:
 Input: "()"
 Output: True
 Example 2:
 Input: "(*)"
 Output: True
 Example 3:
 Input: "(*))"
 Output: True
 Note:
 The string size will be in the range [1, 100].
 */

/**
 * Solution follows greedy approach
 */

public class ValidParenthesisString {
    public boolean checkValidString(String s){
        int lo=0;
        int hi=0;
        for (char c: s.toCharArray()){
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if(hi<0) break;
            lo=Math.max(lo,0);
        }
        return lo==0;
    }

    public static void main(String[] args){
        String s1 = "()";
        String s2 = "(*)";
        String s3 = "(*))";
        String s4 = ")*()";
        ValidParenthesisString vps = new ValidParenthesisString();

        System.out.println(vps.checkValidString(s1));
        System.out.println(vps.checkValidString(s2));
        System.out.println(vps.checkValidString(s3));
        System.out.println(vps.checkValidString(s4));

    }

}

