package CodilityMSFTAssmnt;

public class ValidLongestSubstringWithTwoAsBs {
    public static int validLongestSubstring(String S) {
        if (S.length() < 3)
            return S.length();
        int cur = 0, end = 1;
        char c = S.charAt(0);
        int count = 1;
        int maxLen = 1;
        int start = 0;
        while (end < S.length()) {
            if (S.charAt(end) == c) {
                count++;
                if (count == 2) {
                    if (end - cur + 1 > maxLen) {
                        maxLen = end - cur + 1;
                        start = cur;
                    }
                } else {
                    cur = end - 1;
                }
            } else {
                c = S.charAt(end);
                count = 1;
                if (end - cur + 1 > maxLen) {
                    maxLen = end - cur + 1;
                    start = cur;
                }
            }
            end++;
        }
        return maxLen;
    }
    public static void main(String[] Args){

        


    }
}
