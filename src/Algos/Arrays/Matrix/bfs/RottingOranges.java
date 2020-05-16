package Algos.Arrays.Matrix.bfs;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 * Example 1:
 * Input: [[2,1,1],
 *         [1,1,0],
 *         [0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: [[2,1,1],
 *         [0,1,1],
 *         [1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Note:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */

import java.util.*;
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Queue<int[]> que = new LinkedList<>();
        int freshCount = 0;
        int r = grid.length;
        int c = grid[0].length;
        /**
         * Put the position of all rotten oranges in queue
         * count the number of fresh oranges
         */
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    que.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        /**
         * if count of fresh oranges is zero --> return 0
         */

        if (freshCount == 0) return 0;
        //minutes count
        int count = 0;
        //up,down,left,right
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        //start bfs
        while (!que.isEmpty()) {
            ++count;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] point = que.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //check for out of bounds and if already rotten
                    if (x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == 2 || grid[x][y] == 0) continue;
                    grid[x][y] = 2;
                    que.add(new int[]{x, y});
                    freshCount--;
                }
            }
        }

        return freshCount == 0 ? count - 1 : -1;

    }

    public static void main(String[] Args){
        RottingOranges ro = new RottingOranges();
        int[][] testGrid= new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        /**
         * expected Output: 4
         */
        System.out.println(ro.orangesRotting(testGrid));

    }
}

