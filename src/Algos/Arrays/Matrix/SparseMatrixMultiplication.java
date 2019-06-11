package Algos.Arrays.Matrix;

import java.util.Arrays;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        //Google, Apple, FB frequently asked question
        //https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76151/54ms-Detailed-Summary-of-Easiest-JAVA-solutions-Beating-99.9 - Interesting explanation
        //formula for matrix multiplication --> C[ i ][ j ] = A[ i ][0]*B[0][j] + A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... A[i][K]*B[K][j]

        int m=A.length;
        int n=A[0].length;
        int nB=B[0].length;

        int[][] C = new int[m][nB];

        for(int i=0; i<m; i++){
            for(int k=0; k<n;k++){
                if(A[i][k]!=0){
                    for(int j=0; j<nB; j++){
                        if(B[k][j]!=0) C[i][j]+=A[i][k]*B[k][j];
                    }
                }
            }
        }
        return C;
    }



    public static void main(String [] Args){
        int[][] matrix1 ={
                { 1, 0, 0},
                {-1, 0, 3}
        };
        int[][] matrix2 ={
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        SparseMatrixMultiplication smm = new SparseMatrixMultiplication();
        System.out.println(Arrays.deepToString(smm.multiply(matrix1,matrix2))); //expected---> [[7,0,0],[-7,0,3]]
    }
}
