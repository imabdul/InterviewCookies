package Algos.String.BackTrack;
/*
https://leetcode.com/problems/generate-parentheses/
Good explanation in Solution
 */
import java.util.*;
public class GenerateParenthesis {
    List<String> result ;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(new String(""),0,0,n);
        return result;
    }

    public void backtrack(String curr, int open, int close, int max) {
        if(curr.length()==max*2){
            result.add(curr);
            return;
        }

        if(open<max) backtrack(curr+"(",open+1,close,max);
        if(close<open)backtrack(curr+")",open,close+1,max);
    }

    public static void main(String[] Args){
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> outList = gp.generateParenthesis(3);
        for(String s: outList) System.out.println(s);
    }
}
