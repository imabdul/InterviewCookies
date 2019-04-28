package Algos.String;

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        int idx = 0;
        int len = s.length()-1;

        while (idx<len){
            if (s.charAt(idx)!=s.charAt(len)) return false;
            idx++;
            len--;
        }
        return true;
    }

    public static void main(String[] args){

                      //012 456
        String test1 = "abbcbba"; //0 < 6; 1 < 5; 2 < 4,
        String test2 = "abbcdbba";  //0 < 7; 1 < 6; 2 < 5; 3 < 4
        String test3 = "abbccbba";
        String test4 = "canada";
        ValidPalindrome vp = new ValidPalindrome();

        System.out.println("Is test1 Palindrome --> " + vp.isPalindrome(test1));
        System.out.println("Is test2 Palindrome --> " + vp.isPalindrome(test2));
        System.out.println("Is test3 Palindrome --> " + vp.isPalindrome(test3));
        System.out.println("Is test4 Palindrome --> " + vp.isPalindrome(test4));

    }
}
