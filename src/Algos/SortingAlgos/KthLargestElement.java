
/*
  Kth Largest Element in an Array - LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/
  This optimal solution has the same fundamental reasoning that QuickSort uses. (the partitioning subroutine)
  Check out that QuickSort video here: https://www.youtube.com/watch?v=uXBnyYuwPe8
  This code passes all Leetcode test cases as of April 18 2019
  Runtime: 1 ms, faster than 99.86% of Java online submissions for Kth Largest Element in an Array
  The video to explain this code is here: https://www.youtube.com/watch?v=hGK_5n81drs
*/

/*
  We make the assumption k is between 1 and n (where n is the length of the array)
  The 1st largest element is the largest element.
  The n'th largest element is the smallest element.
*/

package Algos.SortingAlgos;

import java.util.Random;

public class KthLargestElement {
    public int findKthLargest(int[] arr, int k){
        int n = arr.length;
        int left = 0;
        int right = n-1;

        Random rand = new Random(0);

        while (left<=right){
            int chosenPivotIndex = rand.nextInt(right - left + 1) + left;
            //System.out.print(chosenPivotIndex + " ");
            int finalPivotIndex = partition(arr,left,right,chosenPivotIndex);
            if(finalPivotIndex==n-k) return arr[finalPivotIndex];
            else if (finalPivotIndex>n-k) right = finalPivotIndex-1;
            else left= finalPivotIndex+1;
        }
        return -1;
    }

    private int partition(int[] arr, int left, int right, int pivotIndex){
        int pivotValue=arr[pivotIndex];
        int lesserItemsTailIndex=left;
        swap(arr, pivotIndex,right);

        for(int i=left; i<right;i++){
            if(arr[i]<pivotValue){
                swap(arr,i,lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        swap(arr,right,lesserItemsTailIndex);

        return lesserItemsTailIndex;

    }

    private void swap(int[] arr, int first, int second){
        int tmp = arr[first];
        arr[first]=arr[second];
        arr[second]=tmp;
    }


    public static void main(String[] args){
        int[] arr = new int [] {3,7,8,2,1};
        KthLargestElement kth = new KthLargestElement();
        System.out.println(kth.findKthLargest(arr,2));
        /*System.out.println(kth.findKthLargest(arr, 2));
        Random rand = new Random(0);
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt(6 - 0 + 1) + 0);
        System.out.println(rand.nextInt(6 - 0 + 1) + 0);*/


    }


}
