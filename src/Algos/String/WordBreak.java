package Algos.String;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */



import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
public class WordBreak {


    /**
     * first Solving it through BFS
     * Time complexity - O(N^2) (or O(N^3) as Substring takes O(N) cost separately)
     * Space Complexity - O(N)
     * @param s
     * @param wordDict
     * @return boolean
     */
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        HashSet<String> dictSet = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()){
            int start= q.poll();
            if(!visited[start]){
                for(int end=start+1; end<=s.length();end++){
                    if(dictSet.contains(s.substring(start,end))){
                        q.add(end);
                        if(end == s.length()) return true;
                    }
                }

                visited[start]=true;

            }

        }

        return false;
    }

    /**
     * recursion and memoization
     * Time complexity - O(2^N) better as memoization optimizing the solution (or O(N^3) as Substring takes O(N) cost separately)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakRecursionAndMemoization(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


    /**
     * DP Solution to the same problem
     * Time complexity - O(N^2) (or O(N^3) as Substring takes O(N) cost separately)
     * Space Complexity - O(N)
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        boolean[] DP = new boolean[s.length()+1];
        DP[0]=true;

        for(int i=1; i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(DP[j]==true && dictSet.contains(s.substring(j,i))){
                    DP[i]=true;
                    break;
                }
            }
        }


        return DP[s.length()];
    }

    public static void main(String[] Args){
        String s1= "leetcode";
        List<String> dict1 = new ArrayList<>();
        dict1.add("leet");
        dict1.add("code");

        String s2= "applepenapple";
        List<String> dict2 = new ArrayList<>();
        dict2.add("apple");
        dict2.add("pen");

        String s3= "catsandog";
        List<String> dict3 = new ArrayList<>();
        dict3.add("cats");
        dict3.add("dog");
        dict3.add("sand");
        dict3.add("and");
        dict3.add("cat");


        WordBreak wb = new WordBreak();

        System.out.println("---------RECURSION/MEMOIZATION SOLUTION--------");
        System.out.println(wb.wordBreakRecursionAndMemoization(s1, dict1));
        System.out.println(wb.wordBreakRecursionAndMemoization(s2, dict2));
        System.out.println(wb.wordBreakRecursionAndMemoization(s3, dict3));

        System.out.println("---------BFS SOLUTION--------");
        System.out.println(wb.wordBreakBFS(s1, dict1));
        System.out.println(wb.wordBreakBFS(s2, dict2));
        System.out.println(wb.wordBreakBFS(s3, dict3));


        System.out.println("---------DP SOLUTION--------");
        System.out.println(wb.wordBreakDP(s1, dict1));
        System.out.println(wb.wordBreakDP(s2, dict2));
        System.out.println(wb.wordBreakDP(s3, dict3));


    }
}