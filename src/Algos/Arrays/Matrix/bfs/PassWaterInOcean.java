package Algos.Arrays.Matrix.bfs;
/**
 * FAQ : AMZN ONST
 *
 * Start point given : Start --> {0,3}
 * Matrix given-->
 *                 O|[[6,5,5,4,7] |O
 *                 C| [2,6,5,4,7] |C
 *                 E| [1,1,1,3,1] |E
 *                 A| [2,6,5,2,1] |A
 *                 N| [6,6,2,4,1]]|N
 *  return the minimum distance to reach to the ocean , in this instance answer is 4
 *
 *  in this case: Possible ways for water to reach the ocean:
 *      4->4->3->1 (count is 4) | 4->4->3->2->1 (count is 5) | 4->4->3->1->1->1 (count is 6)
 *      since 4 is minimum, return 4
 *
 *  contraint: water can only flow through either smaller or equal value adjacent to the current cell(up, down, right, left).
 */


//incomplete, need to finish this

import java.util.*;
public class PassWaterInOcean {
    public static void main(String[] args){
        int[][] testData = new int[][]{
                {6,5,5,4,7},
                {2,6,5,4,7},
                {1,1,1,3,1},
                {2,6,5,2,1},
        };
        int[] start = new int[]{0,3};
        PassWaterInOcean pwo = new PassWaterInOcean();
        System.out.println(pwo.minPath(testData,start));
    }

    public int minPath(int[][] matrix, int[] start){
        int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int oceanQualifier1=0;
        int oceanQualifier2=matrix[0].length-1;

        Queue<int []> queue = new LinkedList<int[]>();
        queue.add(start);
        int minDistance=0;
        while(!queue.isEmpty()){
            int[] s = queue.remove();
            for (int[] dir: dirs){
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                if(x>=0 && y>=0 && x<matrix.length && y<matrix[0].length && matrix[x][y]< matrix[x-dir[0]][y-dir[1]]){
                    minDistance++;
                    //check if could be if or while
                    if(x==oceanQualifier1 || x==oceanQualifier2 ) return minDistance;
                    x+=dir[0];
                    y+=dir[1];

                }

            }

        }
        return -1;
    }
    }
}
