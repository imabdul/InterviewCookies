package Algos.Arrays.Sum;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)) return new int[]{i,map.get(compliment)};
            else map.put(nums[i],i);
        }

        return null;
    }


    public static void main(String[] Args){
        int [] nums = new int[] {2, 7, 11, 15};
        TwoSum ts= new TwoSum();
        int [] result = ts.twoSum(nums, 9);
        for(int num: result){
            System.out.println(num);
        }

    }

}
