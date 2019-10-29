package AmznAssmnt;
import java.util.*;

class ThreeProductSuggestions {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> sortedProducts;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            sortedProducts = new HashMap<String, Integer>();
            isWord = false;
        }
    }

    TrieNode root;
    String prefix;
    //int numProducts, List<String> repository, String customerQuery

    public List<List<String>> threeProductSuggestions(int numProducts, List<String> repository, String customerQuery) {
        root = new TrieNode();
        prefix = "";
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            add(repository.get(i), 1);
        }
        int len = customerQuery.length();
        //System.out.println(len);
        int h=1;
        char[] charArr = customerQuery.toCharArray();
        prefix=prefix+charArr[0];
        for (int i = 1; i < len; i++) {
            //System.out.println(h++);
            prefix = prefix + charArr[i];
            //System.out.println(prefix);
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->  a.getKey().compareTo(b.getKey()));
            pq.addAll(curr.sortedProducts.entrySet());
            int k = 3;
            List<String> res = new ArrayList<>();
            while (!pq.isEmpty() && k > 0) {
                res.add((String) pq.poll().getKey());
                k--;
            }
            //System.out.println(Arrays.asList(res));
            result.add(res);
        }

        return result;
    }

    public void add(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.sortedProducts.put(s, curr.sortedProducts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public static void main(String[] args){
        ThreeProductSuggestions tps = new ThreeProductSuggestions();
        int testNumProducts = 5;
        List<String> testRepository = new ArrayList<>();
        testRepository.add("mouse");
        testRepository.add("monitor");
        testRepository.add("mousepad");
        testRepository.add("moneypot");
        testRepository.add("mobile");
        String query = "mouse";
        List<List<String>> result= tps.threeProductSuggestions(5,testRepository,query);
        for(List<String> l: result) {
            System.out.println(Arrays.asList(l));
        }
    }
}
