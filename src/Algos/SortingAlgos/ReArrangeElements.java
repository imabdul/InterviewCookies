package Algos.SortingAlgos;
/**
 * Write a program that takes an array A and an index i into A, and rearranges
 * the elements such that all elements less than A[i] (the 'pivot') appear
 * first, followed by elements equal to the pivot followed by elements greater
 * than the pivot.
 *
 * eg A = [4,5,6,4,5,6,4,5,6]
 * i=0 result [4 4 4 5 6 5 6 5 6] or [4 4 4 5 5 5 6 6 6]
 * i=1 result [4 4 4 5 5 5 6 6 6]
 * i=2 result [4 5 4 5 4 5 6 6 6] or [4 4 4 5 5 5 6 6 6] or [5 5 5 4 4 4 6 6 6]
 **/

//Asked in Uber Telephonic
public class ReArrangeElements {

    public int[] reArrange(int[] arr, int index){
        if (index > arr.length - 1 || index < 0) {
            return arr;
        }
        int pivot = arr[index];

        // Find all smaller elements, and put to start of the array.
        int searcher = 0;
        int builder = 0;
        while (searcher < arr.length) {
            if (arr[searcher] < pivot) {
                swap(arr, searcher, builder++);
            }
            searcher++;
        }

        // Find all bigger elements, and put to end of the array.
        searcher = arr.length - 1;
        builder = arr.length - 1;
        while (searcher >= 0) {
            if (arr[searcher] > pivot) {
                swap(arr, searcher, builder--);
            }
            searcher--;
        }

        return arr;

    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    public static void main(String [] Args){
        int[] testArray= new int [] {4,5,6,4,5,6,4,5,6};
        ReArrangeElements re = new ReArrangeElements();
        int[] result = re.reArrange(testArray, 1);
        for (int i: result) {
            System.out.print(i + " ");
        }

    }

}
