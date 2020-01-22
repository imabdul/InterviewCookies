package Algos.String;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 *
 *
 * Example 1:
 *
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 *
 * Note:
 *
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int s1i = s1.indexOf(' ');
                int s2i = s2.indexOf(' ');
                char s1fc = s1.charAt(s1i+1);
                char s2fc = s2.charAt(s2i+1);

                //handling comparison of digit-logs after identifier
                if(s1fc<='9'){
                    if(s2fc<='9') return 0;
                    return 1;
                }
                if(s2fc<='9') return -1;

                //handling comparison of letter-logs and then identifiers if letter-logs are equal
                int val = s1.substring(s1i+1).compareTo(s2.substring(s2i+1));
                return  val==0 ? s1.substring(0,s1i).compareTo(s2.substring(0,s2i)) : val;
            }
        };

        Arrays.sort(logs,comp);
        return logs;
    }
    public static void main(String[] args){
        ReorderLogFiles rlf = new ReorderLogFiles();
        String[] in1 = new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        rlf.reorderLogFiles(in1);
        System.out.println(Arrays.asList(in1)); // output should be ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
    }
}
