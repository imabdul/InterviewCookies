package Algos.String.DP;

public class LongestCommonSubsequence {
    /* A Naive recursive implementation of LCS problem in java*/
    /*public int getLCS(char[] charArr1, char[] charArr2, int l1, int l2){
        if(l1==0 || l2==0) return 0;
        else if (charArr1[l1-1]== charArr2[l2-1]){
            return 1 + getLCS(charArr1, charArr2, l1-1,l2-1);
        }
        else{
            return Math.max(getLCS(charArr1, charArr2, l1,l2-1),getLCS(charArr1, charArr2, l1-1,l2));
        }

    }
*/
    public int getLCS(char[] charArr1, char[] charArr2, int l1, int l2){
        int[][] DP = new int[l1+1][l2+1];
        for (int i=0; i<=l1; i++){
            for (int j=0;j<=l2;j++){
                if(i==0 || j==0) DP[i][j]=0;
                else if(charArr1[i-1]==charArr2[j-1]) DP[i][j]=1+DP[i-1][j-1];
                else DP[i][j]=Math.max(DP[i-1][j],DP[i][j-1]);
            }
        }

        return DP[l1][l2];
    }

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.getLCS( X, Y, m, n ) );
    }

}
