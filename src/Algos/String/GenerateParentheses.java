package Algos.String;
import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    private List<String> result;
    public List<String> generateParentheses(int n) {
        result = new ArrayList<>();
        backtrack(new String(""),0,0, n);
        return result;
    }

    private void backtrack(String curr, int open, int close, int max){
        if(curr.length()==max*2){
            result.add(curr);
            return;
        }
        if(open<max)backtrack(curr+'(', open+1,close, max);
        if(close<open)backtrack(curr+')', open,close+1, max);
    }

    public static void main(String[] args){
        GenerateParentheses gp = new GenerateParentheses();
        List<String> out = gp.generateParentheses(3);
        System.out.println(Arrays.asList(out)); //[((())), (()()), (())(), ()(()), ()()()]
    }

}
