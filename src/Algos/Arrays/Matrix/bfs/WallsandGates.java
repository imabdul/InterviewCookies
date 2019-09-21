package Algos.Arrays.Matrix.bfs;

/**
 * https://leetcode.com/problems/walls-and-gates/
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */

import java.util.*;

public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {

        if(rooms==null || rooms.length==0 ) return ;

        int r = rooms.length;
        int c = rooms[0].length;

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};


        Queue<int[]> que= new LinkedList<>();
        /**
         * Push all gates into queue first. Then for each gate update its neighbor cells and push them to the queue.
         */
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(rooms[i][j]==0) que.add(new int[]{i,j});
            }
        }
        /**
         *Repeating above steps until there is nothing left in the queue.
         */
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0 ; i<size; i++){
                int[] point = que.poll();
                for(int[] dir: dirs){
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    //check for out of bound, walls or non infinity
                    if(x<0||y<0||x>=r||y>=c||rooms[x][y]!=2147483647)continue;
                    rooms[x][y]=rooms[point[0]][point[1]]+1;
                    que.add(new int[]{x,y});
                }

            }
        }

    }

    public static void main(String[] Args){
        WallsandGates wng = new WallsandGates();
        int[][] testRooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        wng.wallsAndGates(testRooms);
        /**
         * expected output: [
         * [3,-1,0,1],
         * [2,2,1,-1],
         * [1,-1,2,-1],
         * [0,-1,3,4]
         * ]
         */
        System.out.println(Arrays.deepToString(testRooms));
    }
}
