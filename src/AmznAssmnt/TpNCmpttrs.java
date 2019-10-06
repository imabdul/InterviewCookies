
package AmznAssmnt;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class TpNCmpttrs
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews)
    {
        // WRITE YOUR CODE HERE
        ArrayList<String> result = new ArrayList<>();
        if(reviews.size()<1) return result;
        HashMap<String, Integer> competitorsWithCount = new HashMap<>();

        //System.out.println(numCompetitors);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()!=o2.getValue()){
                    return o2.getValue() - o1.getValue();
                }
                else{
                    return o1.getKey().compareTo(o1.getKey());
                }
            }
        });

        for(String s: competitors) {
            int reviewsCount = 0;
            int count = 1;
            //while (count < numCompetitors) {
            for(String rs: reviews){
                if (rs.indexOf(s) >= 0) {
                    //System.out.println(s);
                    reviewsCount++;
                }
                if (count == numReviews) {
                    //System.out.println(reviewsCount +" : " + s);
                    competitorsWithCount.put(s,reviewsCount);
                }
                count++;
            }
        }


        int limit=0;
        for (Map.Entry<String,Integer> entry : competitorsWithCount.entrySet()){
            pq.add(entry);
            //System.out.println(entry.getKey() +" : " + entry.getValue());
        }

        if(topNCompetitors>numCompetitors){
            while(pq.size()>0){
                Map.Entry<String,Integer> entry = pq.poll();
                if(entry.getValue()==0) break;
                String stage = entry.getKey();
                result.add(stage);

            }
        }
        else{
            while(limit!=topNCompetitors){
                limit++;
                result.add(pq.poll().getKey());
            }
        }

        return result;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args){
        TpNCmpttrs tnc = new TpNCmpttrs();
        ArrayList<String> comp1 = new ArrayList<>();
        comp1.add("rock");
        comp1.add("stonecold");
        comp1.add("spiderman");
       // System.out.println(Arrays.asList(comp));
        ArrayList<String> revs1 = new ArrayList<>();
        revs1.add("rock is good");
        revs1.add("rock is best");
        revs1.add("stonecold is awesome");
        revs1.add("spiderman is good");
        revs1.add("spiderman is better");

        int numReviews1 = 5;
        int numCompetitors1 = 3;
        int topNCompetitors1=2;

        ArrayList<String> ls1 = tnc.topNCompetitors(numCompetitors1,topNCompetitors1,comp1,numReviews1,revs1);
        System.out.println(Arrays.asList(ls1)); //expected [rock, spiderman]

        System.out.println("---------------------------");

        ArrayList<String> comp2 = new ArrayList<>();
        comp2.add("maroon5");
        comp2.add("chainsmokers");
        comp2.add("shawn");
        ArrayList<String> revs2 = new ArrayList<>();
        revs2.add("maroon5 is good");
        revs2.add("maroon5 is best");
        revs2.add("chainsmokers is awesome");
        revs2.add("shawn is good");
        revs2.add("shawn is better");

        int numReviews2 = 5;
        int numCompetitors2 = 3;
        int topNCompetitors2 = 4;

        ArrayList<String> ls2 = tnc.topNCompetitors(numCompetitors2,topNCompetitors2,comp2,numReviews2,revs2);
        System.out.println(Arrays.asList(ls2)); //expected [maroon5, shawn, chainsmokers]

        System.out.println("---------------------------");
        ArrayList<String> comp3 = new ArrayList<>();
        comp3.add("Curry");
        comp3.add("durrant");
        comp3.add("james");
        ArrayList<String> revs3 = new ArrayList<>();
        revs3.add("durrant is good");
        revs3.add("Curry is best");
        revs3.add("Curry is awesome");
        revs3.add("durrant is good");
        revs3.add("Curry is better");

        int numReviews3 = 5;
        int numCompetitors3 = 3;
        int topNCompetitors3 = 3;

        ArrayList<String> ls3 = tnc.topNCompetitors(numCompetitors3,topNCompetitors3,comp3,numReviews3,revs3);
        System.out.println(Arrays.asList(ls3)); //expected [Curry, durrant, james]

    }
}