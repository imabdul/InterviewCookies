package Algos.Arrays.DP;

/**
 * https://leetcode.com/problems/triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * Referred video for explanation: https://www.youtube.com/watch?v=hM4mHTi4AnA
 *
 */

import java.util.*;
public class TriangleMinimumPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows= triangle.size();
        int[] DP = new int[rows + 1];
        //bottom up, level by level traversal
        for(int i=rows-1; i>=0; i--){
            //j<=i cause each step you may move to adjacent numbers on the row below . DP[j]=Math.min(DP[j],DP[j+1])+triangle.get(i).get(j)
            for(int j=0; j<=i; j++){
                DP[j]=Math.min(DP[j],DP[j+1])+triangle.get(i).get(j);
            }
        }
        return DP[0];
    }

    public static void main(String[] args){
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> level0 = new ArrayList<>();
        level0.add(2);

        List<Integer> level1 = new ArrayList<>();
        level1.add(3);
        level1.add(4);

        List<Integer> level2 = new ArrayList<>();
        level2.add(6);
        level2.add(5);
        level2.add(7);

        List<Integer> level3 = new ArrayList<>();
        level3.add(4);
        level3.add(1);
        level3.add(8);
        level3.add(3);


        list1.add(new ArrayList<>(level0));
        list1.add(new ArrayList<>(level1));
        list1.add(new ArrayList<>(level2));
        list1.add(new ArrayList<>(level3));


        List<List<Integer>> list2 = new ArrayList<>();
        List<Integer> layer0 = new ArrayList<>();
        layer0.add(2);

        List<Integer> layer1 = new ArrayList<>();
        layer1.add(3);
        layer1.add(4);

        List<Integer> layer2 = new ArrayList<>();
        layer2.add(6);
        layer2.add(7);
        layer2.add(2);

        List<Integer> layer3 = new ArrayList<>();
        layer3.add(4);
        layer3.add(1);
        layer3.add(8);
        layer3.add(3);


        list2.add(new ArrayList<>(level0));
        list2.add(new ArrayList<>(level1));
        list2.add(new ArrayList<>(level2));
        list2.add(new ArrayList<>(level3));



        TriangleMinimumPath tmp = new TriangleMinimumPath();
        System.out.println(tmp.minimumTotal(list1)); //11
        System.out.println(tmp.minimumTotal(list2)); //11

    }
}
