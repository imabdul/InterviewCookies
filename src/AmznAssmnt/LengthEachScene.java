package AmznAssmnt;

/**
 * Created by abdul
 * Complexity --> O(N)
 *
 *
 * Approach:
 * Used contant size(26) of Array and 2 pointers approach to solve this problem.
 *
 */
import java.util.*;
import static java.util.Arrays.asList;

public class LengthEachScene {
    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
        int[] last = new int[26];
        for (int i = 0; i < inputList.size(); ++i) {
            last[inputList.get(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList();
        for (int i = 0; i < inputList.size(); ++i) {
            j = Math.max(j, last[inputList.get(i) - 'a']);
            if (i == j) {
                //System.out.println(anchor);
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return result;

    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        List<Character> inputList1 = asList('a', 'b', 'c');
        List<Character> inputList2 = asList('a', 'b', 'c','a');
        //List<Character> inputList3 = asList('a', 'b', 'c');

        LengthEachScene les = new LengthEachScene();
        List<Integer> result1 = les.lengthEachScene(inputList1);
        System.out.println(result1.toString());
        List<Integer> result2 = les.lengthEachScene(inputList2);
        System.out.println(result2.toString());
    }


}

