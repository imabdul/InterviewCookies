package OOPDesignProblems;

import java.sql.SQLOutput;

public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n){
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player){
        int toAdd = player == 1 ? 1:-1;
        rows[row]+=toAdd;
        cols[col]+=toAdd;

        /*
         ** think about 00, 11, 22
         **/
        if(row==col){
            diagonal +=toAdd;
        }

        /*
        ** think about 02, 11, 20
        **/
        if(col==cols.length-row-1){
            antiDiagonal +=toAdd;
        }

        int size = rows.length;

        if((Math.abs(rows[row])==size) ||(Math.abs(cols[col])==size) || (Math.abs(diagonal)==size) || (Math.abs(antiDiagonal)==size)){
            return player;
        }
        return 0;
    }

    public static void main(String[] Args){
        TicTacToe ttt = new TicTacToe(3);
        System.out.println(ttt.move(0,0,1));
        System.out.println(ttt.move(0,2,-1));
        System.out.println(ttt.move(1,1,1));
        System.out.println(ttt.move(1,2,-1));
        System.out.println(ttt.move(2,2,1));
    }

}
