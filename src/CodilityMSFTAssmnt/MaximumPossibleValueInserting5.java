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
            // write your code here
            StringBuilder s = new StringBuilder(String.valueOf(Math.abs(N)));
            int flag;
            if(N>=0) {
                flag = 1;
            }
            else{
                flag=-1;
            }
            int index = 0;
            if (N >= 0) {
                while (index <= s.length()-1 && (s.charAt(index) - '0') >= 5) {
                    index++;
                }
                s.insert(index, 5);
            } else {
                while (index < s.length()-1 && (s.charAt(index) - '0') <= 5)
                    index++;
                s.insert(index, 5);
            }
            int res = Integer.parseInt(s.toString());
            return res * flag;

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
