package Algos.Arrays.DP;
/*
DP Problem | bottom up approach
https://leetcode.com/problems/coin-change/

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */

import java.util.Arrays;

public class CoinChangeRecursive {

   /* public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return findCoinChange(coins, amount, new int[amount]);
    }

    private int findCoinChange(int[] coins, int amount, int[] dp){
        if(amount<0) return -1;
        if (amount==0) return 0;
        if()

    }



    public static void main (String[] args){
        int[] coins= new int[] {1,2,5};
        int amount = 11;

        CoinChangeIterative cc = new CoinChangeIterative();
        int result = cc.coinChange(coins, amount);
        System.out.println(result);  //expected 3
    }*/
}
