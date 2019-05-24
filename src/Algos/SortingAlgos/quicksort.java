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
        return i+1;
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
