package Helpers;

/**
 * Created by abdul on 8/2/20.
 */

import java.util.*;
public class SortersAndComparators {

    public List<String> listComparator(List<String> list){
        Collections.sort(list, (a,b)->b.compareTo(a));
        return list;

    }


    public Integer[] ArraySorter(Integer[] arr){
        Arrays.sort(arr, (a,b)->b-a);
        return arr;

    }






    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("worlD");
        list1.add("USA");
        list1.add("China");
        list1.add("DingDong");

        SortersAndComparators sc = new SortersAndComparators();
        List<String> test1 =  sc.listComparator(list1);
        for(String s: test1){
            System.out.println(s);
        }

        System.out.println("-----------------------------------");


        Integer[] arr1  = new Integer[]{5,6,1,4,9,3};
        Integer[] test2 =  sc.ArraySorter(arr1);
        for(Integer i: test2){
            System.out.println(i);
        }

        System.out.println("-----------------------------------");

    }
}
