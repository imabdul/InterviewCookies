package Algos.Arrays;


/**
 * LeetCode Hard problem -->> https://leetcode.com/problems/trapping-rain-water/
 * Two Pointer Approach to solve this.
 *
 */

public class TrappingRainWater {
    public int trap(int[] height) { // Two Pointer Solution

        int trappedWater = 0;

        int left = 0;
        int right = height.length-1;

        int leftMax = 0;
        int rightMax = 0;

        while(left<right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(leftMax<rightMax){
                trappedWater+=leftMax - height[left]; //will return 0 if leftMax and height[left] is same. Only return when leftMax is > height[left]
                left++;
            }else{
                trappedWater+=rightMax - height[right]; //will return 0 if rightMax and height[right] is same. Only return when rightMax is > height[right]
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String [] Args){
            int [] testArr = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
            TrappingRainWater trw = new TrappingRainWater();
            System.out.println(trw.trap(testArr)); // 6 is ans
    }
}
