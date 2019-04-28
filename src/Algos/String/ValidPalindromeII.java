/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */

package Algos.String;

public class ValidPalindromeII {
    public boolean isPalindromeII(String s){
        s=s.trim().toLowerCase();
        //System.out.println(s);
        int idx = 0;
        int len=s.length()-1;
        while(idx<=len){
            if((s.charAt(idx)<'a' &&  s.charAt(idx)>'9') || s.charAt(idx)>'z'||  s.charAt(idx)<'0')idx++;
            else if( (s.charAt(len)<'a' && s.charAt(len)>'9') || s.charAt(len)>'z' ||  s.charAt(len)<'0')len--;
            else  if (s.charAt(idx)==s.charAt(len)){
                idx++;
                len--;
            }
            else{
                return false;
            }

        }

        return true;
    }



    public static void main(String[] args) {

        String test1 = "A man, a plan, a canal: Panama"; //true
        String test2 = "race a car"; //false
        String test3 = " "; //true
        String test4 = "  a a"; //true
        String test5 = "a b 99 :; ba"; //true
        String test6 = "a b 98 :; ba"; //false

        ValidPalindromeII vp = new ValidPalindromeII();

        System.out.println("Is test1 Palindrome --> " + vp.isPalindromeII(test1));
        System.out.println("Is test2 Palindrome --> " + vp.isPalindromeII(test2));
        System.out.println("Is test3 Palindrome --> " + vp.isPalindromeII(test3));
        System.out.println("Is test4 Palindrome --> " + vp.isPalindromeII(test4));
        System.out.println("Is test5 Palindrome --> " + vp.isPalindromeII(test5));
        System.out.println("Is test6 Palindrome --> " + vp.isPalindromeII(test6));

    }
}
