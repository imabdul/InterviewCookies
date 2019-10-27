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
 * Assume that:
 *      1. N is an integer within range [1..8];
 *      2. each string in A consists of lowercase English letters;
 *      3. the sum of lengths of strings in A doesn't exceed 100;
 *
 *
 *
 */
public class MaxSizeOfConcatStringsWithUniqueCharacters {
    public int maxSize(String[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int res=0;

        Arrays.sort(A, (a, b) -> Integer.compare(b.length(), a.length()));

        for (int t = 0; t < A.length; t++) {
            char[] arr1 = A[t].toCharArray();
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < arr1.length; k++) {
                if (set.contains(arr1[k])) {
                    break;
                }
                set.add(arr1[k]);
            }
            if (arr1.length != set.size()) map.put(t, 0);
            else map.put(t, A[t].length());
        }
        System.out.println(map.values());



        for(int i=0; i<A.length;i++) {
            if (map.get(i) == 0) continue;

            int len = 0;
            char[] arr1 = A[i].toCharArray();
            //System.out.println("String1 " + A[i]);
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < arr1.length; k++) {
                if (set.contains(arr1[k])) {
                    break;
                }
                set.add(arr1[k]);
            }
            if (arr1.length != set.size()) continue;
            else {
                len += arr1.length;
            }

            for (int j = 0; j < A.length; j++) {
                if (j==i ) continue; //ignored
                if(map.get(j) == 0) continue;
                char[] arr2 = A[j].toCharArray();
                //System.out.println("String2 " + A[j]);
                for (int k = 0; k < arr2.length; k++) {
                    if (set.contains(arr2[k])) {
                        break;
                    }
                    set.add(arr2[k]);
                }

                if (len + arr2.length != set.size()) break;
                else {
                    len += arr2.length;
                }
            }
            res=Math.max(len,res);
        }
        return res;
    }

    public static void main (String[] args){
        MaxSizeOfConcatStringsWithUniqueCharacters concatStrings = new MaxSizeOfConcatStringsWithUniqueCharacters();
        String[] str1 = new String[]{"co","dil","itya"};
        System.out.println(concatStrings.maxSize(str1));//expected 5
        String[] str2 = new String[]{"abc","kkk","def","csv"};
        System.out.println(concatStrings.maxSize(str2));//expected 6
        String[] str3 = new String[]{"potato","kayak","banana","racecar"};
        System.out.println(concatStrings.maxSize(str3));//expected 0
        String[] str4 = new String[]{"eva","jwq","tyn","jan"};
        System.out.println(concatStrings.maxSize(str4));//expected 9
        String[] str5 = new String[]{"eva","jwq","tyn","jan","abc","def","ghi","jkl","mno"};
        System.out.println(concatStrings.maxSize(str5));//expected 12
    }

}
