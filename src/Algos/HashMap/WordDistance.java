package Algos.HashMap;

/**
 * LeetCode Medium Problem
 * https://leetcode.com/problems/shortest-word-distance-ii/
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * important question to ask, can words have duplicates.
 */

import java.util.*;
class WordDistance {

    Map<String,List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        int i=0;
        for(String s: words){
            if(!map.containsKey(s)) map.put(s,new ArrayList<>());
            map.get(words[i]).add(++i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for(int i=0, j=0; i<list1.size() && j<list2.size();){
            int index1=list1.get(i), index2=list2.get(j);
            if(index1<index2){
                ans=Math.min(ans,index2-index1);
                i++;
            }
            else{
                ans=Math.min(ans, index1-index2);
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String [] words= new String[]{"practice","makes","perfect","coding","makes"};
        WordDistance wd = new WordDistance(words);
        int result1 = wd.shortest("coding", "practice");
        System.out.println(result1); // expected 3
        int result2 = wd.shortest("makes","coding");
        System.out.println(result2); // expected 1
    }
}