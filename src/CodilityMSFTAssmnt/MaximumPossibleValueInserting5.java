package CodilityMSFTAssmnt;

public class MaximumPossibleValueInserting5 {
    /*
		Write a function solution that, given an integer N, returns the maximum possible value obtained by inserting one '5'
		digit inside the decimal representation of integer N.
		Examples:
		1. Given N = 268, the function should return 5268.
		2. Given N = 670, the function should return 6750.
		3. Given N = 0, the function should return 50.
		4. Given N = -999, the function should return -5999
		Assume that:
			- N is an integer within the range [-8 000..8 000]
		In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
    */

    public static int solution(int N) {
        String n = "" + Math.abs(N);
        int[] res = new int[n.length()];
        for (int i = 0; i < n.length(); i++){
            int aux = Integer.parseInt(n.substring(0, i) + 5 + n.substring(i, n.length()));
            if (N < 0) res[i] = -aux;
            else res[i] = aux;
        }
        int max = Integer.MIN_VALUE; // could also be -58001 since N doesn't go below -58000
        for (int i = 0; i < res.length; i++) max = Math.max(max, res[i]);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(268));      //   5268
        System.out.println(solution(670));      //   6750
        System.out.println(solution(0));        //     50
        System.out.println(solution(-999));     //  -5999
        System.out.println(solution(8000));     //  85000
        System.out.println(solution(-8000));    // -58000

        // works!!
    }
}
