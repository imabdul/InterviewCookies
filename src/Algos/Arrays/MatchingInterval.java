package Algos.Arrays;

/**
 * Created by abdul on 4/7/20.
 * BytDance Phone Screen
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

Given a collection of intervals
One interval may include another interval, but there is no overlapping
For example,
    Yes: [1, 10] includes [2, 3], [4, 5]
     no: [2, 5]  overlaps [4, 6]

1. Design the structure to store intervals, and do best(smallest) match for given numbers.
    For example,
    Input:
        Intervals: [[2, 3], [1, 20], [15, 16], [2, 5], [1, 8], [9, 12], [6, 8]]
        Numbers: [3, 5, 7, 9, 15, 17, 40] //no sorted
    Output:
        [[2, 3], [2, 5], [6, 8], [9, 12], [15, 16], [1, 20], []]
    Explanation:
        3 is in [2, 3], [1, 20], [2, 5], [1, 8]     best match -> [2, 3]
        5 is in [2, 5], [1, 20],                    best match -> [2, 5]
        7 is in [1, 8], [6, 8], [1, 20]             best match -> [6, 8]
        ...

2. For M intervals and N numbers, what's time complexity of your code? O(N^2)
3. How can you improve the algorithm in your code?

psuedo code:
1. Loop through Numbers
2.
*/

class MatchingInterval{
    public int[][] findMatchingInterval(int[][] intervals, int[] numbers){
        int len = numbers.length;
        int[][] result =new int[len][2];
        for(int i=0; i< numbers.length;i++){
            int[] compare= new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};
            for(int j=0;j<intervals.length; j++){
                int dist1= numbers[i] - intervals[j][0];
                int dist2= intervals[j][1]-numbers[i];
                if(dist1 >= 0 && dist2>=0 ){
                    if(compare[0] >= intervals[j][0] && compare[1] <= intervals[j][1]){
                        continue;
                    }
                    else{
                        compare[0]=intervals[j][0];
                        compare[1]=intervals[j][1];
                        //System.out.println(intervals[j][0] +","+ intervals[j][1]);
                    }

                }

            }
            result[i][0]=compare[0];
            result[i][1]=compare[1];

        }
        return result;

    }

    public static void main(String[] args){
        int[][] intervals = new int[][]{
                {2, 3},
                {1, 20},
                {15, 16},
                {2, 5}, {1, 8}, {9, 12}, {6, 8}
        };

        int[] numbers = new int[]{3, 5, 7, 9, 15, 17, 40};

        MatchingInterval s = new MatchingInterval();
        int len = numbers.length;
        int result[][] = new int[len][2];

        result = s.findMatchingInterval(intervals, numbers);

        for (int[] arr: result){
            System.out.println(arr[0] +","+ arr[1]);
        }

    }


}