package Algos.Arrays;
import java.sql.SQLOutput;
import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new LinkedList<>();

        // build hash map : character and how often it appears
        for(int i: nums){
            if(hm.containsKey(i)){
                int tmp = hm.get(i)+1;
                hm.put(i,tmp);
            }else{
                hm.put(i,1);
            }
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2) -> hm.get(n1)-hm.get(n2));

        //keep k top frequent elements in the heap
        for (int n: hm.keySet()){
            heap.add(n);
            if(heap.size()>k)heap.poll();
        }

        //build output list
        while(!heap.isEmpty()){
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;

    }

    public static void main(String[] Args){
        int[] test1 = new int[]{1,1,1,2,2,3};
        int[] test2 = new int[]{1};
        TopKFrequentElements  topk = new TopKFrequentElements();
        List<Integer> output1 = topk.topKFrequent(test1, 2); //expected [1,2]
        List<Integer> output2 =topk.topKFrequent(test2, 1); // expected [1]


        System.out.print("[ ");
        for(int i: output1) System.out.print(i + " ");
        System.out.print("]");

        System.out.println();

        System.out.print("[ ");
        for(int i: output2) System.out.print(i + " ");
        System.out.print("]");
    }
}
