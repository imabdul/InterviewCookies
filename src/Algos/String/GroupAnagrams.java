package Algos.String;

/****
***Given an array of strings, group anagrams together.

***Example:

***Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
***Output:
***[
***  ["ate","eat","tea"],
***  ["nat","tan"],
***  ["bat"]
***]
***Note:

***All inputs will be in lowercase.
 ***The order of your output does not matter.
****/



import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length<1) return null;
        Arrays.sort(strs);
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs){
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String newWord = new String(sArr);

            if(!map.containsKey(newWord)){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newWord,list);
            }
            else{
                List<String> list = map.get(newWord);
                list.add(s);
            }

        }

        return new ArrayList<>(map.values());
    }



    public static void main(String[] args){
        String[] in = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams gAngms = new GroupAnagrams();
        List<List<String>> out = gAngms.groupAnagrams(in);
        System.out.println(Arrays.asList(out));

    }

}
