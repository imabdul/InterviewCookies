package CodilityMSFTAssmnt;

public class WithoutThreeConsecutive {
    public static void main(String[] args) {
        WithoutThreeConsecutive test = new WithoutThreeConsecutive();
        System.out.println(test.solution("baaaaa"));
        System.out.println(test.solution("baaabbaabbbaa"));
        System.out.println(test.solution("aaaaaaaaa"));
        System.out.println(test.solution("baabab"));
    }

    /**
     * Less lines of code but working solution
     */
    public int solution(String S) {
        int noOfSwaps = 0;
        for (int i = 0 ; i < S.length(); i++) {
            int len = 1;
            for (; i+1<=S.length()-1 && S.charAt(i) == S.charAt(i + 1); i++) {
                len++;
            }
            noOfSwaps += len / 3;
        }
        return noOfSwaps;
    }

    /**
     * More lines of code but working solution
     */
    /*
    public int solution(String S) {
        int result = 0;
        if (!S.contains("aaa") & !S.contains("bbb"))
            return 0;
        //flush A's
        int indexOfTripleA = -1;
        while ((indexOfTripleA = S.indexOf("aaa")) != -1) {
            if (S.length() == indexOfTripleA + 3) {
                S = S.substring(0, indexOfTripleA) + "aab";
                result++;
            }
            if (S.length() > indexOfTripleA + 3) {
                if (S.charAt(indexOfTripleA + 4) == 'a') {
                    S = S.substring(0, indexOfTripleA) + "aab" + S.substring(indexOfTripleA + 3);
                    result++;
                    continue;
                }
                if (S.charAt(indexOfTripleA + 4) == 'b') {
                    S = S.substring(0, indexOfTripleA) + "aba" + S.substring(indexOfTripleA + 3);
                    result++;
                }

            }
        }

        int indexOfTripleB = -1;
        while ((indexOfTripleB = S.indexOf("bbb")) != -1) {
            if (S.length() == indexOfTripleB + 3) {
                S = S.substring(0, indexOfTripleB) + "bba";
                result++;
            }
            if (S.length() > indexOfTripleB + 3) {
                if (S.charAt(indexOfTripleB + 4) == 'b') {
                    S = S.substring(0, indexOfTripleB) + "bba" + S.substring(indexOfTripleB + 3);
                    result++;
                }
                if (S.charAt(indexOfTripleB + 4) == 'a') {
                    S = S.substring(0, indexOfTripleB) + "bab" + S.substring(indexOfTripleB + 3);
                    result++;
                }
            }
        }


        return result;
    }
     */

}
