package Algos.Arrays;

/**
 * Created by abdul on 5/6/20.
 * https://leetcode.com/problems/majority-element/
 *
 * 169. Majority Element
 * Easy
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count=0, ret=-1;
        for(int num: nums){
            if(count==0){
                ret=num;
                count++;
            }
            else if(ret!=num){
                count--;
            }
            else{
                count++;
            }
        }
        return ret;
    }

    public static void main(String[] Args){
        MajorityElement me = new MajorityElement();
        int[] sample1 = new int[]{3,2,3};
        int[] sample2 = new int[]{2,2,1,1,1,2,2};
        System.out.println(me.majorityElement(sample1)); // expected 3
        System.out.println(me.majorityElement(sample2)); // expected 2
    }
}
