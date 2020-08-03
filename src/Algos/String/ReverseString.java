package Algos.String;


/**
 * Created by abdul on 8/1/20.
 */
public class ReverseString {
    //Space O(n)
    //time O(n)
    public String  reverseUsingSringBuilder(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }

    //Space O(n)
    //time O(n)
    public String  reverseRecursive(String s){
        if(s.length()<1 || s.equals("")) return s;
        return s.charAt(s.length()-1) + reverseRecursive(s.substring(0,s.length()-1));

    }

    //using temp variable
    //Space O(n)
    //time O(n)
    public String  reverseUsingTwoPointers(String s){
        char[] charArr= s.toCharArray();
        int start =0;
        int end = s.length()-1;

        while(start < end){
            char tmp = charArr[start];
            charArr[start++] = charArr[end];
            charArr[end--] = tmp;
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args){
        String test1 = "hello";
        String test2 = "united";
        String test3 = "states";
        String test4 = "";

        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseUsingSringBuilder(test1));
        System.out.println(rs.reverseUsingSringBuilder(test2));
        System.out.println(rs.reverseUsingSringBuilder(test3));
        System.out.println(rs.reverseUsingSringBuilder(test4));

        System.out.println("--------------------------------");

        System.out.println(rs.reverseRecursive(test4));
        System.out.println(rs.reverseRecursive(test3));
        System.out.println(rs.reverseRecursive(test2));
        System.out.println(rs.reverseRecursive(test1));


        System.out.println("--------------------------------");

        System.out.println(rs.reverseUsingTwoPointers(test4));
        System.out.println(rs.reverseUsingTwoPointers(test1));
        System.out.println(rs.reverseUsingTwoPointers(test2));
        System.out.println(rs.reverseUsingTwoPointers(test3));


        System.out.println("--------------------------------");


    }
}
