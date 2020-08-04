package Algos.Arrays.DP;

/**
 * Created by abdul on 8/4/20.
 * faq Apple onsite
 */

import java.util.*;
public class MaxBetweenIndexes {

    Integer[][] dp; // why Integer? cause Integer Array consists of null values by default

    public MaxBetweenIndexes(Integer n){
        dp= new Integer[n][n];
    }

    public int findMaxBetweenIndexes(int[] arr, int start, int end){

        if(dp[start][end]!=null) return dp[start][end];
        int max=Integer.MIN_VALUE;

        for(int i=start;i<end;i++){
            max=Math.max(max,arr[i]);
        }
        //System.out.println("final-->" + max); // to test whether the value is getting returned from cache
        dp[start][end]= max ;
        return max;
    }



    public static void main(String[] args){

        int [] test1 = new int[]{1,3,2,9,5,6,5,-1};
        int n = test1.length;
        MaxBetweenIndexes mbi = new MaxBetweenIndexes(n);
        System.out.println(mbi.findMaxBetweenIndexes(test1, 2,5)); //9
        System.out.println(mbi.findMaxBetweenIndexes(test1, 2,5)); //9
        System.out.println(mbi.findMaxBetweenIndexes(test1, 2,5)); //9



    }
}
