/*
LeetCode Easy Problem (Maximum Subarray) Solved with DP
--------------------------------------------------------
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */


package Algos.Arrays.DP;

public class MaximumSubArray {
    //As this can also be solved in O(1) space complexity O(N) Time Complexity
    public int maxSubArray(int[] nums){
        int currMax=nums[0];
        int maxVal=nums[0];
        for(int i=1; i<nums.length; i++){
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxVal=Math.max(maxVal,currMax);
        }
        return maxVal;
    }

    // O(N) space complexity Solution
    /*public int maxSubArray(int[] nums){
        int[] dp = new int [nums.length];
        dp[0] = nums[0];
        int maxVal=nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            maxVal=Math.max(maxVal,dp[i]);
        }
        return maxVal;
    }

    */

    public static void main(String[] Args){
        int [] test = new int []{-2,1,-3,4,-1,2,1,-5,4};  //should be 6
        MaximumSubArray ms = new MaximumSubArray();
        System.out.println(ms.maxSubArray(test));


    }
}
