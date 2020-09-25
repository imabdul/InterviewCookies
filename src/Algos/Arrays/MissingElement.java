package Algos.Arrays;

public class MissingElement {
    public int missingNumber(int[] nums) {
        int missing= nums.length;
        for(int i=0; i<nums.length;i++){
            missing ^= i^nums[i];
        }
        return missing;
    }
    public static void main(String[ ] args){
        MissingElement me = new MissingElement();
        int[] test1 = new int[]{3,0,1};
        System.out.println(me.missingNumber(test1)); //expected 2

        int[] test2 = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(me.missingNumber(test2)); //expected 8
    }


}
