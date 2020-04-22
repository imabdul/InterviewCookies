package Algos.Arrays;
import java.util.Arrays;

/**
 * Created by Abdul on 3/26/20.
 * https://leetcode.com/problems/product-of-array-except-self/
 * 238. Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * Note: Please solve it without division and in O(n).
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

/**
 * Idea:
 *To understand it easily, let me explain it with an example.
 * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

 * Numbers:     2    3    4     5
 * Lefts:            2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5
 * Let’s fill the empty with 1:

 * Numbers:     2    3    4     5
 * Lefts:       1    2  2*3 2*3*4
 * Rights:  3*4*5  4*5    5     1
 * We can calculate lefts and rights in 2 loops. The time complexity is O(n).

 * We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
 * Clear code with comments:

 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        // Calculate lefts and store in res.
        int left=1;
        for(int i=0; i<len; i++){
            if(i>0) left*=nums[i-1];
            result[i]=left;
        }

        // Calculate rights and the product from the end of the array.
        int right=1;
        for(int i=len-1; i>=0; i--){
            if(i<len-1) right*=nums[i+1];
            result[i]*=right;
        }
        return result;
    }

    public static void main(String[] Args ){
        ProductExceptSelf pes= new ProductExceptSelf();
        int[] test1 = new int[] {1,2,3,4}; //[24,12,8,6]
        System.out.println(Arrays.toString(pes.productExceptSelf(test1))); //output must be [24, 12, 8, 6]

    }
}


