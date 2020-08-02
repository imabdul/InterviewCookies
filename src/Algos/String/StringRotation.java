package Algos.String;

/**
 * Created by abdul on 7/26/20.
 */
public class StringRotation {

    public String leftRotateString(String s, int d){

        String newStr = s.substring(d)+s.substring(0,d);
        return newStr;

    }

    public String rightRotateString(String s, int d){

        String newStr = s.substring(s.length()-d, s.length())+s.substring(0,s.length()-d);
        return newStr;

    }



    public static void main(String args[])
    {
        StringRotation sr = new StringRotation();

        String str1 = "GeeksforGeeks";
        System.out.println(sr.leftRotateString(str1, 2));

        String str2 = "GeeksforGeeks";
        System.out.println(sr.rightRotateString(str2, 2));
    }

}
