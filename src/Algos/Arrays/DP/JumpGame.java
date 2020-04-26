package Algos.Arrays.DP;
/**
 * https://leetcode.com/problems/jump-game/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 *
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Approach 3: Dynamic Programming Bottom-up
 * Top-down to bottom-up conversion is done by eliminating recursion. In practice, this achieves better performance as we no longer have the method stack overhead and might even benefit from some caching. More importantly, this step opens up possibilities for future optimization. The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.
 *
 * The observation to make here is that we only ever jump to the right. This means that if we start from the right of the array, every time we will query a position to our right, that position has already be determined as being GOOD or BAD. This means we don't need to recurse anymore, as we will always hit the memo table.
 */

enum Index{
    GOOD,BAD,UNKNOWN
}

class JumpGame {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for(int i=0; i<nums.length;i++){
            memo[i]=Index.UNKNOWN;
        }
        memo[nums.length-1]=Index.GOOD;
        for(int i=nums.length-2; i>=0; i--){
            int furthestJump=Math.min(i+nums[i],nums.length-1);
            for(int j=i+1; j<=furthestJump; j++){
                if(memo[j]==Index.GOOD){
                    memo[i]=Index.GOOD;
                    break;
                }
            }
        }
        return memo[0]==Index.GOOD;
    }

    public static void main(String[] Args){
        int [] test1 = new int[]{2,3,1,1,4};
        int [] test2 = new int[]{3,2,1,0,4};
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(test1)); //true
        System.out.println(jg.canJump(test2)); //false
    }
}
