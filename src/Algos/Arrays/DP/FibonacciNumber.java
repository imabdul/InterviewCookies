package Algos.Arrays.DP;


/**
 * https://leetcode.com/problems/fibonacci-number/
 * Fibonacci Series using Dynamic Programming
 */
public class FibonacciNumber {
    public int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int[] dp = new int[n+2]; // 1 extra to handle case, n = 0

        /* 0th and 1st number of the series are 0 and 1*/
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            /* Add the previous 2 numbers in the series
         and store it */
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] Args){
        FibonacciNumber f = new FibonacciNumber();
        System.out.println(f.fib(0));
        System.out.println(f.fib(1));
        System.out.println(f.fib(2));
        System.out.println(f.fib(3));
        System.out.println(f.fib(4));
        System.out.println(f.fib(5));
        System.out.println(f.fib(6));
        System.out.println(f.fib(7));
    }



}
