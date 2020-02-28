package Algos.String;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 *
 * Example 1:
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 *
 * Example 2:
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 *
 * Example 3:
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 * Example 4:
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 *
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 *
 * Hints:
 * - Loop from left to right maintaining a balance variable when it gets an L increase it by one otherwise decrease it by one.
 * - Whenever the balance variable reaches zero then we increase the answer by one.
 */

public class MaxBalancedString {
    public int balancedStringSplit(String s) {
        int balancedCount=0;
        int count=0;
        char c = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                count++;
            }
            if (s.charAt(i)!=c){
                count--;
            }
            if (count==0){
                balancedCount++;
            }

        }
        return balancedCount;

    }

    public static void main(String[] Args){
        String s1="RLRRLLRLRL";
        String s2= "RLLLLRRRLR";
        String s3="LLLLRRRR";
        String s4= "RLRRRLLRLL";
        MaxBalancedString bs= new MaxBalancedString();
        System.out.println(bs.balancedStringSplit(s1)); //4
        System.out.println(bs.balancedStringSplit(s2)); //3
        System.out.println(bs.balancedStringSplit(s3)); //1
        System.out.println(bs.balancedStringSplit(s4)); //2

    }
}
