/*Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]*/

package Algos.Arrays.Sum;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSumII(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> uniqComb = new ArrayList<>();
        dfsDo(nums , 0, target, uniqComb, combinations);
        return combinations;
    }

    public void dfsDo(int[] nums, int curr, int target, List<Integer> uniqComb, List<List<Integer>> combinations){
        {
            if(target==0){
                combinations.add(new ArrayList<>(uniqComb));
            }
            if(target < 0) return;

            for(int i=curr; i<nums.length; i++){
                if(i>curr && nums[i]==nums[i-1])continue;
                uniqComb.add(uniqComb.size(),nums[i]);
                dfsDo(nums,i+1,target-nums[i],uniqComb,combinations);
                uniqComb.remove(uniqComb.size()-1);

            }

        }
    }

    public static void main(String[] args){
        CombinationSumII cs = new CombinationSumII();
        int[] test = new int[] {10,1,2,7,6,1,5};
        List<List<Integer>> ans = cs.combinationSumII(test,8);
        for(List l: ans){
            System.out.println(l);
        }
    }


}
