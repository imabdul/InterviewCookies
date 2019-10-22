package Algos.String;

/**
 * Created by Abdul Malik
 *
 * Applied Similar approach as Text Justification Hard Leetcode problem in this one
 *
 * Given a string s and an integer k. Break the string in such a way that:
 *     The resulting string should not contain parts of a word.
 *     The resulting string should not contain spaces.
 *     If the size of k is greater than length of given string then return the given string as it is.
 * Example 1:
 * Input: s = "Codility We test coders", k = 14
 * Output: "Codility We"
 * Explaination: If we split until 14 characters then output will be "Codility We te", but since "te" is part of a word so ignore that.
 * Also notice we ignore the space after "We" and "test" in our output.
 * Example 2:
 * Input: s = "The quick brown fox jumps over the lazy dog", k = 39
 * Output: "The quick brown fox jumps over the lazy"
 * Example 3:
 * Input: s = "Why not", k = 39
 * Output: "Why not"
 * Explaination: Since the size of 'k' is greater than the length of given string so we return the string as it is.
 */

public class WordWrapCodilityVersion {
    public static String getWordWrap(String s, int k) {
        String[] words = s.split(" ");
        int index=0;
        int len = words.length;
        if(len<=k) return s;
        int count=0;
        //StringBuilder sb = new StringBuilder();
        while(index < len && count+words[index].length()+1<=k){
            count+=words[index].length()+1;
            index++;
        }
        return count==0?new String(""):s.substring(0,count);
    }

    public static void main(String[] args) {
        String s1 = "Codility We test coders"; int k1 = 14;
        String s2 = "The quick brown fox jumps over the lazy dog"; int k2 = 39;
        String s3 = "Why not"; int k3 = 39;
        String s4 = "Codility We test coders"; int k4 = 2;
        System.out.println(getWordWrap(s1, k1));
        System.out.println(getWordWrap(s2, k2));
        System.out.println(getWordWrap(s3, k3));
        System.out.println(getWordWrap(s4, k4));
    }
}