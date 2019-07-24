/*package Algos.String;
import java.util.Arrays;
import java.util.*;
public class StringPermutaions {
    private List<String> result;
    public List<List<String>> findPermutations(String str){
        ArrayList<String> stringList = new ArrayList<>();
        char[] chrArr = str.toCharArray();
        backtracking(str, stringList );
        return result;
    }

    private void backtracking(String str,   ArrayList<String> stringList  ){
        //System.out.println(str);
        //System.out.println(str.substring(2)+str.substring(0,2));

        for(int i=0; i<str.length();i++){
            if(stringList.contains(i))
            stringList.add(str.substring(i)+str.substring(0,i));
            backtracking(str, i, stringList);
            stringList.remove(0);
        }
    }



    public static void main(String[] args){
        String test = "abc";
        StringPermutaions sp = new StringPermutaions();
        List<List<String>> ans = sp.findPermutations(test);
        for(List<String> l: ans) {
            System.out.println(l.toString());
        }
    }
}
*/