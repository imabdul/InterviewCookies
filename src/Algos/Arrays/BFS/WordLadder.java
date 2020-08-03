package Algos.Arrays.BFS;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int length=2;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                String str = q.poll();
                char[] charArr = str.toCharArray();
                for(int j=0 ; j< charArr.length; j++){
                    char prev = charArr[j];
                    for(char c='a';c<='z'; c++){
                        charArr[j]=c;
                        String newStr = new String(charArr);
                        if(newStr.equals(endWord))return length;
                        else if (set.remove(newStr)){
                            q.add(newStr);
                        }
                        charArr[j]=prev;
                    }
                }
            }
            length++;
        }
        return 0;
    }
    public static void main(String [] Args){

        String b1 = "hit";
        String e1 = "cog";
        List<String> wordList1 = new ArrayList<>();
        wordList1.add("hot");
        wordList1.add("dot");
        wordList1.add("dog");
        wordList1.add("lot");
        wordList1.add("log");
        wordList1.add("cog");

        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength(b1,e1,wordList1)); // output should be 5

        String b2 = "hit";
        String e2 = "cog";
        List<String> wordList2 = new ArrayList<>();
        wordList2.add("hot");
        wordList2.add("dot");
        wordList2.add("dog");
        wordList2.add("lot");
        wordList2.add("log");
        System.out.println(wl.ladderLength(b2,e2,wordList2)); // output should be 0
    }
}
