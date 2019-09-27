package Algos.Arrays.Matrix;
/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Medium
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.*;

public class SpiralMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if(matrix == null | matrix.length< 1 || matrix[0].length<1) return result;
        int beginRow=0;
        int endRow=matrix.length-1;
        int beginCol=0;
        int endCol=matrix[0].length-1;

        while(beginRow<=endRow && beginCol<=endCol){
            for(int i=beginCol; i<=endCol; i++){
                result.add(matrix[beginRow][i]);
            }
            beginRow++;

            for(int i=beginRow; i<=endRow; i++){
                result.add(matrix[i][endCol]);
            }
            endCol--;
            if(endRow>=beginRow){
                for(int i=endCol; i>=beginCol; i--){
                    result.add(matrix[endRow][i]);
                }
                endRow--;
            }

            if(beginCol<=endCol){
                for(int i=endRow; i>=beginRow; i--){
                    result.add(matrix[i][beginCol]);
                }
                beginCol++;

            }


        }
        return result;
    }

    public static void main(String[] args){
        SpiralMatrixI sm = new SpiralMatrixI();
        int[][] matrixInput = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        List<Integer> list = sm.spiralOrder(matrixInput);
        System.out.println(list.toString()); //expected [1, 2, 3, 6, 9, 8, 7, 4, 5]

    }
}
