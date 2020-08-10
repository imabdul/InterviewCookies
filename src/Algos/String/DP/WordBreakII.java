package Algos.String.DP;

/**
 * Created by abdul on 8/9/20.
 *
 * https://leetcode.com/problems/word-break-ii/
 *
 *******************
 *** FAQ - DP BASED
 *******************
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.

 Example 1:
 Input:
 s = "catsanddog"
 wordDict = ["cat", "cats", "and", "sand", "dog"]
 Output:
 [
 "cats and dog",
 "cat sand dog"
 ]

 Example 2:
 Input:
 s = "pineapplepenapple"
 wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 Output:
 [
 "pine apple pen apple",
 "pineapple pen apple",
 "pine applepen apple"
 ]
 Explanation: Note that you are allowed to reuse a dictionary word.

 Example 3:
 Input:
 s = "catsandog"
 wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output:
 []
 */



import java.util.*;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        return dfsHelper(s, wordSet, new HashMap<String, LinkedList<String>>());
    }

    private List<String> dfsHelper(String s,  Set<String> wordSet, Map<String, LinkedList<String>> map){
        if (map.containsKey(s))return map.get(s);

        LinkedList<String> result = new LinkedList<String>();

        if(s.length()<1) {
            result.add("");
            return result;
        }

        for(String word : wordSet){
            if(s.startsWith(word)){
                String next=s.substring(word.length());
                List<String> subList = dfsHelper(next, wordSet, map);
                for(String sub: subList){
                    result.add(word + (sub.isEmpty()?"":" ") + sub);
                }
            }
        }
        map.put(s,result);
        return result;
    }


    public static void main(String[] Args){
        WordBreakII wb = new WordBreakII();

        String s2 = "pineapplepenapple";
        List<String> testlist2 =  new ArrayList<>();
        testlist2.add("apple");
        testlist2.add("pen");
        testlist2.add("applepen");
        testlist2.add("pine");
        testlist2.add("pineapple");

        System.out.println(wb.wordBreak(s2,testlist2));

        String s3 = "catsandog";
        List<String> testlist3 =  new ArrayList<>();
        testlist3.add("cats");
        testlist3.add("dog");
        testlist3.add("sand");
        testlist3.add("and");
        testlist3.add("cat");


        System.out.println(wb.wordBreak(s3,testlist3));


        String s4 = "catsanddog";
        List<String> testlist4 =  new ArrayList<>();
        testlist4.add("cats");
        testlist4.add("dog");
        testlist4.add("sand");
        testlist4.add("and");
        testlist4.add("cat");


        System.out.println(wb.wordBreak(s4,testlist4));


    }

}