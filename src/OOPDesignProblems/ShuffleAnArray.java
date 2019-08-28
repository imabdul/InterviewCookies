package OOPDesignProblems;
import java.util.Arrays;
import java.util.Random;


//Shuffle a set of numbers without duplicates
/*
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */

// apply fisher-yates Algorithm
public class ShuffleAnArray {
    private int[] nums;
    private Random random;
    public ShuffleAnArray(int[] nums) {
        this.nums=nums;
        this.random=new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums==null) return nums;
        int[] a = nums.clone();
        for(int i=1; i<nums.length; i++){
            int j = random.nextInt(i+1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }

    public static void main(String[] Args){
        int[] arr = new int[] {1,2,3};
        ShuffleAnArray shuf = new ShuffleAnArray(arr);
        int [] shuffleResult = shuf.shuffle();
        System.out.println(Arrays.toString(shuffleResult));
        int[] resetResult = shuf.reset();
        System.out.println(Arrays.toString(resetResult));
    }
}
