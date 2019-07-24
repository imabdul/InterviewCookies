package Algos.Arrays.BinarySearchProblems;

/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
exactly same as MinimumInRotatedSortedArray, the only difference is array might contains duplicate elements.

good explanation --> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/167981/Beats-100-Binary-Search-with-Explanations

Essence
If we split the array with mi into [lo, mi] and [mi, hi]. If [lo, mi] is not sorted, since we detect [lo, mi] is not sorted by nums[lo] > nums[mi] so nums[lo] cannot be min, min must be within (lo, mi]. If [mi, hi] is not sorted, min must be within (mi, hi] - since we detect [mi, hi] is not sorted by nums[mi] > nums[hi], nums[mi] cannot be min. If they are both sorted, nums[lo] is the min.
There are 4 kinds of relationship among num[lo], nums[mi], nums[hi]

nums[lo] <= nums[mi] <= nums[hi], min is nums[lo]
nums[lo] > nums[mi] <= nums[hi], (lo, mi] is not sorted, min is inside
nums[lo] <= nums[mi] > nums[hi], (mi, hi] is not sorted, min is inside
nums[lo] > nums[mi] > nums[hi], impossible

 */

public class MinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums==null || nums.length<1) return -1;
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[hi])lo = mid+1;
            else if(nums[mid]<nums[hi]) hi=mid;
            else hi--;  // when num[mid] and num[hi] are same

        }
        return nums[lo];
    }

    public static void main(String[] main){
        int[] test1 = new int[] {1,3,5};
        int[] test2 = new int[] {2,2,2,0,1};
        MinimumInRotatedSortedArrayII getMin = new MinimumInRotatedSortedArrayII();
        int result1 = getMin.findMin(test1);
        System.out.println(result1);  //expected 1
        int result2 = getMin.findMin(test2);
        System.out.println(result2); //expected 0

    }
}
