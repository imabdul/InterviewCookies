package AmznAssmnt;


/**
 * you can go 1 step at a time in four directions, up,down,left & right. 1 can only turn it's adjacent to 1. 1 step means 1 hour.
 * How many hours it will take to turn whole grid into 1s.
 *
 *input -->
 * [[1,0,1,1,0,0]
 * [0,1,0,0,1,0]
 * [0,0,1,1,1,1]]
 *
 * Output --> 2
 */


import java.util.*;

public class MinimumDays {
    int[][] cache;

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        if (grid == null || grid.size() == 0) return 0;
        Queue<int[]> que = new LinkedList<>(); //queue will get coordinates of only 1's
        int zeroCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    que.add(new int[]{i, j});
                } else {
                    zeroCount++;
                }
            }
        }

        //if there's no zero at all int the grid return 0
        if (zeroCount == 0) return 0;
        int count = 0;

        //four possible directions up, down, right, left
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        //start bfs
        while (!que.isEmpty()) {
            ++count;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] point = que.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //check if the x or y is out of bound
                    //or it's already 1
                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid.get(x).get(y) == 1) continue;

                    //set the adjacent 4 sides 1
                    grid.get(x).set(y, 1);

                    //add next round of coordinates that turned into 1 recently to propogate 1s further
                    que.add(new int[]{x, y});
                    zeroCount--;
                }
            }

        }
        /**
         * Imagine you are doing BFS on a tree, starting from depth = 0, you do depth++ every level as you go down,
         * adding child nodes into the queue, and when you reach the last level where all the nodes are null(for instance) you are still doing depth++.
         * But essentially nulls are not required so you just do depth - 1 in the end and return. I hope you understood.
         */
        return zeroCount == 0 ? count - 1 : -1;
    }

    /**
     * Another solution with DFS Approach
     */
    private int dfs(int i, int j, int numRows, int numCols, List<List<Integer>> grid) {
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || grid.get(i).get(j) == 1) return 0;
        if (cache[i][j] != 0) return cache[i][j];
        else {
            int minDays = 1;
            minDays = Math.max(minDays, dfs(i + 1, j, numRows, numCols, grid));
            minDays = Math.max(minDays, dfs(i - 1, j, numRows, numCols, grid));
            minDays = Math.max(minDays, dfs(i, j + 1, numRows, numCols, grid));
            minDays = Math.max(minDays, dfs(i, j - 1, numRows, numCols, grid));
            cache[i][j] = minDays;
            return minDays;
        }
    }

    public static void main(String[] args){

        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        Integer[] arr1 = new Integer[]{1,0,1,1,0,0};
        Integer[] arr2 = new Integer[]{0,1,0,0,1,0};
        Integer[] arr3 = new Integer[]{0,0,1,1,1,1};
        list1.addAll(Arrays.asList(arr1));
        list2.addAll(Arrays.asList(arr2));
        list3.addAll(Arrays.asList(arr3));
        grid.add(list1);
        grid.add(list2);
        grid.add(list3);

        int numRows=3;
        int numCols=6;

        MinimumDays mD = new MinimumDays();
        System.out.println(mD.minimumDays(numRows,numCols,grid));

    }
}
