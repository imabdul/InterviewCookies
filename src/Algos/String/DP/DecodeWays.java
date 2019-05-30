/**
 Decode Ways - LeetCode: https://leetcode.com/problems/decode-ways

 This code is by NO MEANS cleanly or well done. I just threw this together
 for teaching purposes and it is generally a sloppy example but gets the point
 across
 This code passes all Leetcode test cases as of Mar. 10 2019
 Runtime: 1 ms, faster than 87.88% of Java online submissions for Decode Ways.
 Memory Usage: 34.4 MB, less than 77.38% of Java online submissions for Decode Ways.
 The video to explain this code is here: https://www.youtube.com/watch?v=YcJTyrG3bZs
 */

package Algos.String.DP;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) { //Dynamic Programming (with memoization)
        int[] prevAnswers = new int[s.length()];
        Arrays.fill(prevAnswers,-1);
        return numDecodings(s,0,prevAnswers);
    }

    private int numDecodings(String s,int decodePointer,int[] prevAnswers){
        //base condition/check so that decodePointer won't go out of bound
        if(decodePointer>=s.length()) return 1;

        //don't need to compute again if the subproblem is already solved
        if(prevAnswers[decodePointer]>-1) return prevAnswers[decodePointer];

        //compute now
        int waysFromHere = 0;

        if(decodePointer + 1 <= s.length()){
            String firstWay=s.substring(decodePointer,decodePointer+1);
            if(isValid(firstWay)){
                waysFromHere+=numDecodings(s,decodePointer+1,prevAnswers );
            }
        }

        if(decodePointer + 2 <= s.length()){
            String secondWay=s.substring(decodePointer,decodePointer+2);
            if(isValid(secondWay)){
                waysFromHere+=numDecodings(s,decodePointer+2,prevAnswers );
            }
        }

        //Very Important step: CACHE THE SUBPROBLEM ANSWER. We will need this later when asked more subproblems
        prevAnswers[decodePointer]=waysFromHere;

        return prevAnswers[decodePointer];
    }

    private boolean isValid(String s){
        if(s.length()<=0) return false;
        if(s.charAt(0)=='0') return false;

        int value = Integer.parseInt(s);

        return value>=1 && value<=26;
    }


    public static void main(String[] args){
        String s1 = "12";
        String s2 = "226";
        DecodeWays dcd = new DecodeWays();
        System.out.println(dcd.numDecodings(s1));
        System.out.println(dcd.numDecodings(s2));
    }

}
