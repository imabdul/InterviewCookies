/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
CIQ APPLE
Given a string, find the length of the longest substring without repeating characters.
Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

package Algos.String;
import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int i = 0, j = 0, max = 0;
        while (j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args){
        LongestSubstring ls = new LongestSubstring();
        String s1 = "abcabcbb";
        System.out.println(ls.lengthOfLongestSubstring(s1));  //expected is 3 (abc)
        String s2 = "bbbbb";
        System.out.println(ls.lengthOfLongestSubstring(s2));  //expected is 1 (b)
        String s3 = "pwwkew";
        System.out.println(ls.lengthOfLongestSubstring(s3));  //expected is 3 (wke)
    }
}
