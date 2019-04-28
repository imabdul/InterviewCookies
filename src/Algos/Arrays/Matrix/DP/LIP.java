/* Leet Code Hard
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */


package Algos.Arrays.Matrix.DP;

public class LIP {
    public int longestIncreasingPath(int[][] matrix) {

        int max =0;
        int[][] cache = new int [matrix.length][matrix[0].length];
        for(int i=0; i< matrix.length;i++ ){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max,dfsDo(matrix, cache, i, j, Integer.MAX_VALUE));
            }
        }
        return max;
    }

    public int dfsDo(int[][] matrix, int[][] cache, int i, int j, int pre){
        if(i<0 || i>matrix.length-1 || j<0 || j>matrix[0].length-1 || matrix[i][j]>=pre) return 0;

        if(cache[i][j]!=0) return cache[i][j];

        else{
            int temp = 0;
            int curr = matrix[i][j];
            temp = Math.max(temp,dfsDo(matrix, cache,i-1,j, curr));
            temp = Math.max(temp,dfsDo(matrix, cache,i+1,j, curr));
            temp = Math.max(temp,dfsDo(matrix, cache, i,j-1, curr));
            temp = Math.max(temp,dfsDo(matrix, cache, i,j+1, curr));

            cache[i][j]=++temp;
            return temp;

        }
    }

    public static void main(String[] Args){
        int[][] matrix1 ={
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        LIP lip = new LIP();
        System.out.println("Longest increasing Path in matrix1 ---> " + lip.longestIncreasingPath(matrix1));


        int[][] matrix2 = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        System.out.println("Longest increasing Path in matrix2 ---> " + lip.longestIncreasingPath(matrix2));


    }
}
