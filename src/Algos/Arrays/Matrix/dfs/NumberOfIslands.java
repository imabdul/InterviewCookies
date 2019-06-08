package Algos.Arrays.Matrix.dfs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)  return 0;

        int numIslands = 0;
        for(int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    numIslands += dfsDo(grid, i, j);
                }
            }
        }
        return numIslands;
    }



    private int dfsDo(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j >=grid[i].length || grid[i][j]=='0') return 0;
        grid[i][j]='0'; // this is sinking of the island in order to avoid revisit
        dfsDo(grid, i-1, j); //and now need to check adjacents
        dfsDo(grid, i+1, j);
        dfsDo(grid, i, j-1);
        dfsDo(grid, i, j+1);
        return 1;
    }


    public static void main(String[] args){
        char [][] testGrid1 = new char [][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char [][] testGrid2 = new char [][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands islands = new NumberOfIslands();
        System.out.println("numIslands in testGrid1 --> " + islands.numIslands(testGrid1)); //1
        System.out.println("numIslands in testGrid2 --> " + islands.numIslands(testGrid2)); //3


    }
}
