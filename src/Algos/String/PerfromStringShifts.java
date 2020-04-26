package Algos.String;
import java.util.*;

class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        char[] cArray = s.toCharArray();
        int n = cArray.length-1;
        HashMap<Integer, Integer> shiftCounts = new HashMap<>();
        shiftCounts.put(0,0);
        shiftCounts.put(1,0);
        boolean shiftFlag;
        for(int i=0; i<shift.length; i++){
            if(shift[i][0]==0)shiftCounts.put(0,shiftCounts.get(0)+shift[i][1]);
            else shiftCounts.put(1,shiftCounts.get(1)+shift[i][1]);
        }
        //System.out.println(shiftCounts.get(0));
        //System.out.println(shiftCounts.get(1));

        if(shiftCounts.get(0)==shiftCounts.get(1))return s;
        shiftFlag=shiftCounts.get(0)>shiftCounts.get(1) ?  false: true;
        if(shiftFlag){
            //char[] resultArr =
            int shiftRightCount=shiftCounts.get(1)-shiftCounts.get(0);
            System.out.println("moveRight->"  + shiftRightCount);
            moveRightHelper(cArray, shiftRightCount, n);
            return new String(cArray);
        }else {
            //char[] resultArr =
            int shiftLeftCount=shiftCounts.get(0)-shiftCounts.get(1);
            System.out.println("moveleft---> " + shiftLeftCount);
            moveLeftHelper(cArray, shiftLeftCount, n);
            return new String(cArray);
        }
    }

    void moveRightHelper(char[] cArray, int k, int n){
        k %= n+1;
        rotateArray(cArray,0,n);
        rotateArray(cArray,0,k-1);
        rotateArray(cArray,k, n);

    }
    void moveLeftHelper(char[] cArray, int k, int n){
        k %= n+1;
        rotateArray(cArray,0,n);
        rotateArray(cArray,n-k+1,n);
        rotateArray(cArray,0, n-k);
    }

    void rotateArray(char[] cArray, int start, int end){
        while (start<=end){
            char tmp = cArray[start];
            cArray[start++] = cArray[end];
            cArray[end--]=tmp;
        }
        //System.out.println(cArray);
    }

    public static void main(String[] args){
        String s1 = "abc";
        int[][] shift1 = {{0,1},{1,2}};
        PerformStringShifts pss = new PerformStringShifts();
        System.out.println(pss.stringShift(s1,shift1 ));
        String s2 = "abcdefg";
        int[][] shift2 = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(pss.stringShift(s2,shift2));


    }
}