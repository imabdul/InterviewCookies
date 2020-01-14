package CodilityMSFTAssmnt;

public class FairIndexProblem {


    public int fairIndexes(int[] A, int[] B) {

        int length = A.length;
        // Arrays to store the incremental sum of both array elements
        int[] arrASumIncremental = new int[length + 1];
        int[] arrBSumIncremental = new int[length + 1];
        for (int index = 1; index <= length; index++) {
            arrASumIncremental[index] = arrASumIncremental[index - 1] + A[index - 1];
            arrBSumIncremental[index] = arrBSumIncremental[index - 1] + B[index - 1];
        }
        int totalFairIndices = 0;
        for (int index = 1; index < length; index++) {
            // all possible indexes check if sum is same for all four sub arrays
            if (arrASumIncremental[index] == arrBSumIncremental[index] &&
                    arrASumIncremental[index] == arrASumIncremental[length] - arrASumIncremental[index] &&
                    arrBSumIncremental[index] == arrBSumIncremental[length] - arrBSumIncremental[index])
                totalFairIndices++;
        }
        return totalFairIndices;
    }
}
