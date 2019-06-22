package Algos.Arrays;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean destroyed;
        for(int ast : asteroids){
            destroyed=false;
            while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                if (stack.peek() < -ast) {
                    stack.pop();
                    continue;
                }else if (stack.peek() == -ast) {
                    stack.pop();
                    destroyed=true;
                    break;
                }else {
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(ast);
            }
        }

        int [] result = new int[stack.size()];

        for(int i=result.length-1; i>=0; i--){
            result[i]=stack.pop();
        }
        return result;
    }

    public static void main(String[] Args){
        int[] test1 =new int[] {5, 10, -5};
        int[] test2 =new int[] {8, -8};
        int[] test3 =new int[] {10, 2, -5};
        int[] test4 =new int[] {-2, 1, -1, -2};

        AsteroidCollision ac = new AsteroidCollision();
        int[] result1 = ac.asteroidCollision(test1);
        int[] result2 = ac.asteroidCollision(test2);
        int[] result3 = ac.asteroidCollision(test3);
        int[] result4 = ac.asteroidCollision(test4);

        System.out.println(Arrays.toString(result1));  // expected [5, 10]
        System.out.println(Arrays.toString(result2));  // expected []
        System.out.println(Arrays.toString(result3));  // expected [10]
        System.out.println(Arrays.toString(result4));  // expected [-2, -2]


    }

}