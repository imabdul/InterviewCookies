/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]


Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.
 */
package Algos.Arrays.Matrix.dfs;

import java.util.ArrayList;
import java.util.List;
public class WordSearchII {

    public static void main(String[] Args){
        WordSearchII wS = new WordSearchII();
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}

        };
       String[] words = new String []{"oath","pea","eat","rain"};
        List<String> ans = wS.findWords(board,words);
        for(String s : ans){
            System.out.print(s + " ");
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfsMatchWords(board, i,j,root,ans);
            }
        }
        return ans;
    }

    public void dfsMatchWords(char[][] board, int i, int j, TrieNode p, List<String> ans){
        char c = board[i][j];
        if(c=='#' || p.next[c-'a'] == null) return;
        p=p.next[c-'a'];
        if(p.word!=null){  //found one
            ans.add(p.word);
            p.word=null;  // de-duplicate logic
        }

        board[i][j]='#';

        if(i>0) dfsMatchWords(board, i-1, j, p, ans);
        if(j>0) dfsMatchWords(board, i, j-1, p, ans);
        if(i<board.length-1) dfsMatchWords(board, i+1, j, p, ans);
        if(j<board[0].length-1) dfsMatchWords(board, i, j+1, p, ans);

        board[i][j]=c;

    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode p = root;
            for(char c: word.toCharArray()){
                int i = c-'a';
                if(p.next[i]==null) p.next[i]= new TrieNode();
                p=p.next[i];
            }
            p.word=word;
        }
        return root;
    }

}


class TrieNode{
    String word;
    TrieNode[] next  = new TrieNode[26]; //as 26 alphabetical characters.
}
