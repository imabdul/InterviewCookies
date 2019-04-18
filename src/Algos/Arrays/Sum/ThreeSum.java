package Algos.Arrays.Sum;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null)return result;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if (i==0 || nums[i]>nums[i-1]) {
                int start = i + 1;
                int end = nums.length - 1;
                //List<Integer> sumList = new ArrayList<>();
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        List<Integer> sumList = new ArrayList<>();
                        sumList.add(nums[i]);
                        sumList.add(nums[start]);
                        sumList.add(nums[end]);
                        result.add(sumList);
                        start++;
                        end--;
                    }
                    else if (nums[i] + nums[start] + nums[end] < 0) {
                        int temp = nums[start];
                        while (start < end && temp == nums[start]) start++;
                    } else {
                        int temp = nums[end];
                        while (end > start && temp == nums[end]) end--;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] Args){

        ThreeSum ts = new ThreeSum();
        int[] testThreeSum = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans =ts.threeSum(testThreeSum);
        for(List l: ans){
            System.out.println(l);
        }


    }
}
