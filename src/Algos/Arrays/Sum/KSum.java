package Algos.Arrays.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum {
    public List<List<Integer>> kSum(int[] nums, int target) {

        if (nums == null || nums.length < 1) return null;
        Arrays.sort(nums);
        return KSumHelper(nums, target, 4, 0);
    }

    public List<List<Integer>> KSumHelper(int[] nums , int target , int k, int index){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(index>=len)return result;
        if (k==2){
            int start = index;
            int end =len-1;
            while(start<end){
                if(target-nums[start]==nums[end]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    while(start<end && nums[start]==nums[start+1])start++;
                    while(start<end && nums[end]==nums[end-1])end--;
                    start++;
                    end--;
                }
                else if(target-nums[start]>nums[end]) start++;
                else end--;
            }
        }
        else{
            for(int i=index; i<len-k+1; i++){
                List<List<Integer>> tmpList = KSumHelper(nums, target-nums[i], k-1, i+1);
                if(tmpList!=null){
                    for(List l : tmpList) l.add(0,nums[i]);
                    result.addAll(0,tmpList);
                }

                while(i<len-k+1 && nums[i]==nums[i+1]){
                    i++;
                }

            }
        }

        return result;
    }


    public static void main(String[] Args){
        KSum ks = new KSum();
        int[] test4Sum = new int[] {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ans =ks.kSum(test4Sum, 0 );
        for(List l: ans){
            System.out.println(l);
        }
    }

}
