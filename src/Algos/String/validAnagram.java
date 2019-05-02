/*Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

 */


package Algos.String;

public class validAnagram {

        public boolean isAnagram(String s, String t) {

            if(s.length()!=t.length()) return false;

            int [] charArr = new int [26];

            for(char c:s.toCharArray()) charArr[c-'a']++;
            for(char c:t.toCharArray()) charArr[c-'a']--;

            for(int i: charArr){
                if(i!=0) return false;
            }

            return true;

        }

        public static void main(String[] args){
            String s1 = "anagram", t1 = "nagaram";
            String s2 = "rat", t2 = "car";
            validAnagram va = new validAnagram();
            System.out.println("s1 & t1 --> " + va.isAnagram(s1,t1));
            System.out.println("s2 & t2 --> " + va.isAnagram(s2,t2));
        }


}
