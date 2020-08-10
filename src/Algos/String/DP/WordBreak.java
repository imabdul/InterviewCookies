package Algos.String.DP;

/**
 * Created by abdul on 8/9/20.
 *
 * https://leetcode.com/problems/word-break/
 *
 ************
 * **** FAQ, DP BASED
 ************
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false

 */


import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] DP = new boolean[s.length()+1];
        DP[0]= true;
        for(int i=1; i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(DP[j] && dictSet.contains(s.substring(j,i))){
                    DP[i]=true;
                    break;
                }
            }

        }
        return DP[s.length()];
    }

    public static void main(String[] Args){
        WordBreak wb = new WordBreak();

        String s1 = "leetcode";
        List<String> testlist1 =  new ArrayList<>();
        testlist1.add("leet");
        testlist1.add("code");

        System.out.println(wb.wordBreak(s1,testlist1));

        String s2 = "applepenapple";
        List<String> testlist2 =  new ArrayList<>();
        testlist2.add("apple");
        testlist2.add("pen");

        System.out.println(wb.wordBreak(s2,testlist2));

        String s3 = "catsandog";
        List<String> testlist3 =  new ArrayList<>();
        testlist3.add("cats");
        testlist3.add("dog");
        testlist3.add("sand");
        testlist3.add("and");
        testlist3.add("cat");


        System.out.println(wb.wordBreak(s3,testlist3));



    }
}
