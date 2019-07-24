package Algos.Arrays.BinarySearchProblems;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

/*
Approach is simple :
if the array is indeed rotated by some pivot, there are only 2 possibilities

a[mid] > a[left] && a[mid] > a[right], meaning we are on the bigger part, the smaller part is on our right, so go right
a[mid] < a[left] && a[mid] < a[right], meaning we are on the smaller part, to find the smallest element, go left
if the array is not rotated (actually one rotating cycle completed), we just need to go left, in this case a[mid] < a[right] always holds.

combining the cases above, we conclude that

if a[mid] > a[right], go right; if a[mid] < a[right], go left.
 */


public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums==null || nums.length<1) return -1;
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(mid>0 && nums[mid]<nums[mid-1]) return nums[mid];
            if(nums[mid] > nums[left] && nums[mid] > nums[right]) left=mid+1;
            else right=mid-1;
        }
        return nums[0];
    }

    public static void main(String[] Args){
        int[] test1 = new int[] {3,4,5,1,2};
        int[] test2 = new int[] {4,5,6,7,0,1,2};
        MinimumInRotatedSortedArray minInArr = new MinimumInRotatedSortedArray();
        int result1 = minInArr.findMin(test1);
        System.out.println(result1); //expected 1

        int result2 = minInArr.findMin(test2);
        System.out.println(result2); //expected 0

    }
}
