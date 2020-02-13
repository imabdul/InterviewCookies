package Algos.String.TwoPointer;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.sql.SQLOutput;
import java.util.*;
public class LongestSubsequenceWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0,max=0;
        int len = s.length();
        while(j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max=Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] Args){
        LongestSubsequenceWithoutRepeatingCharacters ls = new LongestSubsequenceWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstring("abcabcbb")); //Answer is 3
        System.out.println(ls.lengthOfLongestSubstring("bbbbb")); //Answer is 1
        System.out.println(ls.lengthOfLongestSubstring("pwwkew")); //Answer is 3

    }

}
