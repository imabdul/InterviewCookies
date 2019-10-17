package Algos.Arrays.DP;

/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class MaxProfitWithKTransactions {
    public int maxProfit(int k, int[] prices) {
        /**
         * this is to cover edge cases, else not required. Not Necessary.
         */
        if (k >= prices.length / 2) return quickSolve(prices);

        /**
         * https://www.algoexpert.io/questions/Max%20Profit%20With%20K%20Transactions
         * good explanation.
         *
         * Crux : Idea is to solve it through DP. Have a 2D Array with K+1 rows and prices.length columns.
         * Formula consists of max of either below two:
         * 1. profits[t][d] will be either profit[t][d-1] or prices[d]+max of (profits[t-1][x]-prices[x]) where 0=<x<d
         **/
        int[][] profits = new int[k+1][prices.length];
        for(int t=1; t<k+1; t++){// t ~ number of transactions allowed
            int maxThusFar = Integer.MIN_VALUE;
            for(int d=1; d<prices.length; d++ ) {//number of days ~ prices.length
                maxThusFar=Math.max(maxThusFar, profits[t-1][d-1]-prices[d-1]);
                profits[t][d]=Math.max(profits[t][d-1], maxThusFar+prices[d]);
            }
        }

        return profits[k][prices.length-1];

    }

    /**
     * Don't need to explain in interview. Not required only to support edge cases when necessary.
     */

    private int quickSolve(int[] prices){
        int max=0;
        for(int i=1; i<prices.length;i++){
            if(prices[i]>prices[i-1]) max += prices[i]-prices[i-1];
        }
        return max;
    }


    public static void main(String[] Args){
        MaxProfitWithKTransactions mp = new MaxProfitWithKTransactions();
        int[] pricesTest1 = new int[]{2,4,1};
        int k1 = 2;
        /**
         * expected ==> 2
         */
        System.out.println(mp.maxProfit(k1, pricesTest1));

        int[] pricesTest2 = new int[]{5,11,3,50,60,90};
        int k2 = 2;
        /**
         * expected ==> 93
         */
        System.out.println(mp.maxProfit(k2, pricesTest2));

        int[] pricesTest3 = new int[]{3,2,6,5,0,3};
        int k3 = 2;
        /**
         * expected ==> 7
         */
        System.out.println(mp.maxProfit(k3, pricesTest3));
    }

}
