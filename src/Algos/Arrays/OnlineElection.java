package Algos.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
/**
 * Common interview Question Apple
 * https://leetcode.com/problems/online-election/discuss/173387/Java-two-methods-with-comment-using-TreeMap-and-binary-search-respectively
 */

public class OnlineElection {
    private HashMap<Integer, Integer> map = new HashMap<>(); //to store time and leading candidate;
    private int[] times;
    public OnlineElection(int[] persons, int[] times) {
        this.times=times;
        int[] count = new int[persons.length+1]; // count[i]: count of votes for persons[i].
        for (int i=0, winner =-1; i<times.length;++i){
            ++count[persons[i]]; //at times[i], persons[i] got a vote.
            // is persons[i] leading? update winner.
            if(map.isEmpty() || count[winner]<=count[persons[i]]) winner=persons[i];
            map.put(times[i],winner); // update time and winner.
        }
    }

    public int q(int t) {
        int idx = Arrays.binarySearch(times, t); // search for the time slot. //important: index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
        return map.get(times[idx < 0 ? -idx -2 : idx]); // fetch the corresponding information. //
    }

    public static void main(String[] args){

        int[] persons = new int [] {0,1,1,0,0,1,0};
        int[] times = new int [] {0,5,10,15,20,25,30};
        OnlineElection oe = new OnlineElection(persons,times);
        List<Integer> testList = new ArrayList<>();
        testList.add(3);
        testList.add(12);
        testList.add(25);
        testList.add(15);
        testList.add(24);
        testList.add(8);

        for (int i: testList){
            System.out.print(oe.q(i) + " "); //expected [0,1,1,0,0,1]
        }
    }
}
