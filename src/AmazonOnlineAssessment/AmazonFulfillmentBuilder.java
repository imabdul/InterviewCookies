package AmazonOnlineAssessment;
/**
 * array = {3, 5, 2, 7}
 * minCost = (2 + 3) + ((2 + 3) + 5) + (((2 + 3) + 5) + 7)
 */
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonFulfillmentBuilder {
    public int minimumTime(int numOfParts, List<Integer> parts) {
        if (numOfParts == 0) {
            return 0;
        }
        int res = 0, count = 1;
        PriorityQueue<Integer> minheap = new PriorityQueue<>(parts);
        while (minheap.size() > 1 && count < numOfParts) {
            int part1 = minheap.poll();
            int part2 = minheap.poll();
            int cur = part1 + part2;
            minheap.offer(cur);
            res += cur;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        // numOfParts = 4, parts=[8,4,6,12]
        // output = 58
        AmazonFulfillmentBuilder test = new AmazonFulfillmentBuilder();
        List<Integer> parts = Arrays.asList(8, 4, 6, 12);
        int result = test.minimumTime(4, parts); //expected is 58
        List<Integer> parts2 = Arrays.asList(8);
        int result2 = test.minimumTime(1, parts2); //expected is 0 as only one part in the list
        System.out.println(result);
        System.out.println(result2);
    }

}