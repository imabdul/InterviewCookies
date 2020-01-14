package CodilityMSFTAssmnt;

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
    public String getWordWrap(String s, int k) {
        /**
         * when k is bigger than string s length itself return the whole string, simple.
         */
        if(k>s.length()) return s;

        /**
         * break down s into words array
         */
        String[] words = s.split(" ");
        int index=0;
        int len = words.length;
        int count=0;
        //StringBuilder sb = new StringBuilder();
        //System.out.println(count);

        /**
         *count (prev value of count) + next word length + 1(space after word) should be smaller or equal to k
         */
        while(count+words[index].length()+1<=k){
            //System.out.println(count);
            count+=words[index].length()+1;
            /**
             * if the next word can't be accommodated within k, remove space from the end.
             */
            if (count+words[index+1].length()>k) count--;
            /**
             * edge case coverage, if the next word is last word and exactly fitting within k, add it to the count. this is where loop is goign to end.
             */
            if (count+words[index+1].length()==k) count+=words[index+1].length();

            index++;
        }
        //System.out.println(count);
        return count==0? new String(""):s.substring(0,count);
    }

    public static void main(String[] args) {
        WordWrapCodilityVersion ww = new WordWrapCodilityVersion();
        String s1 = "Codility We test coders"; int k1 = 14;
        String s2 = "The quick brown fox jumps over the lazy dog"; int k2 = 39;
        String s3 = "Why not"; int k3 = 39;
        String s4 = "Codility We test coders"; int k4 = 2;
        System.out.println(ww.getWordWrap(s1, k1));
        System.out.println(ww.getWordWrap(s2, k2));
        System.out.println(ww.getWordWrap(s3, k3));
        System.out.println(ww.getWordWrap(s4, k4));
    }
}