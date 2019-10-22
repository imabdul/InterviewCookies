package Algos.Arrays;

/**
 * Created by Abdul Malik
 *
 * Asked in Msft codility online assessment
 */

public class NumberOfIdenticalPairOfIndicesCodility {

    public static int solution(int[] A) {
        if(A == null)
            return 0;
        int n = A.length;
        if(n<2)
            return 0;
        int numPairs = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                //System.out.println("comparing " +A[i] +" and " + A[j] );
                if(A[i] == A[j]){
                    numPairs++;
                }
            }
        }
        if(numPairs > 1000000000)
            return 1000000000;
        return numPairs;
    }

    public static void main(String[] args) {
        int count = solution(new int[] {3,5,6,3,3,5});
        System.out.println("count :"+ count); //expected 4
    }
}
