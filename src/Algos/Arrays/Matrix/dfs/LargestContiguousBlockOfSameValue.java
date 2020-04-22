package Algos.Arrays.Matrix.dfs;

/**
 * Created by abdul on 4/20/20.
 * similar to max area of Island
 * Doordash telephonic
 */
import java.util.*;
public class LargestContiguousBlockOfSameValue {
    public int largestContinuousBlockDFS(int [][] matrix){
        int largestContiguousBlock =0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]!=-1){
                    int prev = matrix[i][j];
                    largestContiguousBlock = Math.max(dfshelper(matrix, i,j, prev), largestContiguousBlock);
                }

            }
        }

        return largestContiguousBlock;
    }

    public int dfshelper(int[][] matrix, int i, int j, int prev){
        if(i>=0 && j>=0 && i<matrix.length && j<matrix[0].length &&  matrix[i][j]==prev){
            matrix[i][j]=-1;
            return 1+ dfshelper(matrix, i+1, j, prev) + dfshelper(matrix, i, j+1, prev) + dfshelper(matrix, i-1, j, prev) + dfshelper(matrix, i, j-1, prev);
        }
        return 0;
    }



    public static void main(String[] args) {
        LargestContiguousBlockOfSameValue s = new LargestContiguousBlockOfSameValue();

        int expected1 = 2;
        int [][] matrix1 = new int[][]{
                {1,2,3},
                {4,1,6},
                {4,5,1}
        };

        int expected2 = 4;
        int [][] matrix2 = new int[][]{
                {1,1,1,2,4},
                {5,1,5,3,1},
                {3,4,2,1,1}
        };

        int expected3 = 11;
        int [][] matrix3 = new int[][]{
                {3,3,3,3,3,1},
                {3,4,4,4,3,4},
                {2,4,3,3,3,4},
                {2,4,4,4,4,4}
        };

        int expected4 = 24;
        int [][] matrix4 = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };



        s.runTestCase(matrix1,expected1);
        s.runTestCase(matrix2,expected2);
        s.runTestCase(matrix3,expected3);
        s.runTestCase(matrix4,expected4);
    }

    public void runTestCase(int [][] matrix, int expected){
        int result = largestContinuousBlockDFS(matrix);
        if(result != expected){
            System.out.println("\n--Failed--");
            printMatrix(matrix);
            System.out.print("Expected: ");
            System.out.println(expected);
            System.out.print("Actual: ");
            System.out.println(result);
        } else {
            System.out.println("--PASSED--");
        }

    }

    private static void printMatrix(int [][] matrix){
        for (int i = 0 ; i < matrix.length ; i++){
            System.out.print('[');
            for (int j = 0 ; j < matrix[0].length ; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println(']');
        }
        System.out.println();
    }
}
