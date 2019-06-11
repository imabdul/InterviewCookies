package Algos.SortingAlgos;


import java.util.*;

public class MergeIntervals {

    //solution with 2D Array
    /*public int[][] merge(int[][] intervals) {
        if(intervals ==null || intervals.length<1) return null;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int [] interval : intervals){
            if (interval[0]<=newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else{
                newInterval=interval;
                result.add(newInterval);
            }
        }
       return result.toArray(new int[result.size()][]);
    }


    public static void main (String [] args){
        MergeIntervals mi = new MergeIntervals();

        int[][] test1 = new int [][]{{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(mi.merge(test1))); //expected [[1,6],[8,10],[15,18]]
        //int [][] result = mi.merge(test1);


    }
*/

    // same solution with list
    public List<interval> merge(List<interval> intervals) {
        if(intervals ==null || intervals.size()<1) return null;

        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });*/
        List<interval> result = new ArrayList<>();
        interval toBeCompared = intervals.get(0);
        result.add(toBeCompared);

        for(interval curr: intervals){
            if (curr.start<=toBeCompared.end) {
                toBeCompared.end = Math.max(toBeCompared.end, curr.end);
            }else{
                toBeCompared=curr;
                result.add(toBeCompared);
            }
        }
        return result;
    }


    public static void main (String [] args){
        MergeIntervals mi = new MergeIntervals();
        interval interval1 = new interval(1,3);
        interval interval2 = new interval(2,6);
        interval interval3 = new interval(8,10);
        interval interval4 = new interval(15,18);

        List<interval> test = new ArrayList<>();
        test.add(interval1);
        test.add(interval4);
        test.add(interval3);
        test.add(interval2);


        List<interval> result = mi.merge(test); //expected [[1,6],[8,10],[15,18]]
        for (interval i: result){
            System.out.print("[" + i.start + "," + i.end + "]" + " , ");
        }
        //int [][] result = mi.merge(test1);


    }
}

class interval{
    int start;
    int end;
    public interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
