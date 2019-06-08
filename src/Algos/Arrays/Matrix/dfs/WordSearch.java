/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */


package Algos.Arrays.Matrix.dfs;

public class WordSearch {
    public static void main(String[] args){
        char [][] board = new char [][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
        WordSearch ws = new WordSearch();
        String word1 = "ABCCED"; // true
        String word2 = "SEE"; //true
        String word3 = "ABCB"; //false
        System.out.println(ws.exist(board, word1));
        System.out.println(ws.exist(board, word2));
        System.out.println(ws.exist(board, word3));
    }

    public boolean exist(char[][] board, String word){

        char[] wordArr = word.toCharArray();
        for (int i=0 ; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if( helperDFS(board, i,j, wordArr,0 )) return true;
            }
        }
        return false;
    }

    public boolean helperDFS(char[][] board,  int i, int j, char[] wordArr, int index){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(board[i][j]==wordArr[index] && index ==wordArr.length-1) return true;
        if(board[i][j]!=wordArr[index])return false;
        board[i][j]^=256;
        boolean exists = helperDFS(board, i+1,j, wordArr,index+1)
                || helperDFS(board, i-1,j, wordArr,index+1)
                || helperDFS(board, i,j+1, wordArr,index+1)
                || helperDFS(board, i,j-1, wordArr,index+1);
        board[i][j]^=256;
        return exists;

    }


}
