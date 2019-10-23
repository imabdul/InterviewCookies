package Algos.String;

import java.util.Arrays;
import java.util.*;


/**
 * Created by Abdul Malik
 * asked in MSFT Codility assessmnt
 *
 * Given an array A consisting of strings, your function should calculate the length of the longest string S such that:
 *      1. S is a concatenation of some of the strings from A;
 *      2. every Letter in S is Different
 *
 * Example:
 *      1. Given A = ["co","dil","ity"], method should return 5. The resulting string S could be "codil","dilco","coity" or"ityco".
 *      2. Given A = ["abc","kkk","def","csv"], method should return 6. The resulting string S could be "abcdef","defabc","defcsv" or "csvdef".
 *      3. Given A = ["potato","kayak","banana","racecar"], method should return 0. It is impossible to choose any of these strings as each of them contains repeating letters.
 *      4. Given A = ["eva","jwq","tyn","jan"], method should return 9. One of the possible strings of this length is "evajwqtyn"
 *
 * Assume tha:
 *      1. N is an integer within range [1..8];
 *      2. each string in A consists of lowercase English letters;
 *      3. the sum of lengths of strings in A doesn't exceed 100;
 *
 */
public class MaxSizeOfConcatStringsWithUniqueCharacters {
    public int maxSize(String[] A){
        int len = 0;
        for(int i=0; i<A.length-1;i++){ //loop through entire Array
            char[] arr1 = A[i].toCharArray();

            Set<Character> set = new HashSet<>();
            for(int k=0; k<arr1.length;k++){ // loop through each word
                if(set.contains(arr1[k])){
                    break;
                }
                set.add(arr1[k]);
            }
            if(arr1.length!=set.size()) continue;
            else{
                len+=arr1.length;
                System.out.println(Arrays.asList(set));
            }


            for (int j=0; j<A.length;j++){
                if(j==i)continue;
                char[] arr2 = A[j].toCharArray();
                for(int k=0; k<arr2.length;k++){
                    if(set.contains(arr2[k])){
                        break;
                    }
                    set.add(arr2[k]);
                }
                if(len+arr2.length!=len+set.size()) continue;
                else {
                    len+=arr2.length;
                    System.out.println(Arrays.asList(set));
                }

            }
        }
        return len;
    }

    public static void main (String[] args){
        MaxSizeOfConcatStringsWithUniqueCharacters concatStrings = new MaxSizeOfConcatStringsWithUniqueCharacters();
        String[] str1 = new String[]{"co","dil","ity"};
        System.out.println(concatStrings.maxSize(str1));//expected 5
        String[] str2 = new String[]{"abc","kkk","def","csv"};
        System.out.println(concatStrings.maxSize(str2));//expected 6
        String[] str3 = new String[]{"potato","kayak","banana","racecar"};
        System.out.println(concatStrings.maxSize(str3));//expected 0
        String[] str4 = new String[]{"eva","jwq","tyn","jan"};
        System.out.println(concatStrings.maxSize(str4));//expected 9
    }

}
