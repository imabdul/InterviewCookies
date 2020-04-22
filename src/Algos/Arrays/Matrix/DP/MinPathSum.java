package Algos.Arrays.Matrix.DP;

/**
 * Created by abdul on 4/20/20.
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Used 2d DP Approach to solve this problem, key is to start filling dp array from bottom right cell
 *
 * Space and Time complexity : O(m*n)
 */

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=grid.length-1; i>=0;i--){
            for(int j=grid[0].length-1; j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }
                else if(i!=grid.length-1 && j==grid[0].length-1){
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }
                else if(i!=grid.length-1 && j!=grid[0].length-1){
                    dp[i][j]=grid[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
                }
                else{
                    dp[i][j]=grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        int[][] test1 = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        MinPathSum mps = new MinPathSum();
        System.out.println(mps.minPathSum(test1)); // answer is 7
    }
}
