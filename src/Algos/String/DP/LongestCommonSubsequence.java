package Algos.String.DP;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * If there is no common subsequence, return 0.
 *
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * Constraints:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 *
 ************************************
 * DP Problem Solved through top down approach
 * Hint 1 - Try dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
 * Hint 2 - DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
 ***************************************
 */

public class LongestCommonSubsequence {
    /* A Naive recursive implementation of LCS problem in java*/
    /*public int getLCS(char[] charArr1, char[] charArr2, int l1, int l2){
        if(l1==0 || l2==0) return 0;
        else if (charArr1[l1-1]== charArr2[l2-1]){
            return 1 + getLCS(charArr1, charArr2, l1-1,l2-1);
        }
        else{
            return Math.max(getLCS(charArr1, charArr2, l1,l2-1),getLCS(charArr1, charArr2, l1-1,l2));
        }

    }
*/
    public int getLCS(char[] charArr1, char[] charArr2, int l1, int l2){
        int[][] DP = new int[l1+1][l2+1];
        for (int i=0; i<=l1; i++){
            for (int j=0;j<=l2;j++){
                if(i==0 || j==0) DP[i][j]=0;
                else if(charArr1[i-1]==charArr2[j-1]) DP[i][j]=1+DP[i-1][j-1];
                else DP[i][j]=Math.max(DP[i-1][j],DP[i][j-1]);
            }
        }

        return DP[l1][l2];
    }

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.getLCS( X, Y, m, n ) ); //expected is 4 cause GTAB is common subsequence
    }

}
