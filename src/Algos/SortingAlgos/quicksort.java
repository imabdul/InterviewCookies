/*
  Quicksort. Picking the pivot is 'pivotal' to the
  algorithm's performance ;)
  This version picks the last item in the partition space
  as the pivot everytime, there are many other ways to choose
  a pivot item.
  The video to explain this code is here: https://www.youtube.com/watch?v=uXBnyYuwPe8
*/

/*
  Top-level helper to help the caller pass less arguments in. We know that
  quicksort will start with considering the whole array
*/


package Algos.SortingAlgos;

public class quicksort {

    public void quicksort(int[] arr){
        quicksort(arr, 0, arr.length-1);

    }

    public void quicksort(int[] arr, int left, int right){
        if(left<right) {
            int pivotRestingPosition = partition(arr, left, right);
            quicksort(arr, left, pivotRestingPosition - 1);
            quicksort(arr, pivotRestingPosition, right);
        }
    }


    public int partition(int[] arr, int left, int right){

        int pivot = arr[right];
        int i= left-1;

        for(int j=left; j<right; j++){
            if(arr[j]<=pivot) {
                    i++;
                    swap(arr, i, j);
            }
        }
        swap(arr, i+1, right);
        return i+1;  //pivot position, at this point we know left is smaller than pivot and right is greater than pivot, so pivot has to be sandwiched between left and the right split.
    }

    public void swap(int[] arr, int first, int second){
        int tmp = arr[first];
        arr[first]=arr[second];
        arr[second]=tmp;
    }

    public static void main(String[] args){
        int[] arr = new int [] {3,7,8,2,1};
        quicksort qs = new quicksort();
        qs.quicksort(arr);

        for (int num: arr){
            System.out.print(num + " ");
        }


    }

}
