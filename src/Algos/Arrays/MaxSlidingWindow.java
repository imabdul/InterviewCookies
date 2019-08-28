/*
LeetCode: Sliding Window Maximum [Hard]

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?


 */

package Algos.Arrays;
import java.util.Arrays;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null || nums.length<1) return nums;
        int[] result = new int [nums.length-k+1];
        Arrays.fill(result, Integer.MIN_VALUE);

        for(int i=0; i<nums.length-k+1; i++){
            for(int j=i; j<i+k;j++){
                result[i]=Math.max(result[i],nums[j]);
            }
        }
        return result;
    }

    public static void main (String[] args){
        int [] test1 = new int[]{1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow mx= new MaxSlidingWindow();
        int [] result = mx.maxSlidingWindow(test1,3);
        for (int num: result){
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
