package Algos.Arrays;

/**
 *     You are given K sorted arrays, combine them into one sorted array.
 *
 *     Example 1: Given [[1, 3, 5], [1, 4, 7, 8]]. Output is [1, 1, 3, 4, 5, 7, 8].
 *     Example 2: Given [[2, 6, 7],
 *     [13],
 *     [20],
 *     [1, 7],
 *     [9, 10]]. Output is [1, 2, 6, 7, 7, 9, 10, 13, 20].
 *
 *     Resources
 *     -------------
 *     https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/MergeKSortedArrays/MergeKSortedArrays.java
 *     https://www.youtube.com/watch?v=ptYUCjfNhJY
 */

import java.util.*;
import java.util.stream.Collectors;

/**
  The ArrayEntry class serves to annotate the entries before
  we put them in the min heap. Then we can remember what array
  the item came from so if that item is ejected we can fetch the
  next item in the same array it came from to insert into the heap
*/

class ArrayEntry{
    int val;
    int id;
    public ArrayEntry(int val, int id){
        this.val=val;
        this.id=id;
    }
}


public class MergeKSortedArrays {

    public List<Integer> kSortedArray(List<List<Integer>> sortedArrays){
        /**
         * Create a list of iterators to keep track of what item we are at
         * in each array. The list has no values until we add iterators to it
         */
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

        /**
         * Populate the iterator list with a respective iterator for each list
         * (we will use these later to fetch the next items in processing)
         */
        for(List<Integer> array : sortedArrays){
            iters.add(array.iterator());
        }

        /**
         * We create a PriorityQueue. A heap is an implementation of the abstract
         * data type (ADT) "priority queue". We pass a comparator so it knows how
         * to order items so that the minimum item is at the top
         */
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        /**
         * Add the FIRST item from EACH list via the iterator we "juiced" out
         * of it before IF it has an item to add (is not empty).
         */
        for(int i=0; i<iters.size();i++){
            if(iters.get(i).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(i).next(),i));
            }
        }

        /**
         * While the min heap is not empty we:
         * Step 1.) Get the minimum item from the heap
         * Step 2.) Add the ArrayEntry's value to the result array
         * Step 3.) If the ejected entry has a next value, add that next item
         * as an annotated ArrayEntry object
         * And iteration continues...
         * When the min heap is entry we will have processed all
         * items in every array and have a full sorted result
         */
        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()){
            //step 1
            ArrayEntry ejectedItem = minHeap.poll();
            //step 2
            result.add(ejectedItem.val);
            //step 3
            if(iters.get(ejectedItem.id).hasNext()){
                minHeap.add(new ArrayEntry(iters.get(ejectedItem.id).next(), ejectedItem.id));
            }
        }
        return result; //result now holds all k sorted arrays merged into one sorted array

    }

    public static void main(String args[] ) throws Exception {

        int[][] test1 = new int[][] {{1, 3, 5},
                {1, 4, 7, 8}
        };
        List<List<Integer>> arrList1 =  new ArrayList<>();
        for(int[] a: test1){
            List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
            arrList1.add(l);
        }



        int[][] test2 = new int[][] {{2, 6, 7},
                {13},
                {20},
                {1,7},
                {9,10}
        };
        List<List<Integer>> arrList2 =  new ArrayList<>();
        for(int[] a: test2){
            List<Integer> l = Arrays.stream(a).boxed().collect(Collectors.toList());
            arrList2.add(l);
        }


        MergeKSortedArrays mk = new MergeKSortedArrays();
        List<Integer> result1 = mk.kSortedArray(arrList1);
        System.out.println(Arrays.asList(result1));

        List<Integer> result2 = mk.kSortedArray(arrList2);
        System.out.println(Arrays.asList(result2));

        //System.out.println("Hello World");
    }
}