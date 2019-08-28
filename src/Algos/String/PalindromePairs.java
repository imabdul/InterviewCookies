package Algos.String;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */


import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words.length<1)return null;
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) map.put(words[i],i); //store word as key with it's index in Map
        for (int i=0;i<words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String firstPart = words[i].substring(0, j); // take an example of ["abcd","dcba","lls","s","sssll"], specifically "lls", when j=1, ll is palindrome, reverse of "s" is "s", it's there is map, add this first and then i.
                String secondPart = words[i].substring(j);
                if (isPalindrome(firstPart)) {
                    String revSecPart = new StringBuilder(secondPart).reverse().toString();
                    if (map.containsKey(revSecPart) && map.get(revSecPart) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(revSecPart));
                        list.add(i);
                        result.add(list);

                    }
                }
                if (isPalindrome(secondPart)) {
                    String revFirstPart = new StringBuilder(firstPart).reverse().toString();
                    if (map.containsKey(revFirstPart) && map.get(revFirstPart) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(revFirstPart));
                        result.add(list);

                    }

                }

            }

        }
        return result;
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] Args){
        String[] inp1 = new String[]{"abcd","dcba","lls","s","sssll"};
        String[] inp2 = new String[]{"bat","tab","cat"};
        PalindromePairs pp = new PalindromePairs();
        List<List<Integer>> out1= pp.palindromePairs(inp1);
        List<List<Integer>> out2= pp.palindromePairs(inp2);
        System.out.println(Arrays.asList(out1));
        System.out.println(Arrays.asList(out2));

    }
}
