package AmznAssmnt;

/**
 * complexity --> O(N^2)
 *
 *
 * Approach:
 * wrote custom class Feature with featureName and frequency attributes
 * built a map to store feature and custom Feature object
 * Used max heap to sort the features based on it's frequency
 * prepared and returned the result list with required topFeatures
 *
 */

import java.util.*;

// "static void main" must be defined in a public class.
public class PopularNFeatures {
    public static void main(String[] args) {
        String[] featureRequests = new String[] {"storage, bc", "storage! af", "board asdf", "board qwerty qwerty"};
        String[] possibleFeatures = new String[] {"storage", "board", "qwerty", "asdfa"};
        PopularNFeatures pNF = new PopularNFeatures();
        System.out.println(pNF.popularNFeatures(
                6,5,
                Arrays.asList(possibleFeatures),
                3,
                Arrays.asList(featureRequests)
        ));
    }

    //method to handle case sensitivity
    public static String getCleansedString(String str) {
        return str.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }

    //method to handle null or empty spaces
    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    //custom class to maintain feature and it's frequency
    public static class Feature implements Comparable<Feature> {
        public String name;
        public int frequency;

        public Feature () {
        }
        public Feature (String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Feature b) {
            if(this.frequency == b.frequency) {
                return this.name.compareTo(b.name);
            }
            return Integer.compare(b.frequency, this.frequency);
        }
    }


    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {

        // WRITE YOUR CODE HERE
        ArrayList<String> result = new ArrayList<>();

        if(numFeatures <= 0 || topFeatures <= 0 || numFeatureRequests <= 0) return result;

        //case handling, converting sting into lower case
        for(int i = 0; i < possibleFeatures.size(); ++i) {
            possibleFeatures.set(i, getCleansedString(possibleFeatures.get(i)));
        }

        //using featureRequests & possibleFeatures: building a map of Feature and it's frequency
        Map<String,Feature> featureMap = new HashMap<>();

        for(String i : featureRequests) {
            String[] words = i.split(" ");
            Set<String> wordSet = new HashSet<>();
            for(String iWord : words) {
                wordSet.add(getCleansedString(iWord));
            }
            for(String iFeature : possibleFeatures) {
                if(wordSet.contains(iFeature)) {
                    featureMap.computeIfAbsent(iFeature, k -> new Feature(iFeature, 0)).frequency++;
                    wordSet.remove(iFeature); // Since it has to be considered only once.
                }
            }
        }

        if(featureMap.isEmpty()) return result;

        //sorting features based on their frequency
        PriorityQueue<Feature> featureMaxHeap = new PriorityQueue<>(featureMap.size());
        featureMaxHeap.addAll(featureMap.values());

        // preparing result list
        for(int i = 0; i < topFeatures && !featureMaxHeap.isEmpty(); ++i) {
            result.add(featureMaxHeap.poll().name);
        }
        return result;
    }
}


