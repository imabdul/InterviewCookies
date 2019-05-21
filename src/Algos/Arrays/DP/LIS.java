//consists of overlapping substructure property, hence DP is the optimal way to solve this problem
//by definition any sub-problem is occurring and getting solved multiple times in a program is known as ovelapping substructure.
//With DP you only solve one sub-problem only once

/*             lis(4)
          /       |       \
      lis(3)     lis(2)   lis(1)   //overlapping substructure
     /    \         /
   lis(2) lis(1)  lis(1)
   /
lis(1)

 */

//LIS is Longest Increasing subsequence (Quite important question for any interview)

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

        Example:

        Input: [10,9,2,5,3,7,101,18]
        Output: 4
        Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
        Note:

        There may be more than one LIS combination, it is only necessary for you to return the length.
        Your algorithm should run in O(n2) complexity.
        Follow up: Could you improve it to O(n log n) time complexity?

 */


//O(N^2) solution
package Algos.Arrays.DP;

public class LIS {
    public int lis (int[] nums){

        int[] dp = new int[nums.length];
        int i,j,max=1;

        for(i=0; i<dp.length; i++){
            dp[i]=1;
        }



        for(i=1; i<nums.length; i++){
            for(j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1) dp[i]=dp[j]+1;
            }
            max = Math.max(max,dp[i]);
        }

        //for(int num: dp) max = Math.max(max,num);
        return max;
    }





    public static void main(String [] Args){

        int [] arr1 = new int [] {10,9,2,5,3,7,101,18}; // ans is 4
        LIS lIS = new LIS();
        System.out.println(lIS.lis(arr1));

        int[] arr2 = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr2.length;
        System.out.println("Length of lis is " + lIS.lis( arr2 ) + "\n" );

    }
}
