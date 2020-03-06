
package AmznAssmnt;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class TpNCmpttrs
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> topNCompetitors(int numCompetitors,
                                             int topNCompetitors,
                                             List<String> competitors,
                                             int numReviews,
                                             List<String> reviews) {
        if (Objects.isNull(reviews) || reviews.isEmpty()
                || Objects.isNull(competitors) || competitors.isEmpty()
                || numReviews < 1 || numCompetitors < 1)
            return new ArrayList<>();

        ArrayList<String> topNCompetitorsList = new ArrayList<>(topNCompetitors);

        Set<String> competitorsSet = new HashSet<>(competitors);
        Map<String, Integer> topCompetitorsMap = new HashMap<>();

        // clean the reviews first: lowercase, remove special characters and split by spaces.
        reviews.forEach(review -> {
            String[] reviewArray = review.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
            if (reviewArray.length > 0) {
                Set<String> tempCompetitorSet = new HashSet<>();

                for (String text : reviewArray) {
                    if (competitorsSet.contains(text) && !tempCompetitorSet.contains(text)) {
                        tempCompetitorSet.add(text);
                        if (topCompetitorsMap.containsKey(text)) {
                            topCompetitorsMap.put(text, topCompetitorsMap.get(text) + 1);
                        } else {
                            topCompetitorsMap.put(text, 1);
                        }
                    }
                }
            }
        });

        List<Map.Entry<String, Integer>> list = new ArrayList<>(topCompetitorsMap.entrySet());
        list.sort(new ValueThenKeyComparator<>());

        for (int i = 0; i < list.size(); i++) {
            if (topNCompetitorsList.size() < topNCompetitors)
                topNCompetitorsList.add(list.get(i).getKey());
            else
                break;
        }

        return topNCompetitorsList;
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

class ValueThenKeyComparator<K extends Comparable<? super K>,
        V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
        int cmp1 = b.getValue().compareTo(a.getValue());
        if (cmp1 != 0) {
            return cmp1;
        } else {
            return a.getKey().compareTo(b.getKey());
        }
    }
}